// Find out whether a list is a palindrome.
// isPalindrome(List(1, 2, 3, 2, 1))
// res0: Boolean = true

def isPalindrome(list: List[Int]): Boolean = list == list.reverse

isPalindrome(List(1, 2, 3, 2, 1))
isPalindrome(List(1, 2, 3, 2))
isPalindrome(List(1, 2, 3, 2, 4))
