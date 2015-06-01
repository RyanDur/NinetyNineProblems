package nnproblems.Binary_Trees

sealed abstract class Tree[+T] {
  def depth: Int

  def isLeaf: Boolean

  def isBalanced: Boolean

  def isSymmetric: Boolean

  def leafCount: Int

  def leafList: List[T]

  def internalList: List[T]

  def atLevel(level: Int): List[T]

  def isMirrorOf[A >: T](that: Tree[A]): Boolean

  def addValue[U >: T](x: U)(implicit ord: U => Ordered[U]): Tree[U]
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  lazy val depth: Int = if (isLeaf) 0 else 1 + math.max(left.depth, right.depth)

  lazy val leafCount: Int = if (isLeaf) 1 else left.leafCount + right.leafCount

  override def isBalanced: Boolean = math.abs(left.depth - right.depth) <= 1

  override def isSymmetric: Boolean = left.isMirrorOf(right)

  override def isMirrorOf[A >: T](that: Tree[A]): Boolean = that match {
    case Node(v, l, r) => left.isMirrorOf(r) && right.isMirrorOf(l)
    case _ => false
  }

  override def addValue[U >: T](x: U)(implicit ord: (U) => Ordered[U]): Tree[U] = this match {
    case Node(v, l, r) if x < v => Node(v, l.addValue(x), r)
    case Node(v, l, r) => Node(v, l, r.addValue(x))
  }

  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  override def isLeaf: Boolean = left == End && right == End

  override def leafList: List[T] = if (isLeaf) List(value) else left.leafList ::: right.leafList

  override def internalList: List[T] = if (isLeaf) Nil else value :: left.internalList ::: right.internalList

  override def atLevel(level: Int): List[T] = level match {
    case l if l < 1 => Nil
    case 1 => List(value)
    case _ => left.atLevel(level - 1) ::: right.atLevel(level - 1)
  }
}

case object End extends Tree[Nothing] {
  val depth: Int = 0

  val leafCount: Int = 0

  override def isBalanced: Boolean = true

  override def isSymmetric: Boolean = true

  override def isMirrorOf[T >: Nothing](that: Tree[T]): Boolean = that == End

  override def addValue[U >: Nothing](x: U)(implicit ord: (U) => Ordered[U]): Tree[U] = Node(x)

  override def toString = "."

  override def isLeaf: Boolean = throw new NoSuchElementException

  override def leafList: List[Nothing] = Nil

  override def internalList: List[Nothing] = Nil

  override def atLevel(level: Int): List[Nothing] = Nil
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)

  def apply[T](value: T, left: Node[T]): Node[T] = Node(value, left, End)
}

object Tree {
  def hbalTrees(height: Int, value: String): List[Tree[String]] = height match {
    case h if h < 1 => List(End)
    case 1 => List(Node(value))
    case _ =>
      val long = hbalTrees(height - 1, value)
      val short = hbalTrees(height - 2, value)
      long.flatMap((l) => long.map((r) => Node(value, l, r))) :::
        long.flatMap((f) => short.flatMap((s) => List(Node(value, f, s), Node(value, s, f))))
  }

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

  def fromList[A](list: List[A])(implicit ord: (A) => Ordered[A]): Tree[A] = {
    list.foldLeft(End: Tree[A])((acc, e) => acc.addValue(e))
  }

  def symmetricBalancedTrees[A](int: Int, value: A): List[Tree[A]] = {
    cBalanced(int, value).filter(_.isSymmetric)
  }

  def completeBinaryTree(nodes: Int, value: String): Tree[String] = nodes match {
    case i if i < 1 => End
    case _ =>
      Node(value, completeBinaryTree(nodes / 2, value), completeBinaryTree((nodes - 1) / 2, value))
  }
}