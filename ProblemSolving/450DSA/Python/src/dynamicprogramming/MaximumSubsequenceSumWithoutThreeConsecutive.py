"""
@author Anirudh Sharma

Given a sequence of positive numbers, find the maximum sum that can be formed which has
no three consecutive elements present.
"""


def maxSubsequenceSum(nums):
    # Special case
    if nums is None or len(nums) == 0:
        return 0
    # Length of the array
    n = len(nums)
    # Lookup table to store sum in the subarray[0...i]
    # where no three elements are consecutive
    lookup = [0] * n
    # Base initialization
    lookup[0] = nums[0]
    if n >= 2:
        lookup[1] = nums[0] + nums[1]
    if n > 2:
        lookup[2] = max(lookup[1], nums[0] + nums[2], nums[1] + nums[2])
    # Populate the remaining table
    for i in range(3, n):
        lookup[i] = max(max(lookup[i - 1], lookup[i - 2] + nums[i]),
                        nums[i] + nums[i - 1] + lookup[i - 3])
    return lookup[n - 1]


if __name__ == "__main__":
    nums = [1, 2, 3]
    print(maxSubsequenceSum(nums))

    nums = [3000, 2000, 1000, 3, 10]
    print(maxSubsequenceSum(nums))

    nums = [100, 1000, 100, 1000, 1]
    print(maxSubsequenceSum(nums))

    nums = [1, 1, 1, 1, 1]
    print(maxSubsequenceSum(nums))

    nums = [1, 2, 3, 4, 5, 6, 7, 8]
    print(maxSubsequenceSum(nums))
