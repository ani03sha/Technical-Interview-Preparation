"""
@author Anirudh Sharma

Given a string s, return the longest palindromic substring in s.

Constraints
1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case).
"""


def expandFromCenter(s, left, right):
    # Base case
    if s is None or left > right:
        return 0
    # Loop until the characters on left and right are same
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return right - left - 1


def longestPalindrome(s):
    # Special case
    if s is None or len(s) == 0:
        return ""
    # Start and end pointers for the substring
    start, end = 0, 0
    # Loop through the entire string
    for i in range(len(s)):
        # String with even length
        a = expandFromCenter(s, i, i)
        # String with odd length
        b = expandFromCenter(s, i, i + 1)
        # Maxmum of the two lengths
        c = max(a, b)
        # Get the length of the longest palindromic substring
        if c > end - start:
            start = i - (c - 1) // 2
            end = i + c // 2
    return s[start:(end + 1)]


if __name__ == "__main__":
    print(longestPalindrome("babad"))
    print(longestPalindrome("cbbd"))
    print(longestPalindrome("a"))
    print(longestPalindrome("ac"))
