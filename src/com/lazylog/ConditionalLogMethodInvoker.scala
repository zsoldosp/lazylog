package com.lazylog

class ConditionalLogMethodInvoker(enabled : Boolean, targetMethod : String => Unit) {
  def log(message : => String) {
    if (enabled)
      targetMethod(message)
  }
}