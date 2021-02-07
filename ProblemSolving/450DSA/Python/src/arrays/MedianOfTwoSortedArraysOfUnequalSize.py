import sys

"""
@author Anirudh Sharma

Given two sorted arrays a and b of size m and n respectively,
return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).
"""


def findMedianSortedArrays(a, b):
    # We will be assuming a is the smaller array of the two
    if len(a) > len(b):
        return findMedianSortedArrays(b, a)
    # Lengths of the arrays
    m, n = len(a), len(b)
    # Start and end pointers
    start, end = 0, m
    # Loop until both pointers meet
    while start <= end:
        # Partition for a and b arrays
        partitionA = start + (end - start) // 2
        partitionB = (m + n + 1) // 2 - partitionA
        # Calculate the left and right boundary elements
        leftMaxA = -sys.maxsize if partitionA == 0 else a[partitionA - 1]
        rightMinA = sys.maxsize if partitionA == m else a[partitionA]
        leftMaxB = -sys.maxsize if partitionB == 0 else b[partitionB - 1]
        rightMinB = sys.maxsize if partitionB == n else b[partitionB]
        # Check if we have found the elements
        if leftMaxA <= rightMinB and leftMaxB <= rightMinA:
            # For even elements
            if (m + n) % 2 == 0:
                return (max(leftMaxA, leftMaxB) + min(rightMinA, rightMinB)) / 2
            else:
                return max(leftMaxA, leftMaxB)
        # If we are too far on the right of a
        elif leftMaxA > rightMinB:
            end = partitionA - 1
        # If we are too far on the left of a
        else:
            start = partitionA + 1
    raise Exception("IllegalArgumentException")


if __name__ == "__main__":
    a = [1, 3]
    b = [2]
    print(findMedianSortedArrays(a, b))

    a = [1, 2]
    b = [3, 4]
    print(findMedianSortedArrays(a, b))

    a = [0, 0]
    b = [0, 0]
    print(findMedianSortedArrays(a, b))

    a = []
    b = [1]
    print(findMedianSortedArrays(a, b))

    a = [2]
    b = []
    print(findMedianSortedArrays(a, b))
