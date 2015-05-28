package nnproblems.Arithmetic

object S99Int {
  def gcd(less: Int, more: Int): Int = (less, more) match {
    case (_, 0) => less
    case (0, _) => more
    case (a, b) if b > a => gcd(a, b % a)
    case (a, b) => gcd(b, a % b)
  }

  implicit class S99Int(val start: Int) {
    def isPrime: Boolean = (start > 1) && Stream.from(3, 2)
      .takeWhile(x => x <= math.sqrt(start))
      .forall(y => start % y != 0)
  }

}