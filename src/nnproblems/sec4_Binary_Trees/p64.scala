package nnproblems.sec4_Binary_Trees

// Layout a binary tree (1).
// As a preparation for drawing a tree, a layout algorithm is
// required to determine the position of each node in a
// rectangular grid. Several layout methods are conceivable,
// one of them is shown in the illustration on the right.
//
// In this layout strategy, the position of a node v is
// obtained by the following two rules:
//   - x(v) is equal to the position of the node v in the
//     inorder sequence
//   - y(v) is equal to the depth of the node v in the tree
//
// In order to store the position of the nodes, we add a new
// class with the additional information.
//
// Write a method layoutBinaryTree that turns a tree of
// normal Nodes into a tree of PositionedNodes.
//
// Write a method layoutBinaryTree that turns a tree of
// normal Nodes into a tree of PositionedNodes.
//
// Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree
// res0: PositionedNode[Char] = T[3,1](a T[1,2](b . T[2,3](c . .)) T[4,2](d . .))
//
// The tree at right may be constructed with
// Tree.fromList(List('n','k','m','c','a','h','g','e','u','p','s','q')).
// Use it to check your code.

object p64 extends App {
  println(Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree)
//  println(Tree.fromList(List('n','k','m','c','a','h','g','e','u','p','s','q')).layoutBinaryTree)
}
