"""
@author Anirudh Sharma
 
Given an m x n matrix, find all common elements present in all rows in O(mn)
time and one traversal of matrix.
"""


def findCommonElements(matrix):
    # Rows and columns of the matrix
    rows = len(matrix)
    columns = len(matrix[0])
    # List to store the result
    commonElements = []
    # Dictionary to store the element and their count in the
    # current row
    countMap = dict()
    # Process the first row
    for i in range(columns):
        countMap[matrix[0][i]] = 1
    # Traverse the rest of the matrix
    for i in range(1, rows):
        for j in range(columns):
            # If the element is present in the map
            # but not duplicated in the current row
            if matrix[i][j] in countMap.keys() and countMap[matrix[i][j]] == i:
                # We increment the count of the element
                countMap[matrix[i][j]] = i + 1
                # If this is the last row
                if i == rows - 1:
                    commonElements.append(matrix[i][j])
    return commonElements


if __name__ == "__main__":
    matrix = [[1, 2, 1, 4, 8], [3, 7, 8, 5, 1],
              [8, 7, 7, 3, 1], [8, 1, 2, 7, 9]]
    print(findCommonElements(matrix))
