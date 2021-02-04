"""
@author Anirudh Sharma

Given an array of positive integers nums and a positive integer target, return the minimal
length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is
greater than or equal to target. If there is no such subarray, return 0 instead.

Constraints:

1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
"""
import sys


def minSubArrayLen(target, nums):
    # Length of the array
    n = len(nums)
    # Start and end pointers
    start, end = 0, 0
    # Minimum length of the subarray
    minimumLength = sys.maxsize
    # Sum of the subarray
    currentSum = 0
    # Loop until the end pointer reaches to the end
    # of the array
    while end < n:
        # Loop until we get sum greater than or
        # equal to the target
        while currentSum < target and end < n:
            currentSum += nums[end]
            end += 1
        # As soon as we get sum greater than target,
        # we will start removing elements from the start
        while currentSum >= target and start < n:
            minimumLength = min(minimumLength, end - start)
            currentSum -= nums[start]
            start += 1
    return 0 if minimumLength == sys.maxsize else minimumLength


if __name__ == "__main__":
    a = [2, 3, 1, 2, 4, 3]
    t = 7
    print(minSubArrayLen(t, a))

    a = [1, 4, 4]
    t = 4
    print(minSubArrayLen(t, a))

    a = [1, 1, 1, 1, 1, 1, 1, 1]
    t = 11
    print(minSubArrayLen(t, a))
