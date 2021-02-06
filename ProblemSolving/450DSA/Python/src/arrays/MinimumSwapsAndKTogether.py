"""
@author Anirudh Sharma

Given an array of n positive integers and a number k.

Find the minimum number of swaps required to bring all the numbers less than or equal to k together.

Constraints:
1 ≤ N ≤ 10^5
1 ≤ nums[i], K ≤10^7
"""


def minimumSwaps(nums, k):
    # Special cases
    if nums is None or len(nums) < 2:
        return 0
    # Count of elements less than or equal to k
    lessThanOrEqualToK = 0
    for n in nums:
        if n <= k:
            lessThanOrEqualToK += 1
    # Count of elements greather than k in window
    # of size lessThanOrEqualToK
    greaterThanK = 0
    for i in range(0, lessThanOrEqualToK):
        if nums[i] > k:
            greaterThanK += 1
    # Minimum number if swaps required
    swaps = greaterThanK
    # Left and right pointers for sliding window
    left = 0
    right = lessThanOrEqualToK
    # Loop until right pointer reaches to the end of the array
    while right < len(nums):
        # Decrement count of previous window
        if nums[left] > k:
            greaterThanK -= 1
        # Increment count of current window
        if nums[right] > k:
            greaterThanK += 1
        # Minimize number of swaps required
        left += 1
        right += 1
        swaps = min(swaps, greaterThanK)
    return swaps


if __name__ == "__main__":
    nums = [2, 1, 5, 6, 3]
    k = 3
    print(minimumSwaps(nums, k))

    nums = [2, 7, 9, 5, 8, 7, 4]
    k = 6
    print(minimumSwaps(nums, k))
