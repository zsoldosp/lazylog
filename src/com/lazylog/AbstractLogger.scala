/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lazylog

trait AbstractLogger {
  def shouldLogWarnings : Boolean;
  def logWarning(msg : String) : Unit;
}