package com.lazylog

class LazyLogger (actualLogger : AbstractLogger) {
  def logWarning(msg : => String) = {
    if (actualLogger.shouldLogWarnings)
      actualLogger.logWarning(msg)
  }
}
