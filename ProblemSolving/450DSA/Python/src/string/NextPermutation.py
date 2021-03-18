"""
@author Anirudh Sharma

Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater
permutation of list of numbers.

If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted
in an ascending order. You are given an list of numbers arr[ ] of size N.

Constraints:
1 ≤ N ≤ 10000
"""


def reverse(nums, i, j):
    while i < j:
        nums[i], nums[j] = nums[j], nums[i]
        i += 1
        j -= 1


def nextPermutation(nums):
    # Length of the array
    n = len(nums)
    # Index of the first element that is smaller than
    # the element to its right.
    index = -1
    # Loop from right to left
    for i in range(n - 1, 0, -1):
        if nums[i] > nums[i - 1]:
            index = i - 1
            break
    # Base condition
    if index == -1:
        reverse(nums, 0, n - 1)
        return nums
    j = n - 1
    # Again swap from right to left to find first element
    # that is greater than the above find element
    for i in range(n - 1, index, -1):
        if nums[i] > nums[index]:
            j = i
            break
    # Swap the elements
    nums[index], nums[j] = nums[j], nums[index]
    # Reverse the elements from index + 1 to the nums.length
    reverse(nums, index + 1, n - 1)
    return nums


if __name__ == "__main__":
    nums = [1, 2, 3, 6, 5, 4]
    print(nextPermutation(nums))
