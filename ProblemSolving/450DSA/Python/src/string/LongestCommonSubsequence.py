"""
@author Anirudh Sharma

Given two strings text1 and text2, return the length of their longest common subsequence.
If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some
characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
"""


def longestCommonSubsequence(text1, text2):
    # Lengths of the strings
    m, n = len(text1), len(text2)
    # DP array
    dp = [[0 for j in range(n + 1)] for i in range(m + 1)]
    # Loop through the texts
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            # Check if characters are same
            if text1[i - 1] == text2[j - 1]:
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp[m][n]


if __name__ == "__main__":
    text1 = "abcde"
    text2 = "ace"
    print(longestCommonSubsequence(text1, text2))

    text1 = "abc"
    text2 = "abc"
    print(longestCommonSubsequence(text1, text2))

    text1 = "abc"
    text2 = "def"
    print(longestCommonSubsequence(text1, text2))
