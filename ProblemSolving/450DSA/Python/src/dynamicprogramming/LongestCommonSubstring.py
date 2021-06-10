"""
@author Anirudh Sharma
 
Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
"""


def findLCS(X, Y):
    # Special cases
    if X is None or len(X) == 0 or Y is None or len(Y) == 0:
        return 0
    # Lengths of the two strings
    m, n = len(X), len(Y)
    # Lookup table to store the lcs length
    lookup = [[0 for y in range(n + 1)] for x in range(m + 1)]
    # Length of the final lcs
    lcsLength = 0
    for i in range(m + 1):
        for j in range(n + 1):
            if i > 0 and j > 0 and X[i - 1] == Y[j - 1]:
                lookup[i][j] = 1 + lookup[i - 1][j - 1]
                lcsLength = max(lcsLength, lookup[i][j])
    return lcsLength


if __name__ == "__main__":
    X = "ABCDGH"
    Y = "ACDGHR"
    print(findLCS(X, Y))

    X = "ABC"
    Y = "ACB"
    print(findLCS(X, Y))
