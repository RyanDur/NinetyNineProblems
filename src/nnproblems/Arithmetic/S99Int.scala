package nnproblems.Arithmetic

object S99Int {
  def gcd(less: Int, more: Int): Int = (less, more) match {
    case (_, 0) => less
    case (0, _) => more
    case (a, b) if b > a => gcd(a, b % a)
    case (a, b) => gcd(b, a % b)
  }

  implicit class S99Int(val start: Int) {
    private val primes: Stream[Int] = Stream.cons(2, Stream.from(3, 2) filter (_.isPrime))

    def isPrime: Boolean = (start > 1) && (primes takeWhile (_ <= Math.sqrt(start)) forall (start % _ != 0))

    def coPrimeTo(int: Int): Boolean = gcd(int, start) == 1

    def totient: Int = primeFactorMultiplicity.foldLeft(1)((acc, tuple) => tuple match {
      case (l, r) => (l - 1) * math.pow(l, r - 1).toInt * acc
    })

    def primeFactors: List[Int] = start match {
      case a if a.isPrime => List(a)
      case a =>
        val b = (2 to a).find(x => a % x == 0).getOrElse(1)
        b :: (start / b).primeFactors
    }

    def primeFactorMultiplicity: List[(Int, Int)] =
      (start.primeFactors groupBy (x => x)).toList sortBy (_._1) map (x => (x._1, x._2 size))
  }

}