package com.lazylog

class LazyLogger (actualLogger : AbstractLogger) {
  val warning = new ConditionalLogMethodInvoker (
    actualLogger.shouldLogWarnings,
    actualLogger.logWarning
  )
  val error = new ConditionalLogMethodInvoker (
    actualLogger.shouldLogErrors,
    actualLogger.logError
  )
  def logWarning(msg : => String) = warning.log(msg)

  def logError(msg : => String) = error.log(msg);
}
