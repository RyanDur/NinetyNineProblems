package nnproblems.sec4_Binary_Trees

// Generate-and-test paradigm.
// Apply the generate-and-test paradigm to construct all symmetric,
// completely balanced binary trees with a given number of nodes.
//
// Tree.symmetricBalancedTrees(5, "x")
// res0: List[Node[String]] = List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))

object p58 extends App {
  println(Tree.symmetricBalancedTrees(5, "x"))
}
