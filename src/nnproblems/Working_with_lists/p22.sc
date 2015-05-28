// Create a list containing all integers within a given range.
// range(4, 9)
// res0: List[Int] = List(4, 5, 6, 7, 8, 9)

def range(start: Int, end: Int): List[Int] = (start, end) match {
  case (s,e) if s == e => List(s)
  case (s,e) => s :: range(s + 1, e)
}


val actual = range(4, 9)
actual == List(4, 5, 6, 7, 8, 9)