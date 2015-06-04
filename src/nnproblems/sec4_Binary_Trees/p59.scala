package nnproblems.sec4_Binary_Trees

// Construct height-balanced binary trees.
// In a height-balanced binary tree, the following property holds
// for every node: The height of its left subtree and the height
// of its right subtree are almost equal, which means their
// difference is not greater than one.
//
// Write a method Tree.hbalTrees to construct height-balanced binary
// trees for a given height with a supplied value for the nodes. The
// function should generate all solutions.
//
// Tree.hbalTrees(3, "x")
// res0: List[Node[String]] = List(T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .))), T(x T(x T(x . .) T(x . .)) T(x T(x . .) .)), ...

// TODO redo
object p59 extends App {
  println(Tree.hbalTrees(3, "x"))
}
