"""
@author Anirudh Sharma

Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
"""


def maxSubarraySum(a):
    # Length of the array
    n = len(a)
    # Global maxima
    globalMax = a[0]
    localMax = a[0]
    # Loop through the elements of the list
    for i in range(1, n):
        localMax = max(a[i], a[i] + localMax)
        globalMax = max(localMax, globalMax)
    return globalMax


if __name__ == "__main__":
    a = [1, 2, 3, -2, 5]
    print(maxSubarraySum(a))

    a = [-1, -2, -3, -4]
    print(maxSubarraySum(a))
