// Run-length encoding of a list (direct solution).
// Implement the so-called run-length encoding data compression
// method directly. I.e. don't use other methods you've written
// (like P09's pack); do all the work directly.

// encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

def encodeDirect(list: List[Symbol]): List[(Int, Symbol)] = list match {
  case Nil => Nil
  case h :: Nil => List((1, h))
  case h :: tl =>
    val encoded = encodeDirect(tl)
    val (v, s) = encoded.head
    if (s == h) (1 + v, h) :: encoded.tail
    else (1, h) :: encoded
}

encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
