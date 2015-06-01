package nnproblems.Binary_Trees

// Collect the nodes at a given level in a list.
// A node of a binary tree is at level N if the path from the root to
// the node has length N-1. The root node is at level 1. Write a
// method atLevel to collect all nodes at a given level in a list.
//
// Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
// res0: List[Char] = List(b, c)
//
// Using atLevel it is easy to construct a method levelOrder which
// creates the level-order sequence of the nodes. However, there are
// more efficient ways to do that.

object p62B extends App {
  println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2))
}
