"""
@author Anirudh Sharma

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Constraints:

1 <= s.length <= 2000
s consists of lower-case English letters only.
"""


def minimumCuts(s):
    # Special cases
    if s is None or len(s) == 0:
        return 0
    # Length of the string
    n = len(s)
    if n < 2:
        return 1
    # Lookup table to store the partition position
    lookup = [[0 for y in range(n)] for x in range(n)]
    # Array to store the cuts
    cuts = [0] * n
    for i in range(n):
        # Set maximum number of cuts
        cuts[i] = i
        for j in range(i + 1):
            if s[i] == s[j] and (i - j < 2 or lookup[j + 1][i - 1]):
                lookup[j][i] = True
                if j > 0:
                    cuts[i] = min(cuts[i], cuts[j - 1] + 1)
                else:
                    cuts[i] = 0
    return cuts[n - 1]


if __name__ == "__main__":
    s = "aab"
    print(minimumCuts(s))

    s = "a"
    print(minimumCuts(s))

    s = "ab"
    print(minimumCuts(s))
