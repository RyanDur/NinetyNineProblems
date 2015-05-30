package nnproblems.LogicAndCodes

import scala.annotation.tailrec

object S99Logic {
  def and(a: Boolean, b: Boolean): Boolean = a && b

  def or(a: Boolean, b: Boolean): Boolean = a || b

  def nand(a: Boolean, b: Boolean): Boolean = !and(a, b)

  def nor(a: Boolean, b: Boolean): Boolean = !or(a, b)

  def xor(a: Boolean, b: Boolean): Boolean = or(and(!a, b), and(a, !b))

  def impl(a: Boolean, b: Boolean): Boolean = or(or(and(a, b), and(!a, b)), and(!a, !b))

  def equ(a: Boolean, b: Boolean): Boolean = a == b

  def not(a: Boolean): Boolean = !a

  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
    val bools = List((true, true), (true, false), (false, true), (false, false))
    println("A     B     = result")
    bools.map {
      case (l, r) => f"$l%-5s $r%-5s = ${f(l, r)}"
    }.foreach(println)
  }

  def gray(int: Int): List[String] = {
    val num = math.pow(2, int).toInt
    (0 until num).map(_.toGreyCode.prePadTo(int, "0")).toList
  }

  implicit class MyBool(a: Boolean) {
    def and(b: Boolean): Boolean = a && b

    def or(b: Boolean): Boolean = a || b

    def nand(b: Boolean): Boolean = !(a and b)

    def nor(b: Boolean): Boolean = !(a or b)

    def xor(b: Boolean): Boolean = (!a and b) or (a and !b)

    def impl(b: Boolean): Boolean = (a and b) or (!a and b) or (!a and !b)
  }

  implicit class MyInt(int: Int) {
    def toGreyCode: String = {
      val list = int.toBinaryString.toList
      list.head + list.foldLeft((list, ""))((l, _) => l match {
        case (h +: Nil, acc) => (Nil, acc)
        case (h +: tl, acc) => (tl, acc + (if (h == tl.head) 0 else 1))
      })._2
    }
  }

  implicit class MyString(str: String) {
    def prePadTo(int: Int, ch: String): String = {
      @tailrec def helper(acc: String, inc: Int): String = inc match {
        case 0 => acc
        case i => helper(ch + acc, i - 1)
      }
      helper(str, int - str.length)
    }
  }

}
