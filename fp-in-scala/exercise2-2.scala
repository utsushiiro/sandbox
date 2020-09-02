import scala.annotation.tailrec

object Exercise22 extends App {
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

    val compareInt = (x: Int, y: Int) => x < y
    println(isSorted(Array(1,3,5,7,9), compareInt))
    println(isSorted(Array(1,3,10,7,9), compareInt))
}