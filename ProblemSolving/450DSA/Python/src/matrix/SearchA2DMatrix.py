"""
@author Anirudh Sharma

Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:
<p>
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
"""


def binarySearch(matrix, row, column, target):
    # Start and end pointers
    start, end = 0, column - 1
    # Loop until two pointers meet
    while start <= end:
        # Middle index
        middle = start + (end - start) // 2
        if matrix[row][middle] == target:
            return True
        elif matrix[row][middle] < target:
            start = middle + 1
        else:
            end = middle - 1
    return False


def searchMatrix(matrix, target):
    # Special cases
    if matrix is None or len(matrix) == 0:
        return False
    # Rows and columns of the matrix
    rows, columns = len(matrix), len(matrix[0])
    # Index to traverse through rows
    i = 0
    # Loop for all rows
    while i < rows:
        if matrix[i][0] <= target and matrix[i][columns - 1] >= target:
           # Perform binary search in the current row
            return binarySearch(matrix, i, columns, target)
        i += 1
    return False


if __name__ == "__main__":
    matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
    target = 3
    print(searchMatrix(matrix, target))

    matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
    target = 13
    print(searchMatrix(matrix, target))
