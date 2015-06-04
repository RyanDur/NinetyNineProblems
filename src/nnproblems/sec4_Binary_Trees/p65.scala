package nnproblems.sec4_Binary_Trees

// Layout a binary tree (2).
// An alternative layout method is depicted in the illustration opposite.
// Find out the rules and write the corresponding method. Hint: On a
// given level, the horizontal distance between neighboring nodes is constant.
//
// Use the same conventions as in problem P64.
//
// Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree2
// res0: PositionedNode[Char] = T[3,1]('a T[1,2]('b . T[2,3]('c . .)) T[5,2]('d . .))
//
// The tree at right may be constructed with
// Tree.fromList(List('n','k','m','c','a','e','d','g','u','p','q')).
// Use it to check your code.

// TODO redo - can't do 66 before I redo this
object p65 extends App {
  //  val a = Tree.fromList(List('n','k','m','c','a','e','d','g','u','p','q'))
  //  println(a.inOrder)

  //  println(Node('x').depth)
  println(Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree2)
  println(Tree.fromList(List('n','k','m','c','a','e','d','g','u','p','q')).layoutBinaryTree2)
}
