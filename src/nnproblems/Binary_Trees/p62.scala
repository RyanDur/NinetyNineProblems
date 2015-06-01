package nnproblems.Binary_Trees

// Collect the internal nodes of a binary tree in a list.
// An internal node of a binary tree has either one or two
// non-empty successors. Write a method internalList to
// collect them in a list.
//
// Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
// res0: List[Char] = List(a, c)

object p62 extends App {
  println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList)
  println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList)
  println()
  println(Node('a', Node('b'), End).internalList)
  println(Node('a', Node('b'), End).leafList)
  println()
  println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList)
  println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList)
  println()
  println(Node('a', Node('b', Node('c'), Node('d', Node('e'))), Node('f', Node('g'), Node('h'))).internalList)
  println(Node('a', Node('b', Node('c'), Node('d', Node('e'))), Node('f', Node('g'), Node('h'))).leafList)
}
