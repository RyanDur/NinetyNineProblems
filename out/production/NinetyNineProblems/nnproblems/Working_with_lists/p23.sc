import scala.util.Random

// Extract a given number of randomly selected elements from a list.
// randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
// res0: List[Symbol] = List('e, 'd, 'a)

def removeAt(int: Int, list: List[Symbol]): (List[Symbol], Symbol) = (int, list) match {
  case (_, Nil) => throw new NoSuchElementException
  case (0, h :: tl) => (tl, h)
  case (c, h :: tl) =>
    val (left, right) = removeAt(c - 1, tl)
    (h :: left, right)
}

def randomSelect(int: Int, list: List[Symbol]): List[Symbol] = (int, list) match {
  case (0, _) | (_, Nil) => Nil
  case (i, _) =>
    val (l, r) = removeAt(Random.nextInt(list.size), list)
    r :: randomSelect(i - 1, l)
}


randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))