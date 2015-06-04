package nnproblems.sec3_Logic_and_Codes

import scala.annotation.tailrec

// Huffman code.
// First of all, consult a good book on discrete mathematics or
// algorithms for a detailed description of Huffman codes!
//
// We suppose a set of symbols with their frequencies, given as a list of
// (S, F) Tuples. E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).
// Our objective is to construct a list of (S, C) Tuples,
// where C is the Huffman code word for the symbol S.
//
// huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
// res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))


object p50 extends App {

  sealed trait Huffman[+T] {
    def value: Int

    def list: List[(String, String)]
  }

  case class Leaf[T](left: Huffman[T], symbol: String, value: Int, right: Huffman[T]) extends Huffman[T] {
    val list: List[(String, String)] = (left, right) match {
      case (LeafEnd, LeafEnd) => (symbol, "") :: Nil
      case (l, r) => l.list.map(x => (x._1, "0" + x._2)) ::: r.list.map(x => (x._1, "1" + x._2))
    }
  }

  case object LeafEnd extends Huffman[Nothing] {
    val value: Int = 0
    val list: List[(String, String)] = Nil
  }

  object Leaf {
    def apply[T](left: Huffman[T], value: Int, right: Huffman[T]): Huffman[T] = Leaf(left, "", value, right)
  }

  def huffman[T](list: List[(String, Int)]): List[(String, String)] = {
    @tailrec def huffIt(tree: List[Huffman[T]]): Huffman[T] = tree match {
      case Nil => LeafEnd
      case h :: Nil => h
      case h :: h2 :: tl => huffIt((Leaf(h, h.value + h2.value, h2) :: tl).sortBy(_.value))
    }
    huffIt(list.map(t => Leaf(LeafEnd, t._1, t._2, LeafEnd)).sortBy(_.value)).list
  }

  println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))).sortBy(_._1))
}