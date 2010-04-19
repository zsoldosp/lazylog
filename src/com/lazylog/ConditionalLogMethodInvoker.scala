/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lazylog

class ConditionalLogMethodInvoker(enabled : Boolean, targetMethod : String => Unit) {
  def log(message : => String) {
    if (enabled)
      targetMethod(message)
  }
}