package com.lazylog.log4j

import com.lazylog._
import org.apache.log4j._

class Log4jFacade extends AbstractLogger {
  val logger = Logger.getLogger("")

  def shouldLogWarnings : Boolean = true
  def logWarning(msg : String) : Unit = {
    logger.warn(msg)
  }

  def shouldLogErrors : Boolean = false
  def logError(msg : String) : Unit = {
  }

  def addAppender(appender : Appender) = {
    logger.addAppender(appender)
  }
}
