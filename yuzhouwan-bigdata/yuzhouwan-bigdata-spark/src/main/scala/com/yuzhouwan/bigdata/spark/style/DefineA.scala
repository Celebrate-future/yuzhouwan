package com.yuzhouwan.bigdata.spark.style

/**
  * Copyright @ 2016 yuzhouwan
  * All right reserved.
  * Function：annotation
  *
  * @author Benedict Jin
  * @since 2015/11/20
  */
class DefineA

object DefineA {

  def main(args: Array[String]) {
    bigMistake()
  }

  @DefineAnnotation
  def bigMistake(): Unit = {
    println("Making a big mistake...")
  }
}
