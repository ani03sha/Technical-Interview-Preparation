"""
@author Anirudh Sharma

Given an integer array nums, find the contiguous subarray within an array
(containing at least one number) which has the largest product.
"""


def maxProduct(nums):
    # Special cases
    if nums is None or len(nums) == 0:
        return -1
    # Overall maximum product
    globalMaxima = nums[0]
    # Maximum product until the current index
    localMaxima = nums[0]
    # Minimum product until the current index
    localMinima = nums[0]
    # Loop for the remaining elements
    for i in range(1, len(nums)):
        # Save localMaxima for localMinima calculation
        temp = localMaxima
        localMaxima = max(nums[i], max(localMaxima * nums[i], localMinima * nums[i]))
        localMinima = min(nums[i], min(temp * nums[i], localMinima * nums[i]))
        globalMaxima = max(localMaxima, globalMaxima)
    return globalMaxima


if __name__ == "__main__":
    print(maxProduct([2, 3, -2, 4]))
    print(maxProduct([-2, 0, -1]))
    print(maxProduct([6, -3, -10, 0, 2]))
    print(maxProduct([2, 3, 4, 5, -1, 0]))
