// Generate the combinations of K distinct objects chosen from
// the N elements of a list.
// In how many ways can a committee of 3 be chosen from a group
// of 12 people? We all know that there are C(12,3) = 220
// possibilities (C(N,K) denotes the well-known binomial coefficient).
// For pure mathematicians, this result may be great.
// But we want to really generate all the possibilities.
// combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
// res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

// TODO redo this problem

def fac(int: Int): Int = int match {
  case 0 => 1
  case num => num * fac(num - 1)
}

def numOfCom(n: Int, r: Int): Int =
  fac(n) / (fac(r) * fac(n - r))

def helper[A, B](list: List[A])(f: List[A] => List[B]): List[B] = list match {
  case _ :: tl => f(list) ::: helper(tl)(f)
  case _ => Nil
}

def combinations(len: Int, list: List[Symbol]): List[List[Symbol]] = len match {
  case 0 => List(Nil)
  case _ => helper(list)(l => combinations(len - 1, l.tail) map (l.head :: _))
}

val symbols: List[Symbol] = List('a, 'b, 'c, 'd, 'e, 'f)
val a = combinations(3, symbols)
a.size

numOfCom(6, 3)