package com.shippable

import org.scalatest.junit.JUnitSuite
import junit.framework.Assert._
import org.junit.Test

class TestStuff extends JUnitSuite {
 val calc = new HelloWorld

 @ Test def readHelloWorld {
 	val result: Long = calc.returnValue("hello")
    assertEquals(1, result.toInt)
  }
}
