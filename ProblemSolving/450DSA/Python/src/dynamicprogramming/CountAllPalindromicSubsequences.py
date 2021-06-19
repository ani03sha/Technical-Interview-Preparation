"""
@author Anirudh Sharma

Find how many palindromic subsequences (need not necessarily be distinct) can be formed
in a given string.
Note that the empty string is not considered as a palindrome.
"""


def countPalindromicSubsequences(s):
    # Special case
    if s is None or len(s) == 0:
        return 0
    # Length of the string
    n = len(s)
    # Lookup table to store the palindromic subsequences
    lookup = [[0 for y in range(n)] for x in range(n)]
    # Populate the lookup table for strings of length 1
    for i in range(n):
        lookup[i][i] = 1
    # Populate for other combinations
    for i in range(2, n + 1):
        for j in range(0, n - i + 1):
            k = i + j - 1
            # If extreme characters are same
            if s[j] == s[k]:
                lookup[j][k] = lookup[j + 1][k] + lookup[j][k - 1] + 1
            else:
                lookup[j][k] = lookup[j + 1][k] + \
                    lookup[j][k - 1] - lookup[j + 1][k - 1]
    return lookup[0][n - 1]


if __name__ == "__main__":
    s = "abcb"
    print(countPalindromicSubsequences(s))

    s = "abcd"
    print(countPalindromicSubsequences(s))

    s = "aaaa"
    print(countPalindromicSubsequences(s))
