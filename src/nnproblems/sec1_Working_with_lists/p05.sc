// Reverse a list.
// reverse(List(1, 1, 2, 3, 5, 8))
// res0: List[Int] = List(8, 5, 3, 2, 1, 1)

def reverse(list: List[Int]): List[Int] = list match {
  case Nil => Nil
  case h :: tl => reverse(tl) :+ h
}

reverse(List(1, 1, 2, 3, 5, 8))