"""
@author Anirudh Sharma

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing
only 1's and return its area.

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
"""


def maximalSquare(matrix):
    # Special case
    if matrix is None or len(matrix) == 0:
        return 0
    # Rows and columns of the matrix
    m, n = len(matrix), len(matrix[0])
    # Lookup table to store the size of the sub-matrix
    # of which current cell is the bottom right corner
    lookup = [[0 for y in range(n + 1)] for x in range(m + 1)]
    # Variable to keep track of biggest square matrix seen so far
    maxSize = 0
    # Loop through the matrix and populate the lookup table
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            # If the current cell has 1, then we can consider
            # it as a valid case and try to make it as the part
            # of the valid sub matrix
            if matrix[i - 1][j - 1] == '1':
                lookup[i][j] = min(lookup[i - 1][j], lookup[i - 1]
                                   [j - 1], lookup[i][j - 1]) + 1
                maxSize = max(maxSize, lookup[i][j])
    return maxSize * maxSize


if __name__ == "__main__":
    matrix = [
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0']
    ]
    print(maximalSquare(matrix))

    matrix = [
        ['0', '1'],
        ['1', '0']
    ]
    print(maximalSquare(matrix))

    matrix = [
        ['0']
    ]
    print(maximalSquare(matrix))
