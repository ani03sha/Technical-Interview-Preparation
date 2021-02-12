"""
@author Anirudh Sharma

Given a row wise sorted matrix of size RxC where R and C are always odd,
find the median of the matrix.

Constraints:
1<= R,C <=150
1<= matrix[i][j] <=1000
"""
import sys


def binarySearch(arr, x):
    start, end = 0, len(arr) - 1
    # Loop until the two pointers meet
    while start <= end:
        # Find the mid index
        mid = start + (end - start) // 2
        # If element is present at mid, return mid
        if arr[mid] == x:
            return mid
        # Else look in left or right half accordingly
        elif arr[mid] < x:
            start = mid + 1
        else:
            end = mid - 1
    return -(start + 1)


def findMedian(matrix):
    # Rows and columns in the matrix
    rows, columns = len(matrix), len(matrix[0])
    # Special case
    if rows == 1 and columns == 1:
        return matrix[rows - 1][columns - 1]
    # Maximum and minimum elements in the matrix
    minimumElement = matrix[0][0]
    maximumElement = 0
    # Find maximum and minimum elements in the matrix
    for i in range(rows):
        minimumElement = min(minimumElement, matrix[i][0])
        maximumElement = max(maximumElement, matrix[i][columns - 1])
    # Since now we have a range of minimum and maximum elements
    # in the matrix, we would run binary search on this range to
    # find the number of elements which are less than our median
    # index(rows + columns + 1) / 2.
    # Desired median index
    desiredIndex = (rows * columns + 1) // 2
    while minimumElement < maximumElement:
        middleElement = minimumElement + (maximumElement - minimumElement) // 2
        # Count of elements less than middleElement
        count = 0
        # Loop for each row
        for i in range(rows):
            # Index of middleElement in the row, if present
            middleElementIndex = binarySearch(matrix[i], middleElement)
            # If element is not found in the row
            if middleElementIndex < 0:
                middleElementIndex = abs(middleElementIndex) - 1
            # If element is found in the array
            else:
                while middleElementIndex < columns and matrix[i][middleElementIndex] == middleElement:
                    middleElementIndex += 1
            count += middleElementIndex
        if count < desiredIndex:
            minimumElement = middleElement + 1
        else:
            maximumElement = middleElement
    return minimumElement


if __name__ == "__main__":
    matrix = [[1, 3, 5], [2, 6, 9], [3, 6, 9]]
    print(findMedian(matrix))
