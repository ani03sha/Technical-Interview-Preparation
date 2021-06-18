"""
@author Anirudh Sharma

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some
or no elements without changing the order of the remaining elements.
"""


def longestPalindromeSubsequence(s):
    # Special case
    if s is None or len(s) == 0:
        return 0
    # Length of the string
    n = len(s)
    # Lookup table to store the lengths of longest
    # palindromic substrings from string i to j
    lookup = [[0 for y in range(n)] for x in range(n)]
    # Populate the table
    for i in range(n - 1, -1, -1):
        # Longest palindromic string in a string of
        # length 1 is 1.
        lookup[i][i] = 1
        for j in range(i + 1, n):
            # If characters at both ends are equal
            if (s[i] == s[j]):
                lookup[i][j] = lookup[i + 1][j - 1] + 2
            else:
                lookup[i][j] = max(lookup[i + 1][j], lookup[i][j - 1])
    return lookup[0][n - 1]


if __name__ == "__main__":
    print(longestPalindromeSubsequence("bbbab"))
    print(longestPalindromeSubsequence("cbbd"))
