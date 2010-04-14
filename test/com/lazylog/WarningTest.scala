package com.lazylog

import org.junit._
import Assert._

class WarningsTest {

  @Test
  def doesNotLogWarningsWhenWarningLevelIsDisabled = {
    val input = new TestScenarioInfo with WarningDisabled
    input.verifyLogWarningBehaviour
    assertEquals(0, input.actualLogger.logWarningCallCount)
  }
  
  @Test
  def logsWarningsWhenWarningLevelIsEnabled = {
    val input = new TestScenarioInfo with WarningEnabled
    input.verifyLogWarningBehaviour
    assertEquals(1, input.actualLogger.logWarningCallCount)
  }

  @Test
  def loggedValueIsEvaluatedWhenWarningIsEnabled = {
    val input = new CheckingMsgFactoryEvaluation with WarningEnabled
    input.verifyLogWarningBehaviour
    assertTrue(input.hasBeenCalled)
  }

  @Test
  def loggedValueIsNotEvaluatedWhenWarningIsDisabled = {
    val input = new CheckingMsgFactoryEvaluation with WarningDisabled
    input.verifyLogWarningBehaviour
    assertFalse(input.hasBeenCalled)
  }
}
