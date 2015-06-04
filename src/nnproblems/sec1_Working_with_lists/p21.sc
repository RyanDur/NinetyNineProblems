// Insert an element at a given position into a list.
// insertAt('new, 1, List('a, 'b, 'c, 'd))
// res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

def insertAt(symbol: Symbol, int: Int, list: List[Symbol]): List[Symbol] = (int, list) match {
  case (_, Nil) => Nil
  case (0, _) => symbol :: list
  case (i, h :: tl) => h :: insertAt(symbol, i - 1, tl)
}

// their answer
// def insertAt[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
//   case (pre, post) => pre ::: e :: post
// }

val actual = insertAt('new, 1, List('a, 'b, 'c, 'd))
actual == List('a, 'new, 'b, 'c, 'd)