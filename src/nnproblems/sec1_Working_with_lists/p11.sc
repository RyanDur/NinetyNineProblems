// Modified run-length encoding.
// Modify the result of problem P10 in such a way that if an element
// has no duplicates it is simply copied into the result list.
// Only elements with duplicates are transferred as (N, E) terms.
// scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

def pack[A](list: List[A]): List[List[A]] = list match {
  case Nil => Nil
  case h :: tl =>
    val (l, r) = tl.span(_ == h)
    h +: l :: pack(r)
}

def encode[A](list: List[A]): List[(Int, A)] =
  pack(list).map(l => (l.size, l.head))

def encodeModified[A](list: List[A]): List[Any] =
  encode(list).map(l => if (l._1 > 1) l else l._2)


encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))