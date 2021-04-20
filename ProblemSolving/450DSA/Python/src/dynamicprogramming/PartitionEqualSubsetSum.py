"""
@author Anirudh Sharma

Given a non-empty array nums containing only positive integers, find if the array can be
partitioned into two subsets such that the sum of elements in both subsets is equal.

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
"""


def isSubsetSum(nums, n, sum, lookup):
    # If subarray is found
    if sum == 0:
        return True
    # Base case
    if sum < 0 or n < 0:
        return False
    # Check in cache
    if lookup[n][sum] is not None:
        return lookup[n][sum]
    lookup[n][sum] = isSubsetSum(
        nums, n - 1, sum - nums[n], lookup) or isSubsetSum(nums, n - 1, sum, lookup)
    return lookup[n][sum]


def canPartition(nums):
    # Base case
    if nums is None or len(nums) == 0:
        return True
    # Calculate the sum of elements of the array
    totalSum = 0
    for n in nums:
        totalSum += n
    # Check if the sum is odd
    if totalSum % 2 == 1:
        return False
    # Lookup table
    lookup = [[None for y in range(totalSum + 1)]
              for x in range(len(nums) + 1)]
    # If the sum is even, then we will find a subarray
    # whose sum is equal to sum / 2
    return isSubsetSum(nums, len(nums) - 1, totalSum // 2, lookup)


if __name__ == "__main__":
    nums = [1, 5, 11, 5]
    print(canPartition(nums))

    nums = [1, 2, 3, 5]
    print(canPartition(nums))

    nums = [3, 1, 1, 2, 2, 1]
    print(canPartition(nums))

    nums = [100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97]
    print(canPartition(nums))
