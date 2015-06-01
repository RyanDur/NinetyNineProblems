package nnproblems.Binary_Trees

sealed abstract class Tree[+T] {
  val depth: Int
  def isBalanced: Boolean
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  val depth: Int = 1 + math.max(left.depth, right.depth)

  override def isBalanced: Boolean = math.abs(left.depth - right.depth) <= 1
}

case object End extends Tree[Nothing] {
  override def toString = "."

  val depth: Int = 0

  override def isBalanced: Boolean = true
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object Tree {
  def cBalanced[A](int: Int, value: A): List[Tree[A]] = int match {
    case n if n < 1 => List(End)
    case n if n % 2 == 1 =>
      val subtrees = cBalanced(n / 2, value)
      subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
    case n if n % 2 == 0 =>
      val lesserSubtrees = cBalanced((n - 1) / 2, value)
      val greaterSubtrees = cBalanced((n - 1) / 2 + 1, value)
      lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
  }
}