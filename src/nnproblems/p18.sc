// Extract a slice from a list.
// Given two indices, I and K, the slice is the list containing
// the elements from and including the Ith element up to but not
// including the Kth element of the original list. Start counting
// the elements with 0.

// slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('d, 'e, 'f, 'g)

def slice(from: Int, to: Int, list: List[Symbol]): List[Symbol] = (from, to, list) match {
  case (_, _, Nil) => Nil
  case (_, t, _) if t <= 0 => Nil
  case (0, t, h :: tl) => h :: slice(0, t - 1, tl)
  case (f, t, _ :: tl) => slice(f - 1, t - 1, tl)
}

val actual = slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

actual == List('d, 'e, 'f, 'g)