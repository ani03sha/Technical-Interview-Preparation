"""
@author Anirudh Sharma

Given an n x n matrix where each of the rows and columns are sorted in ascending order,
return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-10^9 <= matrix[i][j] <= 10^9
All the rows and columns of matrix are guaranteed to be sorted in non-degreasing order.
1 <= k <= n^2
"""


def getPosition(matrix, target):
    # Rows and columns of the matrix
    rows, columns = len(matrix), len(matrix[0])
    # Indices to traverse the matrix
    i = rows - 1
    j = 0
    # Position of the element
    position = 0
    # Loop until we are inside the boundary of the matrix
    while i >= 0 and j < columns:
        if target >= matrix[i][j]:
            position += i + 1
            j += 1
        else:
            i -= 1
    return position


def kthSmallest(matrix, k):
    # Order of the matrix
    N = len(matrix)
    # Smallest element in the matrix
    lowest = matrix[0][0]
    # Greatest element in the matrix
    greatest = matrix[N - 1][N - 1]
    # Binary search in this range
    while lowest < greatest:
        # Middle value
        middle = lowest + (greatest - lowest) // 2
        # Position of the middle value in the sorted matrix
        position = getPosition(matrix, middle)
        # If the position is less than the target
        if position < k:
            # Move to the right half
            lowest = middle + 1
        else:
            greatest = middle
    return greatest


if __name__ == "__main__":
    matrix = [[1, 5, 9], [10, 11, 13], [12, 13, 15]]
    k = 8
    print(kthSmallest(matrix, k))

    matrix = [[-5]]
    k = 1
    print(kthSmallest(matrix, k))
