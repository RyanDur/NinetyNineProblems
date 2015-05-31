package nnproblems.Logic_and_Codes

// Truth tables for logical expressions.
// Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence)
// which return true or false according to the result of their respective operations;
// e.g. and(A, B) is true if and only if both A and B are true.
//
// and(true, true)
// res0: Boolean = true
// xor(true. true)
// res1: Boolean = false
//
// A logical expression in two variables can then be written as an function of
// two variables, e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))
// write a function called table2 which prints the truth table of a given logical
// expression in two variables.
//
// table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
// A     B     result
// true  true  true
// true  false true
// false true  false
// false false false


object p46 extends App {
  import nnproblems.Logic_and_Codes.S99Logic._
//
//  println(and(true, true))
//  println(xor(true, true))
//  println()
//  println(impl(true, true))
//  println(impl(true, false))
//  println(impl(false, true))

  table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
}
