"""
@author Anirudh Sharma

Given an array of positive integers. We need to make the given array a ‘Palindrome’.
The only allowed operation is"merging" (of two adjacent elements).
Merging two adjacent elements means replacing them with their sum.

The task is to find the minimum number of merge operations required to make the
given array a ‘Palindrome’.
"""


def minimumMergeOperations(nums):
    # Special cases
    if nums is None or len(nums) < 2:
        return 0
    # Count of merge operations
    mergeOperations = 0
    # Left and right pointers
    left, right = 0, len(nums) - 1
    # Loop until both pointers meet
    while left <= right:
        # If both elements are equal then we don't have
        # to do anything
        if nums[left] == nums[right]:
            left += 1
            right -= 1
        # If left element is smaller than right
        elif nums[left] < nums[right]:
            nums[left + 1] += nums[left]
            left += 1
            mergeOperations += 1
        # If right element is smaller than left
        elif nums[left] > nums[right]:
            nums[right - 1] += nums[right]
            right -= 1
            mergeOperations += 1
    return mergeOperations


if __name__ == "__main__":
    nums = [15, 4, 15]
    print(minimumMergeOperations(nums))

    nums = [1, 4, 5, 1]
    print(minimumMergeOperations(nums))

    nums = [11, 14, 15, 99]
    print(minimumMergeOperations(nums))
