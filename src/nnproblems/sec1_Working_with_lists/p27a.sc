

// Group the elements of a set into disjoint subsets.
// a) In how many ways can a group of 9 people work in 3 disjoint
// subgroups of 2, 3 and 4 persons? Write a function that generates
// all the possibilities.
//
// group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
// res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
//
// b) Generalize the above predicate in a way that we can specify
// a list of group sizes and the predicate will return a list of groups.
//
// group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
// res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ..
//
// Note that we do not want permutations of the group members; i.e.
// ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...).
// However, we make a difference between ((Aldo, Beat), (Carla, David), ...)
// and ((Carla, David), (Aldo, Beat), ...).
//
// You may find more about this combinatorial problem in a good
// book on discrete mathematics under the term "multinomial coefficients".

def combinations[T](size: Int, list: List[T]): List[List[T]] = list match {
  case Nil => Nil
  case _ if size == 1 => list.map(_ :: Nil)
  case h :: tl => combinations(size - 1, tl).map(h :: _) ::: combinations(size, tl)
}

val list = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")

def group3[T](list: List[T]): List[List[List[T]]] = {
  for (x <- combinations(2, list);
       y <- combinations(3, list.diff(x))
  ) yield List(x, y, list.diff(x ::: y))
}

group3(list)

def group[T](nums: List[Int], list: List[T]): List[List[List[T]]] = nums match {
  case Nil => List(Nil)
  case _ if nums.sum > list.size || nums.sum < list.size => Nil
  case h :: tl => combinations(h, list)
    .flatMap(x => group(tl, list.diff(x)).map(x :: _))
}

group(List(2, 2, 5), list)