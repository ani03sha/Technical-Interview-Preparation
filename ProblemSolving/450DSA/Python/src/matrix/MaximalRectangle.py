"""
@author Anirudh Sharma

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle
containing only 1's and return its area.

Constraints:

rows == matrix.length
cols == matrix.length
0 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
"""


def largestRectangleInHistogram(heights):
    # special cases
    if (heights is None or len(heights) == 0):
        return 0
    if (len(heights) == 1):
        return heights[0]
    # stack to store the index of elements whose value is
    # greater than the top of the stack
    indices = list()
    # Maximum area of the histogram
    maxArea = 0
    # Index to traverse through the heights array
    index = 0
    # Loop through the array
    while index < len(heights):
        if not indices or heights[indices[-1]] <= heights[index]:
            indices.append(index)
            index += 1
        else:
            # Top of the stack
            top = indices.pop()
            # Local area
            localArea = heights[top] * \
                (index - indices[-1] - 1 if indices else index)
            maxArea = max(maxArea, localArea)
    # For remaning elements in the stack
    while indices:
        # Pop the top
        top = indices.pop()
        # Calculate the area with
        # histogram[top_of_stack]
        # stack as smallest bar
        localArea = (heights[top] *
                     ((index - indices[-1] - 1) if indices else index))
        # Update max area, if needed
        maxArea = max(maxArea, localArea)
    return maxArea


def maximalRectangle(matrix):
    # Special cases
    if matrix is None or len(matrix) == 0:
        return 0
    # Rows and columns of the matrix
    rows, columns = len(matrix), len(matrix[0])
    # List to store every row
    rowArray = [None] * columns
    # Fill the rowArray with first row of the matrix
    for i in range(columns):
        rowArray[i] = int(matrix[0][i])
    # Max area for this row
    maxArea = largestRectangleInHistogram(rowArray)
    # Loop for every other row
    for i in range(1, rows):
        # Again fill the row array
        for j in range(columns):
            if matrix[i][j] == "0":
                rowArray[j] = 0
            else:
                rowArray[j] += int(matrix[i][j])
        maxArea = max(maxArea, largestRectangleInHistogram(rowArray))
    return maxArea


if __name__ == "__main__":
    matrix = [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"],
              ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]
    print(maximalRectangle(matrix))

    matrix = []
    print(maximalRectangle(matrix))

    matrix = [["0"]]
    print(maximalRectangle(matrix))

    matrix = [["1"]]
    print(maximalRectangle(matrix))

    matrix = [["1", "1"]]
    print(maximalRectangle(matrix))
