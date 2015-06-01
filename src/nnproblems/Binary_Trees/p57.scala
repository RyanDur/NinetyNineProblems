package nnproblems.Binary_Trees

// Binary search trees (dictionaries).
// Write a function to add an element to a binary search tree.
//
// End.addValue(2)
// res0: Node[Int] = T(2 . .)
// res0.addValue(3)
// res1: Node[Int] = T(2 . T(3 . .))
// res1.addValue(0)
// res2: Node[Int] = T(2 T(0 . .) T(3 . .))
//
// Hint: The abstract definition of addValue in Tree should be
// def addValue[U >: T <% Ordered[U]](x: U): Tree[U].
// The >: T is because addValue's parameters need to be
// contravariant in T. (Conceptually, we're adding nodes above
// existing nodes. In order for the subnodes to be of type T or
// any subtype, the upper nodes must be of type T or any
// supertype.) The <% Ordered[U] allows us to use the < operator
// on the values in the tree.
//
// Use that function to construct a binary tree from a list of integers.
//
// Tree.fromList(List(3, 2, 5, 7, 1))
// res3: Node[Int] = T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))
//
// Finally, use that function to test your solution to P56.
//
// Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric
// res4: Boolean = true
// Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric
// res5: Boolean = false

object p57 extends App {

  val a = End.addValue(2)
  println(a)
  val b = a.addValue(3)
  println(b)
  val c = b.addValue(0)
  println(c)

  println()
  println(Tree.fromList(List(3, 2, 5, 7, 1)))

  println(Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric)

  println(Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric)
}
