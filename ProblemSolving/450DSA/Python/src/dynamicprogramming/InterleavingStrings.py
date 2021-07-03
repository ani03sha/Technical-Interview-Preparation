"""
@author Anirudh Sharma

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty
substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1

The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...

Note: a + b is the concatenation of strings a and b.
"""


def isInterleave(s1, s2, s3):
    # Special case
    if s1 is None or s2 is None or s3 is None:
        return False
    # Lengths of the strings
    m, n = len(s1), len(s2)
    # Special case
    if m + n != len(s3):
        return False
    # Lookup table to store if the substrings ending
    # at i and j are interleaved or not
    lookup = [[False for y in range(n + 1)] for x in range(m + 1)]
    # Populate the lookup table
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 and j == 0:
                lookup[i][j] = True
            elif i == 0:
                if s2[j - 1] == s3[j - 1]:
                    lookup[i][j] = lookup[i][j - 1]
            elif j == 0:
                if s1[i - 1] == s3[i - 1]:
                    lookup[i][j] = lookup[i - 1][j]
            elif s1[i - 1] == s3[i + j - 1] and s2[j - 1] != s3[i + j - 1]:
                lookup[i][j] = lookup[i - 1][j]
            elif s1[i - 1] != s3[i + j - 1] and s2[j - 1] == s3[i + j - 1]:
                lookup[i][j] = lookup[i][j - 1]
            elif s1[i - 1] == s3[i + j - 1] and s2[j - 1] == s3[i + j - 1]:
                lookup[i][j] = lookup[i - 1][j] or lookup[i][j - 1]
    return lookup[m][n]


if __name__ == "__main__":
    s1 = "YX"
    s2 = "X"
    s3 = "XXY"
    print(isInterleave(s1, s2, s3))

    s1 = "XY"
    s2 = "X"
    s3 = "XXY"
    print(isInterleave(s1, s2, s3))
