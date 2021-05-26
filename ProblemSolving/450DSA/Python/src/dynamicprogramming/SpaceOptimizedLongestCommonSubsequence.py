"""
 @author Anirudh Sharma
 
Given two strings, find the length of longest subsequence present in both of them.
Can we do this in O(n) space?
"""


def spaceOptimizedLCS(s1, s2):
    # Special case
    if s1 is None or len(s1) == 0 or s2 is None or len(s2) == 0:
        return 0
    # Lengths of the two strings
    m, n = len(s1), len(s2)
    # Lookup table to store the longest common subsequence
    # for a given value of m and n.
    lookup = [[0 for y in range(n + 1)] for x in range(2)]
    # Populate the table for each character
    for i in range(1, m + 1):
        binary = 1 & i
        for j in range(1, n + 1):
            # If current characters are same
            if s1[i - 1] == s2[j - 1]:
                lookup[binary][j] = 1 + lookup[1 - binary][j - 1]
            else:
                lookup[binary][j] = max(
                    lookup[1 - binary][j], lookup[binary][j - 1])
    return lookup[binary][n]


if __name__ == "__main__":
    s1 = "ABCDGH"
    s2 = "AEDFHR"
    print(spaceOptimizedLCS(s1, s2))

    s1 = "ABC"
    s2 = "AC"
    print(spaceOptimizedLCS(s1, s2))
