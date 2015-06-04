package nnproblems.sec4_Binary_Trees

sealed abstract class Tree[+T] {

  def depth: Int

  def isLeaf: Boolean

  def isBalanced: Boolean

  def isSymmetric: Boolean

  def leafCount: Int

  def leafList: List[T]

  def internalList: List[T]

  def inorder: List[T]

  def preorder: List[T]

  def layoutBinaryTree: String

  def layoutBinaryTree2: String = layoutBinaryTreeInternal2(1, 1)._1

  def layoutBinaryTreeInternal2(x: Int, depth: Int): (String, Int)

  def atLevel(level: Int): List[T]

  def isMirrorOf[A >: T](that: Tree[A]): Boolean

  def addValue[U >: T](x: U)(implicit ord: U => Ordered[U]): Tree[U]
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  lazy val depth: Int = 1 + (left.depth max right.depth)

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

  override def toString = this match {
    case Node(v, End, End) => s"$value"
    case _ => s"$value($left,$right)"
  }

  override def isLeaf: Boolean = left == End && right == End

  override def leafList: List[T] = if (isLeaf) List(value) else left.leafList ::: right.leafList

  override def internalList: List[T] = if (isLeaf) Nil else value :: left.internalList ::: right.internalList

  override def atLevel(level: Int): List[T] = level match {
    case l if l < 1 => Nil
    case 1 => List(value)
    case _ => left.atLevel(level - 1) ::: right.atLevel(level - 1)
  }

  override def layoutBinaryTreeInternal2(x: Int, d: Int): (String, Int) = {
    val newDepth = math.max(left.depth, right.depth)
    val (leftTree, myX) = left.layoutBinaryTreeInternal2(x, d + 1)
    val (rightTree, nextX) = right.layoutBinaryTreeInternal2(myX + 1, d + 1)
    (s"T[$myX  $d]($value $leftTree $rightTree)", nextX + newDepth)
  }


  override def layoutBinaryTree: String = {
    val list = inorder
    def layout(tree: Tree[T], y: Int): String = tree match {
      case Node(v, l, r) => s"T[${list.indexOf(v) + 1} $y]($v ${layout(l, y + 1)} ${layout(r, y + 1)})"
      case End => End.toString
    }
    layout(this, 1)
  }

  override def inorder: List[T] = left.inorder ::: value :: right.inorder

  override def preorder: List[T] = value :: left.preorder ::: right.preorder
}

case object End extends Tree[Nothing] {
  val depth: Int = 0

  val leafCount: Int = 0

  override def isBalanced: Boolean = true

  override def isSymmetric: Boolean = true

  override def isMirrorOf[T >: Nothing](that: Tree[T]): Boolean = that == End

  override def addValue[U >: Nothing](x: U)(implicit ord: (U) => Ordered[U]): Tree[U] = Node(x)

  override def toString = ""

  override def isLeaf: Boolean = throw new NoSuchElementException

  override def leafList: List[Nothing] = Nil

  override def internalList: List[Nothing] = Nil

  override def atLevel(level: Int): List[Nothing] = Nil

  override def layoutBinaryTree: String = End.toString

  override def layoutBinaryTree2: String = End.toString

  override def layoutBinaryTreeInternal2(x: Int, depth: Int): (String, Int) = (End.toString, x)

  override def inorder: List[Nothing] = Nil

  override def preorder: List[Nothing] = Nil
}

object Node {

  def apply[T](value: T): Tree[T] = Node(value, End, End)

//  def apply[T](value: T, left: Tree[T]): Tree[T] = Node(value, left, End)
//
//  def apply[T](value: T, left: Tree[T], right: Tree[T]): Tree[T] = Node(value, left, right)
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

  def string2Tree(s: String): Tree[Char] = {
    def extractTreeString(s: String, start: Int, end: Char): (String, Int) = {
      def updateNesting(nesting: Int, pos: Int): Int = s(pos) match {
        case '(' => nesting + 1
        case ')' => nesting - 1
        case _ => nesting
      }
      def findStringEnd(pos: Int, nesting: Int): Int =
        if (s(pos) == end && nesting == 0) pos
        else findStringEnd(pos + 1, updateNesting(nesting, pos))
      val strEnd = findStringEnd(start, 0)
      (s.substring(start, strEnd), strEnd)
    }
    s.length match {
      case 0 => End
      case 1 => Node(s(0))
      case _ =>
        val (leftStr, commaPos) = extractTreeString(s, 2, ',')
        val (rightStr, _) = extractTreeString(s, commaPos + 1, ')')
        Node(s(0), string2Tree(leftStr), string2Tree(rightStr))
    }
  }
}