"""
@author Anirudh Sharma

You are given an array A of size N. The array contains integers and is of even length.
The elements of the array represent N coin of values V1, V2, ....Vn.
You play against an opponent in an alternating way.

In each turn, a player selects either the first or last coin from the row, removes it from
the row permanently, and receives the value of the coin.

You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.
"""


def countMaximum(nums):
    # Special case
    if nums is None or len(nums) == 0:
        return 0
    # Length of the array
    n = len(nums)
    # Lookup table to store the maximum value between
    # certain indices
    lookup = [[0 for y in range(n)] for x in range(n)]
    for gap in range(n):
        for j in range(gap, n):
            i = j - gap
            if gap == 0:
                lookup[i][j] = nums[i]
            elif gap == 1:
                lookup[i][j] = max(nums[i], nums[j])
            else:
                lookup[i][j] = max(nums[i] + min(lookup[i + 2][j], lookup[i + 1][j - 1]),
                                   nums[j] + min(lookup[i + 1][j - 1], lookup[i][j - 2]))
    return lookup[0][n - 1]


if __name__ == "__main__":
    nums = [5, 3, 7, 10]
    print(countMaximum(nums))

    nums = [8, 15, 3, 7]
    print(countMaximum(nums))
