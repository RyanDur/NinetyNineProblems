// Split a list into two parts.
// The length of the first part is given. Use a Tuple for your result.
// scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

def split(int: Int, list: List[Symbol]): (List[Symbol], List[Symbol]) = (int, list) match {
  case (_, Nil) | (0, _) => (Nil, list)
  case (_, h :: tl) =>
    val (left, right) = split(int - 1, tl)
    (h :: left, right)
}



val actual = split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

actual == (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))