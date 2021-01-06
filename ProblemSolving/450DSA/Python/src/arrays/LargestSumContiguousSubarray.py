"""
@author Anirudh Sharma

Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
"""


def maxSumSubarray(a):
    if a is None or len(a) == 0:
        return 0
    # Global and local maxima
    localMax = a[0]
    globalMax = a[0]
    # Loop through the elements of the array
    for i in range(1, len(a)):
        localMax = max(a[i], localMax + a[i])
        globalMax = max(localMax, globalMax)
    return globalMax


if __name__ == "__main__":
    print(maxSumSubarray([1, 2, 3, -2, 5]))
    print(maxSumSubarray([-1, -2, -3, -4]))
    print(maxSumSubarray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
    print(maxSumSubarray([1]))
    print(maxSumSubarray([0]))
    print(maxSumSubarray([-1]))
