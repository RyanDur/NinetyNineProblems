package nnproblems.Logic_and_Codes

// Gray code.
// An n-bit Gray code is a sequence of n-bit strings constructed
// according to certain rules. For example,
// n = 1: C(1) = ("0", "1").
// n = 2: C(2) = ("00", "01", "11", "10").
// n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
//
// Find out the construction rules and write a function to generate Gray codes.
// gray(3)
// res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
//
// See if you can use memoization to make the function more efficient.

object p49 extends App {
  import nnproblems.Logic_and_Codes.S99Logic._

  println(gray(1))
  println(gray(2))
  println(gray(3))
}
