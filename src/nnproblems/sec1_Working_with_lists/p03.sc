// Find the Kth element of a list
// nth(2, List(1, 1, 2, 3, 5, 8))
// res0: Int = 2

def nth(n: Int, list: List[Int]): Int = (n, list) match {
  case (_, Nil) => throw new NoSuchElementException
  case (0 , h :: _) => h
  case (_, h :: tl) => nth(n - 1, tl)
}

nth(2, List(1, 1, 2, 3, 5, 8))