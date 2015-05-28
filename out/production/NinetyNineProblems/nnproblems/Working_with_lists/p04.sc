// Find the number of elements of a list.
// length(List(1, 1, 2, 3, 5, 8))
// res0: Int = 6

def length(list: List[Int]): Int = list match {
  case Nil => 0
  case h :: tl => 1 + length(tl)
}


length(List(1, 1, 2, 3, 5, 8))