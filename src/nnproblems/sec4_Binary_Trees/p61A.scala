package nnproblems.sec4_Binary_Trees

// Collect the leaves of a binary tree in a list.
// A leaf is a node with no successors. Write a method leafList to collect them in a list.
//
// Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
// res0: List[Char] = List(b, d, e)

object p61A extends App {
  println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList)
  println(Node('a', Node('b'), End).leafList)
  println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList)
  println(Node('a', Node('b', Node('c'), Node('d', Node('e'))), Node('f', Node('g'), Node('h'))).leafList)
}
