"""
@author Anirudh Sharma

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements 
without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence 
of the array [0,3,1,6,2,2,7].

Constraints:

1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4
"""


def lengthOfLIS(nums):
    # Special case
    if nums is None or len(nums) == 0:
        return 0
    # Length of the array
    n = len(nums)
    # Lookup table to store the longest increasing
    # subsequence until a certain index.
    # lookup[i] => length of longest increasing sub
    # -sequence endding at index i
    # Since every element is an increasing sequence of
    # length 1.
    lookup = [1] * n
    # Loop through the array
    for i in range(n):
        for j in range(i):
            if nums[i] > nums[j] and lookup[i] < lookup[j] + 1:
                lookup[i] = lookup[j] + 1
    # Find the maximum value in the lookup table
    longest = 0
    for x in lookup:
        longest = max(longest, x)
    return longest


if __name__ == "__main__":
    nums = [10,9,2,5,3,7,101,18]
    print(lengthOfLIS(nums))

    nums = [0,1,0,3,2,3]
    print(lengthOfLIS(nums))

    nums = [7,7,7,7,7,7,7]
    print(lengthOfLIS(nums))