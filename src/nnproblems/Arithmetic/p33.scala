package nnproblems.Arithmetic

// Determine whether two positive integer numbers are coprime.
// Two numbers are coprime if their greatest common divisor equals 1.
// 35.isCoprimeTo(64)
// res0: Boolean = true

object p33 extends App {
  import nnproblems.Arithmetic.S99Int._

  println(35.coPrimeTo(64))
  println(34.coPrimeTo(64))
}
