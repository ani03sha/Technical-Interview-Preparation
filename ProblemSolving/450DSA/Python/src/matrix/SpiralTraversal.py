"""
@author Anirudh Sharma
 *
Given an m x n matrix, return all elements of the matrix in spiral order.

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
"""


def spiralOrder(matrix):
    # List to store the elements in spiral order
    spiral = []
    # Special cases
    if matrix is None or len(matrix) == 0:
        return spiral
    # Rows and columns in the matrix
    rows, columns = len(matrix), len(matrix[0])
    # Variables to move left, right, top and bottom
    left, right = 0, columns - 1
    top, bottom = 0, rows - 1
    # Total number of elements in the matrix
    numberOfElements = rows * columns
    # Loop until the size of list is equal to number of
    # elements in the matrix
    while len(spiral) < numberOfElements:
        # Move from left to right
        i = left
        while i <= right and len(spiral) < numberOfElements:
            spiral.append(matrix[top][i])
            i += 1
        top += 1
        # Move from top to bottom
        i = top
        while i <= bottom and len(spiral) < numberOfElements:
            spiral.append(matrix[i][right])
            i += 1
        right -= 1
        # Move from right to left
        i = right
        while i>= left and len(spiral) < numberOfElements:
            spiral.append(matrix[bottom][i])
            i -= 1
        bottom -= 1
        # Move from bottom to up
        i = bottom
        while i >= top and len(spiral) < numberOfElements:
            spiral.append(matrix[i][left])
            i -= 1
        left += 1
    return spiral


if __name__ == "__main__":
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(spiralOrder(matrix))

    matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    print(spiralOrder(matrix))
