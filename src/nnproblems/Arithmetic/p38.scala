package nnproblems.Arithmetic

// Compare the two methods of calculating Euler's totient function.
// Use the solutions of problems P34 and P37 to compare the algorithms.
// Try to calculate phi(10090) as an example.

object p38 extends App {
  import nnproblems.Arithmetic.S99Int._

  println(10090.totient)
//  println(10090.totientP34)  (1 to start).count(start.coPrimeTo)
}
