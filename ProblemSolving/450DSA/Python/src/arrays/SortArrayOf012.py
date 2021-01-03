"""
@author Anirudh Sharma

Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Try to solve this problem in single pass with O(1) space
"""


def sort012(nums):
    # Start and end pointers
    start = 0
    end = len(nums) - 1
    # Index to point current element
    currentIndex = 0
    # Loop through until the pointers meet
    while currentIndex <= end and start < end:
        # Check if the current element is 0
        if nums[currentIndex] == 0:
            # Put whatever at the start at the current index
            nums[currentIndex] = nums[start]
            nums[start] = 0
            start += 1
            currentIndex += 1
        # Check if the current element is 2
        elif nums[currentIndex] == 2:
            nums[currentIndex] = nums[end]
            nums[end] = 2
            end -= 1
        # If the current element is 1
        else:
            currentIndex += 1
    return nums


if __name__ == "__main__":
    print(sort012([2, 0, 2, 1, 1, 0]))
    print(sort012([2, 0, 1]))
    print(sort012([1]))
    print(sort012([0]))