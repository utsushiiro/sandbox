package jp.utsushiiro.fpinscala

import org.scalatest.funsuite.AnyFunSuite

class E21Test extends AnyFunSuite {
  test("E21.fib") {
    assert(E21.fib(0) === 0)
    assert(E21.fib(1) === 1)
    assert(E21.fib(2) === 1)
    assert(E21.fib(3) === 2)
    assert(E21.fib(4) === 3)
  }
}
