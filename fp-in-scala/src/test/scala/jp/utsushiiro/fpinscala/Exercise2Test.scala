package jp.utsushiiro.fpinscala

import org.scalatest.funsuite.AnyFunSuite

class Exercise2Test extends AnyFunSuite {
  test("fib") {
    assert(Exercise2.fib(0) === 0)
    assert(Exercise2.fib(1) === 1)
    assert(Exercise2.fib(2) === 1)
    assert(Exercise2.fib(3) === 2)
    assert(Exercise2.fib(4) === 3)
  }

  test("isSorted") {
    val compareInt = (x: Int, y: Int) => x < y

    assert(Exercise2.isSorted(Array(), compareInt) === true)
    assert(Exercise2.isSorted(Array(1), compareInt) === true)
    assert(Exercise2.isSorted(Array(1,2,3,4,5), compareInt) === true)
    assert(Exercise2.isSorted(Array(1,2,10,4,5), compareInt) === false)
  }

  test("curry") {
    val subInt: (Int, Int) => Int = (x, y) => x - y
    val curriedSub3Int: Int => Int => Int = Exercise2.curry(subInt)

    assert(subInt(100, 80) === curriedSub3Int(100)(80))
  }

  test("uncurry") {
    val subInt: Int => Int => Int = x => y => x - y
    val uncurriedSub3Int: (Int, Int) => Int = Exercise2.uncurry(subInt)

    assert(subInt(100)(80) === uncurriedSub3Int(100, 80))
  }

  test("compose") {
    val double: Int => Int = x => 2 * x
    val add5: Int => Int = x => x + 5
    val add5AndThenDouble = Exercise2.compose(double, add5)

    assert(add5AndThenDouble(5) === 20)
  }
}
