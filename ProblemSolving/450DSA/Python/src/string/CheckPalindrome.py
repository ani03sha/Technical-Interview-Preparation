"""
Given a string S, check if it is palindrome or not.
"""


def isPalindrome(s):
    left, right = 0, len(s) - 1
    while left <= right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True


if __name__ == "__main__":
    s = "abba"
    print(isPalindrome(s))

    s = "abc"
    print(isPalindrome(s))
