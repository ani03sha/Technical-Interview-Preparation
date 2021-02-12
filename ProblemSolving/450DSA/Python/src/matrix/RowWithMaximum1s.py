"""
* @author Anirudh Sharma

Given a boolean 2D array of n x m dimensions where each row is sorted.
Find the 0-based index of the first row that has the maximum number of 1's.

Constraints:
1 ≤ N, M ≤ 10^3
0 ≤ Arr[i][j] ≤ 1
"""


def rowWithMaximum1s(matrix):
    # Index of row with maximum 1s
    rowWithMaximum1sIndex = -1
    # Rows and columns of the matrix
    rows, columns = len(matrix), len(matrix[0])
    # Current column
    currentColumn = columns -1
    # Loop for each row
    for i in range(rows):
        # Start from top right corner of the matrix
        while currentColumn >= 0 and matrix[i][currentColumn] == 1:
            currentColumn -= 1
            rowWithMaximum1sIndex = i
    return rowWithMaximum1sIndex


if __name__ == "__main__":
    matrix = [[0, 1, 1, 1], [0, 0, 1, 1], [1, 1, 1, 1], [0, 0, 0, 0]]
    print(rowWithMaximum1s(matrix))

    matrix = [[0, 0], [1, 1]]
    print(rowWithMaximum1s(matrix))
