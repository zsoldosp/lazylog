package com.lazylog

import org.junit._
import Assert._

class ErrorsTest {

  @Test
  def doesNotLogErrorsWhenErrorLevelIsDisabled = {
    val input = new TestScenarioInfo with ErrorDisabled
    input.verifyLogErrorBehaviour
    assertEquals(0, input.actualLogger.logErrorCallCount)
  }
  
  @Test
  def logsErrorsWhenErrorLevelIsEnabled = {
    val input = new TestScenarioInfo with ErrorEnabled
    input.verifyLogErrorBehaviour
    assertEquals(1, input.actualLogger.logErrorCallCount)
  }

  @Test
  def loggedValueIsEvaluatedWhenErrorIsEnabled = {
    val input = new CheckingMsgFactoryEvaluation with ErrorEnabled
    input.verifyLogErrorBehaviour
    assertTrue(input.hasBeenCalled)
  }

  @Test
  def loggedValueIsNotEvaluatedWhenErrorIsDisabled = {
    val input = new CheckingMsgFactoryEvaluation with ErrorDisabled
    input.verifyLogErrorBehaviour
    assertFalse(input.hasBeenCalled)
  }
}
