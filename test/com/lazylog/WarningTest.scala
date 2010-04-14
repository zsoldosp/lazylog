package com.lazylog

import org.junit._
import Assert._

class WarningsTest {

  @Test
  def doesNotLogWarningsWhenWarningLevelIsDisabled = {
    val input = new TestScenarioInfo with LoggingDisabled
    input.excerciseSUT
    assertEquals(0, input.actualLogger.logWarningCallCount)
  }
  
  @Test
  def logsWarningsWhenWarningLevelIsEnabled = {
    val input = new TestScenarioInfo with LoggingEnabled
    input.excerciseSUT
    assertEquals(1, input.actualLogger.logWarningCallCount)
  }

  @Test
  def loggedValueIsEvaluatedWhenWarningIsEnabled = {
    val input = new CheckingMsgFactoryEvaluation with LoggingEnabled
    input.excerciseSUT
    assertTrue(input.hasBeenCalled)
  }

  @Test
  def loggedValueIsNotEvaluatedWhenWarningIsDisabled = {
    val input = new CheckingMsgFactoryEvaluation with LoggingDisabled
    input.excerciseSUT
    assertFalse(input.hasBeenCalled)
  }
}
