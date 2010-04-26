package com.lazylog

class ConditionalLogMethodInvoker(enabled : => Boolean, private targetMethod : String => Unit) {
  def log(message : => String) {
    if (enabled)
      targetMethod(message)
  }
}