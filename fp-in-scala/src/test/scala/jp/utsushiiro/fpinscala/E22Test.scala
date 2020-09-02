package jp.utsushiiro.fpinscala

import org.scalatest.funsuite.AnyFunSuite

class E22Test extends AnyFunSuite {
  test("E22.isSorted") {
    val compareInt = (x: Int, y: Int) => x < y

    assert(E22.isSorted(Array(), compareInt) === true)
    assert(E22.isSorted(Array(1), compareInt) === true)
    assert(E22.isSorted(Array(1,2,3,4,5), compareInt) === true)
    assert(E22.isSorted(Array(1,2,10,4,5), compareInt) === false)
  }
}
