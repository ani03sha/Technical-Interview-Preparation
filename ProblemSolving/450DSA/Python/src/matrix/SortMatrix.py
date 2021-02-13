"""
@author Anirudh Sharma

Given an NxN matrix Mat. Sort all elements of the matrix.
"""


def sort(matrix):
    # Special case
    if matrix is None and len(matrix) == 0:
        return matrix
    # Rows and columns of the matrix
    rows, columns = len(matrix), len(matrix[0])
    # List to store elements of the matrix
    elements = [-1] * (rows * columns)
    # Index of the elements array
    index = 0
    # Store all the elements in the matrix in the array
    for i in range(rows):
        for j in range(columns):
            elements[index] = matrix[i][j]
            index += 1
    # Sort the array
    elements.sort()
    # Reset the index
    index = 0
    # Refill the matrix
    for i in range(rows):
        for j in range(columns):
            matrix[i][j] = elements[index]
            index += 1
    return matrix


if __name__ == "__main__":
    matrix = [[10, 20, 30, 40], [15, 25, 35, 45],
              [27, 29, 37, 48], [32, 33, 39, 50]]
    print(sort(matrix))

    matrix = [[1, 5, 3], [2, 8, 7], [4, 6, 9]]
    print(sort(matrix))
