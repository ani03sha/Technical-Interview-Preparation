import sys

"""
@author Anirudh Sharma
 
Given an array containing n integers. The problem is to find the sum of the elements of the
contiguous subarray having the smallest(minimum) sum.
"""


def smallestSumSubarray(a):
    # Global and local minimum
    globalMin = sys.maxsize
    localMin = sys.maxsize
    # Traverse through the array
    for element in a:
        # If local min is positive, it cannot
        # contribute to the minimum sum
        if localMin > 0:
            localMin = element
        else:
            localMin += element
        # Update the minimum
        globalMin = min(localMin, globalMin)
    return globalMin


if __name__ == "__main__":
    a = [3, -4, 2, -3, -1, 7, -5]
    print(smallestSumSubarray(a))