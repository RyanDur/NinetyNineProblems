// Remove the Kth element from a list.
// Return the list and the removed element in a Tuple.
// Elements are numbered from 0.
// removeAt(1, List('a, 'b, 'c, 'd))
// res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

def removeAt(int: Int, list: List[Symbol]): (List[Symbol], Symbol) = (int, list) match {
  case (_, Nil) => throw new NoSuchElementException
  case (0, h :: tl) => (tl, h)
  case (c, h :: tl) =>
    val (left, right) = removeAt(c - 1, tl)
    (h :: left, right)
}

val actual = removeAt(1, List('a, 'b, 'c, 'd))

actual ==(List('a, 'c, 'd), 'b)