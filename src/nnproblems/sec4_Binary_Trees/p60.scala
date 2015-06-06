package nnproblems.sec4_Binary_Trees

// Construct height-balanced binary trees with a given number of nodes.
// Consider a height-balanced binary tree of height H. What is the maximum
// number of nodes it can contain? Clearly, MaxN = 2^H - 1. However, what
// is the minimum number MinN? This question is more difficult. Try to
// find a recursive statement and turn it into a function minHbalNodes that
// takes a height and returns MinN.
//
// minHbalNodes(3)
// res0: Int = 4
//
// On the other hand, we might ask: what is the maximum height H a
// height-balanced binary tree with N nodes can have? Write a maxHbalHeight
// function.
//
// maxHbalHeight(4)
// res1: Int = 3
//
// Now, we can attack the main problem: construct all the height-balanced
// binary trees with a given number of nodes.
//
// Tree.hbalTreesWithNodes(4, "x")
// res2: List[Node[String]] = List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), ...
//
// Find out how many height-balanced trees exist for N = 15.
//
// TODO

object p60 extends App {

  val b = Tree.hbalTrees(2, "x")
  val c = Tree.hbalTrees(3, "x")
  val d = Tree.hbalTrees(4, "x")
  val e = Tree.hbalTrees(5, "x")
  val x = Tree.hbalTrees(6, "x")
  println(x.groupBy(_.nodeCount).keys.min)
}
