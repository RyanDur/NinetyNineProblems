package nnproblems.LogicAndCodes

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
  val a = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).sortWith(_._2 < _._2)

  def treeIt(list: List[(Any, Int)]): List[(Any, Int)] = list match {
    case Nil => Nil
    case h :: Nil => list
    case h :: h2 :: tl => treeIt(((((0, h._1), (1, h2._1)), h._2 + h2._2) :: tl).sortWith(_._2 < _._2))
  }


  def huffIt(acc: String, t: (Any, Any)): List[(String, String)] = (acc, t) match {
    case (ac, (l: ((_, _), (_, _)), r: Int)) => huffIt(ac, l._1) ::: huffIt(ac, l._2)
    case (ac, (l: Int, r: ((_, _), (_, _)))) => huffIt(ac + l, r._1) ::: huffIt(ac + l, r._2)
    case (ac, (l: Int, r: String)) => (ac + l, r) :: Nil
  }

  val t2: (Any, Any) = treeIt(a).head

  println(huffIt("", t2).sortBy(_._2))
}
