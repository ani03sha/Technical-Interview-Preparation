"""
Given an array of size N and a range [a, b]. The task is to partition the array around the range
such that array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.

The individual elements of three sets can appear in any order. You are required to return the
modified array.
"""


def threeWayPartition(nums, a, b):
    # Left and right pointers
    left, right = 0, len(nums) - 1
    # Index to traverse the array
    i = 0
    # Loop for all the elements in the array
    while i <= right:
        # If the current element is less than a
        if nums[i] < a:
            nums[i], nums[left] = nums[left], nums[i]
            i += 1
            left += 1
        # If the current element is greater than b
        elif nums[i] > b:
            nums[i], nums[right] = nums[right], nums[i]
            right -= 1
        # If the current element is in the range a,b
        else:
            i += 1
    return nums


if __name__ == "__main__":
    nums = [1, 2, 3, 3, 4]
    a = 1
    b = 2
    print(threeWayPartition(nums, a, b))

    nums = [1, 2, 3]
    a = 1
    b = 3
    print(threeWayPartition(nums, a, b))

    nums = [87, 78, 16, 94]
    a = 36
    b = 72
    print(threeWayPartition(nums, a, b))
