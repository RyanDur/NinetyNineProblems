// Run-length encoding of a list.
// Use the result of problem P09 to implement the so-called
// run-length encoding data compression method. Consecutive duplicates
// of elements are encoded as tuples (N, E) where N is the number of
// duplicates of the element E.

// encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

def pack[A](list: List[A]): List[List[A]] = list match {
  case Nil => Nil
  case h :: tl =>
    val (l, r) = tl.span(_ == h)
    h +: l :: pack(r)
}

def encode[A](list: List[A]): List[(Int, A)] = {
  pack(list).map(l => (l.size, l.head))
}



encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))