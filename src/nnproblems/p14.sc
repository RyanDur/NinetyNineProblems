// Duplicate the elements of a list.
// duplicate(List('a, 'b, 'c, 'c, 'd))
// res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

def duplicate[A](list: List[A]): List[A] = list match {
  case Nil => Nil
  case h :: tl => h :: h :: duplicate(tl)
}

duplicate(List('a, 'b, 'c, 'c, 'd))