package nnproblems.Logic_and_Codes

// Truth tables for logical expressions (2).
// Continue problem P46 by redefining and, or, etc as operators.
// (i.e. make them methods of a new class with an implicit conversion from Boolean.)
// not will have to be left as a object method.
//
// table2((a: Boolean, b: Boolean) => a and (a or not(b)))
// A     B     result
// true  true  true
// true  false true
// false true  false
// false false false

object p47 extends App {
  import nnproblems.Logic_and_Codes.S99Logic._

//  table2((a: Boolean, b: Boolean) => a and (a or not(b)))
//  println()
  table2((a: Boolean, b: Boolean) => a xor b)
}
