package nnproblems.sec2_Arithmetic

// Determine the greatest common divisor of two positive integer numbers.
// Use Euclid's algorithm.
// gcd(36, 63)
// res0: Int = 9

object p32 extends App {
  import nnproblems.sec2_Arithmetic.S99Int._

  println(gcd(36, 63))
  println(gcd(63, 36))
}
