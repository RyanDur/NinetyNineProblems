// Flatten a nested list structure.
// flatten(List(List(1, 1), 2, List(3, List(5, 8))))
// res0: List[Any] = List(1, 1, 2, 3, 5, 8)

def flatten(list: List[Any]): List[Any] = list flatMap {
  case h: List[_] => flatten(h)
  case e => List(e)
}

flatten(List(List(1, 1), 2, List(3, List(5, 8))))