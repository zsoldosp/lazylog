/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lazylog

import org.apache.log4j._
import org.junit._
import Assert._
import java.io.ByteArrayOutputStream
import com.lazylog.log4j.Log4jFacade

class Log4jIntegrationTest {

  @Test
  def warningGoesThroughToLog4j = {
    val log4jLogger = new Log4jFacade()
    val stream = new ByteArrayOutputStream()
    val stringAppender = new WriterAppender(new SimpleLayout(), stream)
    log4jLogger.addAppender(stringAppender);

    val lazyLogger = new LazyLogger(log4jLogger)
    lazyLogger.warning.log("asdf")
    assertEquals("WARN - asdf\n", stream.toString())
  }
}
