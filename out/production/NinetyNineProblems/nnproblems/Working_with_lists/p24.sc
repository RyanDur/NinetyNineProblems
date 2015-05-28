import scala.util.Random

// Lotto: Draw N different random numbers from the set 1..M.
// lotto(6, 49)
// res0: List[Int] = List(23, 1, 17, 33, 21, 37)

def lotto(size: Int, limit: Int): List[Int] =
  List.fill(size)(1 + Random.nextInt(limit))

lotto(6, 49)