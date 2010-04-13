package com.lazylog

import org.junit._
import Assert._

class LoggerStub(val shouldLogWarnings : Boolean) extends AbstractLogger {
  var logWarningCallCount = 0
  def logWarning(msg : String) : Unit = { logWarningCallCount += 1 }
}


trait TestScenarioInfo {
  def msgFactory = "some message"
  def shouldLogWarnings : Boolean
  val actualLogger = new LoggerStub(shouldLogWarnings)

  def excerciseSUT = new LazyLogger(actualLogger).logWarning(msgFactory)
}

trait LoggingEnabled { def shouldLogWarnings = true }
trait LoggingDisabled { def shouldLogWarnings = false }

trait CheckingMsgFactoryEvaluation extends TestScenarioInfo {
  var hasBeenCalled = false;
  override def msgFactory = {
    hasBeenCalled = true
    "some message"
  }
}

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
