package com.lazylog

class LazyLogger (actualLogger : AbstractLogger) {
  def logWarning(msg : => String) = {
    if (actualLogger.shouldLogWarnings)
      actualLogger.logWarning(msg)
  }

  def logError(msg : => String) = {
    if (actualLogger.shouldLogErrors)
      actualLogger.logError(msg)
  }

}
