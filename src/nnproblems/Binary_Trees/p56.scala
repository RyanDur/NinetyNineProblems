package nnproblems.Binary_Trees

// Symmetric binary trees.
// Let us call a binary tree symmetric if you can draw a vertical
// line through the root node and then the right subtree is the
// mirror image of the left subtree. Add an isSymmetric method to
// the Tree class to check whether a given binary tree is symmetric.
// Hint: Write an isMirrorOf method first to check whether one tree
// is the mirror image of another. We are only interested in the
// structure, not in the contents of the nodes.
//
// Node('a', Node('b'), Node('c')).isSymmetric
// res0: Boolean = true

object p56 extends App {

  val a = Node('a', Node('b'))
  val b = Node('a', Node('b'), Node('c'))
  println(a.isMirrorOf(b))
  println(b.isSymmetric)
  println(a.isSymmetric)
  println()
  println(End.isMirrorOf(End))
  println(Node('b').isMirrorOf(End))
  println(End.isMirrorOf(Node('b')))
}
