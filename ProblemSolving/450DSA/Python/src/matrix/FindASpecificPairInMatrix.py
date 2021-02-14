"""
@author Anirudh Sharma

Given an n x n matrix mat[n][n] of integers, find the maximum value of mat(c, d) – mat(a, b)
over all choices of indexes such that both c > a and d > b.
"""


def findMaxValue(matrix):
    # Order of the matrix
    n = len(matrix)
    # Matrix to store maximum of elements from i,j to N-1,N-1
    maxValues = [[0 for i in range(n)]
                 for j in range(n)]
    # Last value in maxValues will be the last value in the
    # input matrix
    maxValue = matrix[n - 1][n - 1]
    # Preprocess last row
    maxV = matrix[n - 1][n - 1]
    for i in range(n - 2, -1, -1):
        maxV = max(maxV, matrix[n-1][i])
        maxValues[n - 1][i] = maxV
    # Preprocess last column
    maxV = matrix[n - 1][n - 1]
    for i in range(n - 2, -1, -1):
        maxV = max(maxV, matrix[i][n-1])
        maxValues[i][n - 1] = maxV
    # Preprocess rest of the matrix
    for i in range(n - 2, -1, -1):
        for j in range(n - 2, -1, -1):
            maxValue = max(maxValue, maxValues[i + 1][j + 1] - matrix[i][j])
            maxValues[i][j] = max(matrix[i][j], max(
                maxValues[i][j + 1], maxValues[i + 1][j]))
    return maxValue


if __name__ == "__main__":
    matrix = [[1, 2, - 1, -4, -20], [-8, -3, 4, 2, 1],
              [3, 8, 6, 1, 3], [-4, -1, 1, 7, -6], [0, -4, 10, -5, 1]]
    print(findMaxValue(matrix))
