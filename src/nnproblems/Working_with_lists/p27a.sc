// Group the elements of a set into disjoint subsets.
// In how many ways can a group of 9 people work in 3 disjoint
// subgroups of 2, 3 and 4 persons? Write a function that generates
// all the possibilities.
//
// group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
// res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...

// TODO

def helper[A, B](list: List[A])(f: List[A] => List[B]): List[B] = list match {
  case _ :: tl => f(list) ::: helper(tl)(f)
  case _ => Nil
}

def combinations[A](len: Int, list: List[A]): List[List[A]] = len match {
  case 0 => List(Nil)
  case _ => helper(list)(l => combinations(len - 1, l.tail) map (l.head :: _))
}

//def group3(list: List[String]): List[List[List[String]]] = {
//  val a = combinations(2, list)
//  val b = combinations(3, list)
//  val c = combinations(4, list)
//  val d = a zip b zip c
//
//}


val list: List[String] = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")

val a = combinations(2, list)
val b = combinations(3, list)
val c = combinations(4, list)

val d = a ::: b

//def group3[A](ls: List[A]): List[List[List[A]]] =
//  for {
//    a <- combinations(2, ls)
//    noA = ls -- a
//    b <- combinations(3, noA)
//  } yield List(a, b, noA -- b)
//
//def group[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
//  case Nil     => List(Nil)
//  case n :: ns => combinations(n, ls) flatMap { c =>
//    group(ns, ls -- c) map {c :: _}
//  }
//}

val e = combinations(3, d).foreach(println)
// .filter(x => x.reduce((f, g) => f.size + g.size) == 9)

//c(1).diff(b(1))
//a(0)


//  .sameElements(a(0))
//group3(list)