import scala.util.Random

// Generate a random permutation of the elements of a list.
// randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
// res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

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

def randomPermute(list: List[Symbol]): List[Symbol] = {
  randomSelect(list.size, list)
}

randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))