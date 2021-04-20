"""
@author Anirudh Sharma

Given two strings s and t. Find the minimum number of operations that need to be performed
on s to convert it to t.
The possible operations are:
- Insert
- Remove
- Replace

Constraints:
1 <= Length of both strings <= 100
Both the strings are in lowercase.
"""


def editDistanceHelper(s, t, a, b, lookup):
    # If s is empty, then we need to insert
    # all the characters from t.
    if a == 0:
        return b
    # If t is empty, then we need to remove
    # all the characters from s.
    if b == 0:
        return a
    # If the key is present in the lookup
    if lookup[a][b] != -1:
        return lookup[a][b]
    # Check if the last characters of both strings are
    # same, then we will recur for the remaining strings
    if s[a - 1] == t[b - 1]:
        lookup[a][b] = editDistanceHelper(s, t, a - 1, b - 1, lookup)
        return lookup[a][b]
    # If the characters are different, then we will
    # check for all the combinations of both the strings
    lookup[a][b] = 1 + min(editDistanceHelper(s, t, a - 1, b, lookup),
                           editDistanceHelper(s, t, a, b - 1, lookup),
                           editDistanceHelper(s, t, a - 1, b - 1, lookup))
    return lookup[a][b]


def editDistance(s, t):
    # Lengths of strings
    a, b = len(s), len(t)
    # Lookup table for memoization
    lookup = [[-1 for i in range(a + 1)] for i in range(b + 1)]
    return editDistanceHelper(s, t, a, b, lookup)


if __name__ == "__main__":
    s = "abcdefmnopqr"
    t = "ghijklstuvwx"
    print(editDistance(s, t))
