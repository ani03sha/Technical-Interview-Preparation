"""
@author Anirudh Sharma

Given a string s, find number of palindromic subsequence (need not necessarily be distinct)
which could be formed from the string.
"""


def expandFromMiddle(s, left, right):
    count = 0
    # Check for equality
    while left >= 0 and right < len(s) and s[left] == s[right]:
        # Update the count
        count += 1
        # Expand both sides
        left -= 1
        right += 1
    return count


def countPalindromicSubsequences(s):
    # Count of all the palindromic subsequences
    count = 0
    # Loop through the string
    for i in range(len(s)):
        # For odd length string, expand from s[i]
        count += expandFromMiddle(s, i, i)
        # For odd length string, expand from s[i] and s[1+1]
        count += expandFromMiddle(s, i, i + 1)
    return count


if __name__ == "__main__":
    print(countPalindromicSubsequences("abcd"))
    print(countPalindromicSubsequences("aab"))
    print(countPalindromicSubsequences("aaaaaaaaaaaaaaaaaaaaaaaaaaa"))
