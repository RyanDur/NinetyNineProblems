// Eliminate consecutive duplicates of list elements.
// If a list contains repeated elements they should be replaced with a
// single copy of the element.
// The order of the elements should not be changed.

// compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

def compress(list: List[Any]): List[Any] = list match {
  case Nil => Nil
  case h :: Nil => h :: Nil
  case h :: tl if h == tl.head => compress(tl)
  case h :: tl => h :: compress(tl)
}


compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))


//def compressRecursive[A](ls: List[A]): List[A] = ls match {
//  case Nil       => Nil
//  case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
//}