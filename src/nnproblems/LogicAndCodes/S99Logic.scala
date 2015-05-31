package nnproblems.LogicAndCodes

import scala.annotation.tailrec

object S99Logic {
  private var memoized: Map[Int, List[String]] = Map()

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

  def gray(key: Int): List[String] = {
    if (key < 0) return Nil
    memoized.get(key) match {
      case Some(list) => list
      case None => createList(key)
    }
  }

  private def createList(key: Int): List[String] = {
    val end = math.pow(2, key).toInt
    val start = math.pow(2, key - 1).toInt
    memoized = memoized ++ Map(key ->
      (gray(key - 1) ::: (start until end).map(_.toGreyCode).toList).map(_.prePadTo(key, "0")))
    memoized.getOrElse(key, Nil)
  }

  def huffman(list: List[(String, Int)]): List[(String, String)] = ???

  implicit class MyBool(val a: Boolean) extends AnyVal {
    def and(b: Boolean): Boolean = a && b

    def or(b: Boolean): Boolean = a || b

    def nand(b: Boolean): Boolean = !(a and b)

    def nor(b: Boolean): Boolean = !(a or b)

    def xor(b: Boolean): Boolean = (!a and b) or (a and !b)

    def impl(b: Boolean): Boolean = (a and b) or (!a and b) or (!a and !b)
  }

  implicit class MyInt(val num: Int) extends AnyVal {
    def toGreyCode: String = (num ^ (num >>> 1)).toBinaryString
  }

  implicit class MyString(val str: String) extends AnyVal {
    def prePadTo(int: Int, ch: String): String = {
      @tailrec def helper(acc: String, inc: Int): String = inc match {
        case 0 => acc
        case i if i < 0 => acc
        case i => helper(ch + acc, i - 1)
      }
      helper(str, int - str.length)
    }
  }

}
