"""
@author Anirudh Sharma
 
Given a binary matrix, find the largest area rectangular sub-matrix with equal number of 1’s and 0’s.
"""


def largestSubmatrix(matrix):
    # Special case
    if matrix is None or len(matrix) == 0:
        return
    # Order of matrix
    m = len(matrix)
    n = len(matrix[0])
    # Convert all 0s to 1s so that the problem
    # is reduced to largest zero sum submatrix
    for i in range(m):
        for j in range(n):
            matrix[i][j] = 1 if matrix[i][j] > 0 else -1
    # Array to store the row prefix sum
    prefixSum = [[0 for y in range(n)] for x in range(m)]
    # Base initialization
    for i in range(m):
        for j in range(n):
            prefixSum[i][j] = matrix[i][j]
    # Calculate the prefix sum of each row
    for i in range(m):
        for j in range(1, n):
            prefixSum[i][j] += prefixSum[i][j - 1]
    # Variables for storing the starting and end
    # points of the largest zero sum sub matrix
    startRow = 0
    endRow = 0
    startColumn = 0
    endColumn = 0
    # Maximum size of the matrix
    maxSize = 0
    for i in range(n):
        for j in range(n):
            # Stores sum between two columns for each row
            temp = [0] * m
            for k in range(m):
                temp[k] = prefixSum[k][j] - \
                    (prefixSum[k][i - 1] if i > 0 else 0)
            currentSum = 0
            # Dictionary to store the row sum
            rowSumMap = {}
            rowSumMap[0] = -1
            for k in range(m):
                currentSum += temp[k]
                if currentSum in rowSumMap.keys():
                    subMatrixSize = (j - i + 1) * \
                        (k - rowSumMap.get(currentSum))
                    if subMatrixSize > maxSize:
                        maxSize = subMatrixSize
                        startColumn = i
                        endColumn = j
                        startRow = rowSumMap.get(currentSum) + 1
                        endRow = k
                else:
                    rowSumMap[currentSum] = k
    for i in range(startRow, endRow + 1):
        for j in range(startColumn, endColumn + 1):
            print(1 if matrix[i][j] > 0 else 0, end=" ")
        print()


if __name__ == "__main__":
    matrix = [
        [0, 0, 1, 1],
        [0, 1, 1, 0],
        [1, 1, 1, 0],
        [1, 0, 0, 1]
    ]
    largestSubmatrix(matrix)