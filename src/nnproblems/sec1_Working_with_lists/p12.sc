// Decode a run-length encoded list.
// Given a run-length code list generated as specified in problem P10,
// construct its uncompressed version.

// decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
// res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

def pack[A](list: List[A]): List[List[A]] = list match {
  case Nil => Nil
  case h :: tl =>
    val (l, r) = tl.span(_ == h)
    h +: l :: pack(r)
}

def encode[A](list: List[A]): List[(Int, A)] = {
  pack(list).map(l => (l.size, l.head))
}

def decode[A](ls: List[(Int, A)]): List[A] =
  ls.flatMap(e => List.fill(e._1)(e._2))

val original: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

val encoded = encode(original)

val decoded = decode(encoded)

decoded == original