package nnproblems.Binary_Trees

// Count the leaves of a binary tree.
// A leaf is a node with no successors. Write a method leafCount to count them.
// Node('x', Node('x'), End).leafCount
// res0: Int = 1

object p61 extends App {
  println(Node('x', Node('x'), End).leafCount)
  println(Node('x', Node('x'), Node('x', Node('x'), Node('x'))).leafCount)
  println(Node('x', Node('x', Node('x'), Node('x', Node('x'))), Node('x', Node('x'), Node('x'))).leafCount)
}
