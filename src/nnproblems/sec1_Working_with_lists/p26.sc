import scala.annotation.tailrec

// Generate the combinations of K distinct objects chosen from
// the N elements of a list.
//
// In how many ways can a committee of 3 be chosen from a group
// of 12 people? We all know that there are C(12,3) = 220
// possibilities (C(N,K) denotes the well-known binomial coefficient).
// For pure mathematicians, this result may be great.
// But we want to really generate all the possibilities.
//
// combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
// res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

def fac(int: Int): Int = {
  @tailrec def helper(acc: Int, num: Int): Int = num match {
    case i if i < 1 => acc
    case _ => helper(acc * num, num - 1)
  }
  helper(1, int)
}

def numberOfCombinations(n: Int, r: Int): Int =
  fac(n) / (fac(r) * fac(n - r))

def combinations[T](size: Int, list: List[T]): List[List[T]] = list match {
  case Nil => Nil
  case _ if size == 1 => list.map(_ :: Nil)
  case h :: tl => combinations(size - 1, tl).map(h :: _) ::: combinations(size, tl)
}


numberOfCombinations(6, 3)

val list: List[Symbol] = List('a, 'b, 'c, 'd, 'e, 'f)

list.combinations(3).toList
val a = combinations(3, list)
a.size