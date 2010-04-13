/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lazylog

class LazyLogger (actualLogger : AbstractLogger) {
  def logWarning(msg : => String) = {
    if (actualLogger.shouldLogWarnings)
      actualLogger.logWarning(msg)
  }
}
