"""
@author Anirudh Sharma

Given an array of integers arr[] and a number K.You can pair two numbers of the array
if the difference between them is strictly less than K.

The task is to find the maximum possible sum of such disjoint pairs.
The Sum of P pairs is the sum of all 2P numbers of pairs.
"""


def maxSumPairWithDifferenceLessThanK(nums, K):
    # Special case
    if nums is None or len(nums) == 0:
        return 0
    # Sort the array
    nums.sort()
    # Lookup table maximum disjoin sum for first i elements
    lookup = [0] * len(nums)
    # Populate the table
    for i in range(1, len(nums)):
        lookup[i] = lookup[i - 1]
        if nums[i] - nums[i - 1] < K:
            if i >= 2:
                lookup[i] = max(lookup[i], lookup[i - 2] +
                                nums[i] + nums[i - 1])
            else:
                lookup[i] = max(lookup[i], nums[i] + nums[i - 1])
    return lookup[len(lookup) - 1]


if __name__ == "__main__":
    nums = [3, 5, 10, 15, 17, 12, 9]
    K = 4
    print(maxSumPairWithDifferenceLessThanK(nums, K))

    nums = [5, 15, 10, 300]
    K = 12
    print(maxSumPairWithDifferenceLessThanK(nums, K))
