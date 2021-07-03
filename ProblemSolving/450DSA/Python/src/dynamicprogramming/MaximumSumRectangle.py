import sys

"""
@author Anirudh Sharma
 
Given a 2D matrix, find the maximum sum subarray in it.
"""


def maximumSumRectangle(matrix):
    # Special case
    if matrix is None or len(matrix) == 0:
        return 0
    # Dimensions of the matrix
    m, n = len(matrix), len(matrix[0])
    # Store the prefix sum of each row
    prefixSum = [[0 for y in range(n)] for x in range(m)]
    for i in range(m):
        for j in range(n):
            prefixSum[i][j] = matrix[i][j]
    for i in range(m):
        for j in range(1, n):
            prefixSum[i][j] += prefixSum[i][j - 1]
    # Start and end pointers of required rectangle
    startRow = 0
    endRow = 0
    startColumn = 0
    endColumn = 0
    # Maximum sum
    maxSum = -sys.maxsize
    # Try for every column
    for i in range(n):
        for j in range(i, n):
            # Stores the between two columns for
            # each row
            temp = [0] * m
            for k in range(m):
                temp[k] = prefixSum[k][j] - \
                    (prefixSum[k][i - 1] if i > 0 else 0)
            currentSum = 0
            currentMaxSum = 0
            currentStartRow = 0
            currentEndRow = -1
            tempStartRow = 0
            for k in range(m):
                currentSum += temp[k]
                if currentSum < 0:
                    currentSum = 0
                    tempStartRow = k + 1
                elif currentSum > currentMaxSum:
                    currentMaxSum = currentSum
                    currentStartRow = tempStartRow
                    currentEndRow = k
            if currentEndRow == -1:
                currentMaxSum = temp[0]
                currentStartRow = 0
                currentEndRow = 0
                for k in range(1, m):
                    if temp[k] > currentMaxSum:
                        currentStartRow = k
                        currentEndRow = k
            if currentMaxSum > maxSum:
                maxSum = currentMaxSum
                startColumn = i
                endColumn = j
                startRow = currentStartRow
                endRow = currentEndRow
    print("Maximum sum rectangle:")
    for i in range(startRow, endRow + 1):
        for j in range(startColumn, endColumn + 1):
            print(matrix[i][j],  end=" ")
        print()
    return maxSum


if __name__ == "__main__":
    matrix = [
        [1, 2, -1, -4, -20],
        [-8, -3, 4, 2, 1],
        [3, 8, 10, 1, 3],
        [-4, -1, 1, 7, -6]
    ]
    print("Max sum: " + str(maximumSumRectangle(matrix)) + "\n")

    matrix = [
        [-1, -2],
        [-3, -4]
    ]
    print("Max sum: " + str(maximumSumRectangle(matrix)) + "\n")
