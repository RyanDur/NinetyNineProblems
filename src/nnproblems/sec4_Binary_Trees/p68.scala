package nnproblems.sec4_Binary_Trees

// Preorder and inorder sequences of binary trees.
// We consider binary trees with nodes that are identified by single
// lower-case letters, as in the example of problem P67.
// a) Write methods preorder and inorder that construct the preorder
// and inorder sequence of a given binary tree, respectively. The
// results should be lists, e.g. List('a','b','d','e','c','f','g') for
// the preorder sequence of the example in problem P67.
//
// Tree.string2Tree("a(b(d,e),c(,f(g,)))").preorder
// res0: List[Char] = List(a, b, d, e, c, f, g)
//
// Tree.string2Tree("a(b(d,e),c(,f(g,)))").inorder
// res1: List[Char] = List(d, b, e, a, c, g, f)
//
// TODO do b
// b) If both the preorder sequence and the inorder sequence of the
// nodes of a binary tree are given, then the tree is determined
// unambiguously. Write a method preInTree that does the job.
//
// Tree.preInTree(List('a', 'b', 'd', 'e', 'c', 'f', 'g'), List('d', 'b', 'e', 'a', 'c', 'g', 'f'))
// res2: Node[Char] = a(b(d,e),c(,f(g,)))

object p68 extends App {
  println(Tree.string2Tree("a(b(d,e),c(,f(g,)))").preorder)
  println(Tree.string2Tree("a(b(d,e),c(,f(g,)))").inorder)
}
