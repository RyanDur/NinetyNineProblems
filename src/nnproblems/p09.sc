// Pack consecutive duplicates of list elements into sublists.
// If a list contains repeated elements they should be placed in separate sublists.
// pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

def pack[A](list: List[A]): List[List[A]] = list match {
  case Nil => Nil
  case h :: tl =>
    val (l, r) = tl.span(_ == h)
    h +: l :: pack(r)
}

pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
