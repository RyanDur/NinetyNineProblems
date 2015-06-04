package nnproblems.sec3_Logic_and_Codes

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

  // TODO works but produces warnings. needs to be redone
}
