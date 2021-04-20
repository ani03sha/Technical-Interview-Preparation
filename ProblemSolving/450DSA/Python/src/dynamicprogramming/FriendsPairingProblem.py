"""
@author Anirudh Sharma

Given N friends, each one can remain single or can be paired up with some other friend.
Each friend can be paired only once.
Find out the total number of ways in which friends can remain single or can be paired up.
Note: Since answer can be very large, return your answer mod 10^9+7.

Constraints:
1 <= N <= 10^6
"""


def countFriendsPairings(n):
    # DP array for bottom up approach
    dp = [0] * (n + 1)
    # If there are zero persons, the number
    # of ways will be zero
    dp[0] = 0
    # If there is one person, it cannot be paired
    dp[1] = 1
    # If there are two persons, then there can be only
    # two ways - single and pair
    dp[2] = 2
    # Loop for remaining persons
    for i in range(3, n + 1):
        dp[i] = dp[i - 1] + (i - 1) * dp[i - 2]
    return dp[n] % 1000000007


if __name__ == "__main__":
    print(countFriendsPairings(3))
    print(countFriendsPairings(2))
    print(countFriendsPairings(4))
    print(countFriendsPairings(30))
