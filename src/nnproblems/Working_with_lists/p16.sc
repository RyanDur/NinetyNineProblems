// Drop every Nth element from a list.
// drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

def drop(int: Int, list: List[Symbol]): List[Symbol] = list match {
  case Nil => Nil
  case h :: tl => list.take(int - 1) ::: drop(int, list.drop(int))
}



val actual = drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

val expected: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

actual == expected