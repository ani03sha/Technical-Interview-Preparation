"""
@author Anirudh Sharma

Given an array arr of N positive integers, the task is to find the maximum sum increasing
subsequence of the given array.
"""


def maximumSum(nums):
    # Special case
    if nums is None or len(nums) == 0:
        return 0
    # Length of the array
    n = len(nums)
    # Lookup table to store the maximum sum
    # until a certain index
    lookup = [0] * n
    # Fill the table with the original array values
    for i in range(n):
        lookup[i] = nums[i]
    # Traverse through the array to fill table
    for i in range(1, n):
        for j in range(0, i):
            if nums[j] < nums[i]:
                lookup[i] = max(lookup[i], lookup[j] + nums[i])
    # Maximum value
    maximumValue = lookup[0]
    for i in range(1, n):
        maximumValue = max(maximumValue, lookup[i])
    return maximumValue


if __name__ == "__main__":
    nums = [1, 101, 2, 3, 100]
    print(maximumSum(nums))

    nums = [1, 2, 3]
    print(maximumSum(nums))
