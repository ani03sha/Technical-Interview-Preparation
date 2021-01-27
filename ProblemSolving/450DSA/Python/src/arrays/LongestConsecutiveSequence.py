"""
@author Anirudh Sharma

Given an unsorted array of integers nums, return the length of the longest consecutive
elements sequence.

Constraints:
0 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9

Follow up: Could you implement the O(n) solution?
"""


def longestConsecutive(nums):
    # Special cases
    if nums is None or len(nums) == 0:
        return 0
    # Variable to store the longest consecutive sequence
    count = 0
    # Set to store the elements of the array
    uniqueElements = set()
    uniqueElements |= set(nums)
    # Loop again to find the sequences
    for num in nums:
        # Check if the previous number i.e., one smaller
        # is present in the set. If yes, then the current
        # element is a part of a sequence else it is the first
        # element in the sequence
        if num - 1 not in uniqueElements:
            # Get the current element
            n = num
            # Check if next elements are in the set
            while n in uniqueElements:
                n += 1
            # Update the maximum length
            count = max(count, n - num)
    return count


if __name__ == "__main__":
    arr = [100, 4, 200, 1, 3, 2]
    print(longestConsecutive(arr))

    arr = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
    print(longestConsecutive(arr))

    arr = [2, 6, 1, 9, 4, 5, 3]
    print(longestConsecutive(arr))

    arr = [1, 9, 3, 10, 4, 20, 2]
    print(longestConsecutive(arr))
