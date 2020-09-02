package jp.utsushiiro.fpinscala

object Exercise2 {
  def fib(n: Int): Int = {
    @annotation.tailrec
    def go (n: Int, prev: Int, cur: Int): Int = {
      if (n == 0) prev
      else go(n-1, cur, prev + cur)
    }
    go(n, 0, 1)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean = {
      if (n == as.length - 1) true
      else if (!ordered(as(n), as(n + 1))) false
      else go(n + 1)
    }

    if (as.length == 0 || as.length == 1) true
    else go(0)
  }

  def curry[A,B,C](f: (A, B) => C): A => B => C = (a: A) => (b: B) => f(a, b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C = a => f(g(a))
}
