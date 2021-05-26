"""
@author Anirudh Sharma

Given 3 strings A, B and C, the task is to find the longest common sub-sequence in all three given sequences.
"""


def lcsOfThreeStrings(A, B, C):
    # Length of the strings
    a, b, c = len(A), len(B), len(C)
    # Lookup table
    lookup = [[[0 for i in range(c + 1)] for j in range(b + 1)]
              for k in range(a + 1)]
    for i in range(1, a + 1):
        for j in range(1, b + 1):
            for k in range(1, c + 1):
                if A[i - 1] == B[j - 1] and A[i - 1] == C[k - 1]:
                    lookup[i][j][k] = lookup[i - 1][j - 1][k - 1] + 1
                else:
                    lookup[i][j][k] = max(max(lookup[i - 1][j][k], lookup[i][j - 1][k]), lookup[i][j][k - 1])
    return lookup[a][b][c]


if __name__ == "__main__":
    A = "geeks"
    B = "geeksfor"
    C = "geeksforgeeks"
    print(lcsOfThreeStrings(A, B, C))

    A = "abcd"
    B = "efgh"
    C = "ijkl"
    print(lcsOfThreeStrings(A, B, C))
