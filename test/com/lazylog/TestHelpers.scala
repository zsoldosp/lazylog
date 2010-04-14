package com.lazylog

class LoggerStub(val shouldLogWarnings : Boolean,
                 val shouldLogErrors : Boolean) extends AbstractLogger {
  var logWarningCallCount = 0
  def logWarning(msg : String) : Unit = { logWarningCallCount += 1 }
  var logErrorCallCount = 0
  def logError(msg : String) : Unit = { logErrorCallCount += 1 }
}


trait TestScenarioInfo {
  def msgFactory = "some message"
  def shouldLogWarnings = false
  def shouldLogErrors = false
  val actualLogger = new LoggerStub(shouldLogWarnings, shouldLogErrors)

  def verifyLogWarningBehaviour = new LazyLogger(actualLogger).logWarning(msgFactory)

  def verifyLogErrorBehaviour = new LazyLogger(actualLogger).logError(msgFactory)
}

trait WarningEnabled extends TestScenarioInfo { override def shouldLogWarnings = true }
trait WarningDisabled extends TestScenarioInfo { override def shouldLogWarnings = false }

trait ErrorEnabled extends TestScenarioInfo  { override def shouldLogErrors = true }
trait ErrorDisabled extends TestScenarioInfo { override def shouldLogErrors = false }

trait CheckingMsgFactoryEvaluation extends TestScenarioInfo {
  var hasBeenCalled = false;
  override def msgFactory = {
    hasBeenCalled = true
    "some message"
  }
}