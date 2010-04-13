package com.lazylog

trait AbstractLogger {
  def shouldLogWarnings : Boolean;
  def logWarning(msg : String) : Unit;
}
