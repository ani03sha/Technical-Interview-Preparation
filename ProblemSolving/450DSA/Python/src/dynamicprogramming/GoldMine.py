"""
@author Anirudh Sharma

Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which
is the amount of gold in tons. Initially the miner is at first column but can be at any row.

He can move only (right->,right up /,right down\) that is from a given cell, the miner can
move to the cell diagonally up towards the right or right or diagonally down towards the right.

Find out maximum amount of gold he can collect.
"""


def calculateMaxGold(mine):
    # Special case
    if mine is None or len(mine) == 0:
        return 0
    # Rows and columns of the mine
    m, n = len(mine), len(mine[0])
    # Lookup table to store the maximum gold until a cell
    lookup = [[0 for y in range(n)] for x in range(m)]
    # Start populating the table from the right or last column
    # Populate for remaining cells
    for i in range(m):
        for j in range(n - 1, -1, -1):
            # If we go to the right
            right = 0 if j == n - 1 else lookup[i][j + 1]
            # Going right up
            rightUp = 0 if (i == 0 or j == n - 1) else lookup[i - 1][j + 1]
            # Going right down
            rightDown = 0 if (i == m - 1 or j == n -
                              1) else lookup[i + 1][j + 1]
            # Select the max of above three and add it to the
            # gold in the current cell
            lookup[i][j] = mine[i][j] + max(right, rightUp, rightDown)
    # Now the maximum amount of gold collected will be the maximum
    # value in the first column
    maxGoldCollected = 0
    for i in range(m):
        maxGoldCollected = max(maxGoldCollected, lookup[i][0])
    return maxGoldCollected


if __name__ == "__main__":
    mine = [
        [1, 3, 1, 5],
        [2, 2, 4, 1],
        [5, 0, 2, 3],
        [0, 6, 1, 2]
    ]
    print(calculateMaxGold(mine))
