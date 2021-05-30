"""
@author Anirudh Sharma
 *
Given an integer array arr and an integer difference, return the length of the
longest subsequence in arr which is an arithmetic sequence such that the difference
between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements
without changing the order of the remaining elements.

Constraints:

1 <= arr.length <= 10^5
-10^4 <= arr[i], difference <= 10^4
"""


def longestSubsequence(nums, difference):
    # Special case
    if nums is None or len(nums) == 0:
        return 0
    # Lookup table to store the difference between the
    # current element and the given difference.
    # This will allow us to mark all the elements that
    # are valid for the subsequence
    lookup = {}
    # Variable to store the longest length
    longestLength = 0
    # Loop through the array
    for num in nums:
        if (num - difference) in lookup.keys():
            lookup[num] = lookup[num - difference] + 1
        else:
            lookup[num] = 1
        longestLength = max(longestLength, lookup.get(num))
    return longestLength


if __name__ == "__main__":
    nums = [1, 2, 3, 4]
    difference = 1
    print(longestSubsequence(nums, difference))

    nums = [1, 3, 5, 7]
    difference = 1
    print(longestSubsequence(nums, difference))

    nums = [1, 5, 7, 8, 5, 3, 4, 2, 1]
    difference = -2
    print(longestSubsequence(nums, difference))
