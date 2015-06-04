// Sorting a list of lists according to length of sublists.
//
// Again, we suppose that a list contains elements that are
// lists themselves. But this time the objective is to sort
// the elements according to their length frequency; i.e. in
// the default, sorting is done ascendingly, lists with rare
// lengths are placed, others with a more frequent length
// come later.

// lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
// res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))

def lsortFreq(list: List[List[Symbol]]): List[List[Symbol]] =
  list.groupBy(_.size).values.toList.sortBy(_.size).flatten

lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))