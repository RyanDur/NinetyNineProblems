package nnproblems.Binary_Trees

// Construct completely balanced binary trees.
// In a completely balanced binary tree, the following property
// holds for every node: The number of nodes in its left subtree
// and the number of nodes in its right subtree are almost equal,
// which means their difference is not greater than one.
//
// Define an object named Tree. Write a function Tree.cBalanced
// to construct completely balanced binary trees for a given
// number of nodes. The function should generate all solutions.
// The function should take as parameters the number of nodes
// and a single value to put in all of them.
//
// Tree.cBalanced(4, "x")
// res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...

object p55 extends App {
  // TODO redo
  println(Tree.cBalanced(4, "x"))
}
