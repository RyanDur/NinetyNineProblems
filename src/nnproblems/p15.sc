// Duplicate the elements of a list a given number of times.
// duplicateN(3, List('a, 'b, 'c, 'c, 'd))
// res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

def duplicateN(num: Int, list: List[Symbol]): List[Symbol] = list match {
  case Nil => Nil
  case h :: tl => List.fill(num)(h) ::: duplicateN(num, tl)
}

duplicateN(3, List('a, 'b, 'c, 'c, 'd))