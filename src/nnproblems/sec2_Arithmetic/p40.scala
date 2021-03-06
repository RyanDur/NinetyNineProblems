package nnproblems.sec2_Arithmetic

// Goldbach's conjecture.
// Goldbach's conjecture says that every positive even number greater than 2
// is the sum of two prime numbers. E.g. 28 = 5 + 23. It is one of the most
// famous facts in number theory that has not been proved to be correct in
// the general case. It has been numerically confirmed up to very large numbers
// (much larger than Scala's Int can represent). Write a function to find the
// two prime numbers that sum up to a given even integer.
//
// 28.goldbach
// (Int, Int) = (5,23)

object p40 extends App {
  import nnproblems.sec2_Arithmetic.S99Int._

  println(28.goldbach)
}
