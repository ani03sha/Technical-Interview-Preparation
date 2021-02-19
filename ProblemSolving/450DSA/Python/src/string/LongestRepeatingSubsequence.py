"""
@author Anirudh Sharma

Given a string str, find length of the longest repeating subseequence such that the two
subsequence don’t have same string character at same position, i.e., any i-th character
in the two subsequences shouldn’t have the same index in the original string.

Constraints:
1 <= |s| <= 500
"""


def longestRepeatingSubsequence(s):
    # Length of the string
    n = len(s)
    # DP array
    dp=[[0 for i in range(n + 1)] for j in range(n + 1)]
    # Fill the DP array
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if s[i - 1] == s[j - 1] and i != j:
                dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
    return dp[n][n]


if __name__ == "__main__":
    print(longestRepeatingSubsequence("banana"))
    print(longestRepeatingSubsequence("abcd"))
    print(longestRepeatingSubsequence("axxxy"))
    print(longestRepeatingSubsequence("aab"))
