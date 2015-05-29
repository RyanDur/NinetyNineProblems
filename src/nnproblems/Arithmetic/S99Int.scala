package nnproblems.Arithmetic

import scala.annotation.tailrec

object S99Int {
  @tailrec final def gcd(less: Int, more: Int): Int = (less, more) match {
    case (_, 0) => less
    case (0, _) => more
    case (a, b) if b > a => gcd(a, b % a)
    case (a, b) => gcd(b, a % b)
  }

  def listPrimesinRange(range: Range): List[Int] =
    (primes dropWhile (x => x < range.head) takeWhile (x => x <= range.last)).toList

  def printGoldbachList(range: Range): Unit =
    range.filter(x => x.isEven && x > 2).foreach(num => num.goldbach match {
      case (l, r) => println(num + " = " + l + " + " + r)
    })

  def printGoldbachListLimited(range: Range, limit: Int): Unit =
    range.filter(x => x.isEven && x > 2).foreach(num => num.goldbach match {
      case (l, r) if l > limit && r > limit => println(num + " = " + l + " + " + r)
      case _ =>
    })

  private val primes: Stream[Int] = Stream.cons(2, Stream.from(3, 2) filter (_.isPrime))

  implicit class S99Int(val start: Int) {
    def isEven: Boolean = start % 2 == 0

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

    def goldbach: (Int, Int) = {
      listPrimesinRange(2 to start).find(p => (start - p).isPrime) match {
        case None => throw new IllegalArgumentException
        case Some(value) => (value, start - value)
      }
    }
  }

}