// Find the last but one element of a list.
// penultimate(List(1, 1, 2, 3, 5, 8))
// res0: Int = 5

def penultimate(list: List[Int]): Int = list match {
  case Nil => throw new NoSuchElementException
  case h :: tl if tl.size == 1 => h
  case h :: tl => penultimate(tl)
}

penultimate(List(1, 1, 2, 3, 5, 8))

// their solution
//def penultimateRecursive[A](ls: List[A]): A = ls match {
//  case h :: _ :: Nil => h
//  case _ :: tail     => penultimateRecursive(tail)
//  case _             => throw new NoSuchElementException
//}