// Find the last element of a list.
// last(List(1, 1, 2, 3, 5, 8))
// res0: Int = 8

def last(list: List[Int]): Int = list match {
  case Nil => throw new NoSuchElementException
  case h :: Nil => h
  case _ :: tl => last(tl)
}

last(List(1, 1, 2, 3, 5, 8))