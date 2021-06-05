import sys

"""
@author Anirudh Sharma

Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].

Matrix [r+1] [c]
Matrix [r+1] [c-1]
Matrix [r+1] [c+1]

Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
"""


def maximumPath(matrix):
    # Special case
    if matrix is None or len(matrix) == 0:
        return 0
    # Order of the matrix
    N = len(matrix)
    # Start from the second last row and move upward
    for i in range(N - 2, -1, -1):
        for j in range(N):
            # Current value
            current = matrix[i][j]
            if j > 0:
                current = max(current, matrix[i + 1][j - 1])
            if j < N - 1:
                current = max(current, matrix[i + 1][j + 1])
            matrix[i][j] += current
    # Maximum sum
    maxSum = -sys.maxsize
    for i in range(N):
        maxSum = max(maxSum, matrix[0][i])
    return maxSum


if __name__ == "__main__":
    matrix = [
        [348, 391],
        [618, 193]
    ]
    print(maximumPath(matrix))

    matrix = [
        [2, 2],
        [2, 2]
    ]
    print(maximumPath(matrix))
