package nnproblems.Binary_Trees

sealed abstract class Tree[+T] {
  def depth: Int

  def isBalanced: Boolean

  def isSymmetric: Boolean

  def isMirrorOf[A >: T](that: Tree[A]): Boolean
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  val depth: Int = 1 + math.max(left.depth, right.depth)

  override def isBalanced: Boolean = math.abs(left.depth - right.depth) <= 1

  override def isSymmetric: Boolean = left.isMirrorOf(right)

  override def isMirrorOf[A >: T](that: Tree[A]): Boolean = that match {
    case Node(v, l, r) => left.isMirrorOf(r) && right.isMirrorOf(l)
    case _ => false
  }
}

case object End extends Tree[Nothing] {
  override def toString = "."

  val depth: Int = 0

  override def isBalanced: Boolean = true

  override def isSymmetric: Boolean = true

  override def isMirrorOf[T >: Nothing](that: Tree[T]): Boolean = that == End
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)

  def apply[T](value: T, left: Node[T]): Node[T] = Node(value, left, End)
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