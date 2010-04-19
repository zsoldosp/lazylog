package com.lazylog

import org.junit._
import Assert._

class ConditionalLogMethodInvokerTest {
  @Test
  def doesNotForwardMessageWhenDisabled = {
    new ConditionalLogMethodInvoker(false, _ => fail("Shouldn't be called.")).log("something")
  }

  @Test
  def forwardsMessageWhenEnabled = {
    var logMsg = "hello world"
    new ConditionalLogMethodInvoker(false, x => assertEquals(logMsg, x)).log(logMsg)
  }

  def assertLazyMessageFactoryEvaluation(isEnabled : Boolean, expectedFactoryCallCount : Int) {
    var counter = 0
    val sut = new ConditionalLogMethodInvoker(isEnabled, _ => {})
    def messageFactory : String = {
      counter += 1
      "blah"
    }
    sut.log(messageFactory)
    assertEquals(expectedFactoryCallCount, counter)
  }


  @Test
  def forwardedValueIsEvaluatedWhenEnabled = {
    assertLazyMessageFactoryEvaluation(true, 1)
  }

  @Test
  def forwardedValueIsNotEvaluatedWhenMessageIsDisabled = {
    assertLazyMessageFactoryEvaluation(false, 0)
  }

  @Test
  def targetMethodIsCalledOnlyOnceWhenEnabled = {
    var counter = 0
    new ConditionalLogMethodInvoker(true, _ => {counter += 1}).log("some message")
    assertEquals(1, counter)
  }
}
