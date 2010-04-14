package com.lazylog

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