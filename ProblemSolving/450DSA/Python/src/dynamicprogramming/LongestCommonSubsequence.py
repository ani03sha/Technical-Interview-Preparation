"""
 @author Anirudh Sharma
 
 Given two sequences, find the length of longest subsequence present in both of them.
 Both the strings are of uppercase.
"""


def lcs(s1, s2):
    # Special case
    if s1 is None or len(s1) == 0 or s2 is None or len(s2) == 0:
        return 0
    # Lengths of the two strings
    m, n = len(s1), len(s2)
    # Lookup table to store the longest common subsequence
    # for a given value of m and n.
    lookup = [[0 for y in range(n + 1)] for x in range(m + 1)]
    # Populate the table for each character
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            # If current characters are same
            if s1[i - 1] == s2[j - 1]:
                lookup[i][j] = 1 + lookup[i - 1][j - 1]
            else:
                lookup[i][j] = max(lookup[i - 1][j], lookup[i][j - 1])
    return lookup[m][n]


if __name__ == "__main__":
    s1 = "ABCDGH"
    s2 = "AEDFHR"
    print(lcs(s1, s2))

    s1 = "ABC"
    s2 = "AC"
    print(lcs(s1, s2))
