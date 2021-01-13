"""
@author Anirudh Sharma

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
The number of elements initialized in nums1 and nums2 are m and n respectively.

You may assume that nums1 has enough space (size that is equal to m + n) to hold additional
elements from nums2.
"""


def merge(nums1, nums2):
    # Variable to store the length of the final sorted array
    index = len(nums1) - 1
    # Lengths of the individual arrays
    m = len(nums1) - len(nums2)
    n = len(nums2)
    # Decrement m and n by one to get the last index of
    # the respective arrays
    m -= 1
    n -= 1
    # Loop until there are elements left in one array
    while m >= 0 and n >= 0:
        # If nums1 has greater current element
        if nums1[m] > nums2[n]:
            nums1[index] = nums1[m]
            m -= 1
        else:
            nums1[index] = nums2[n]
            n -= 1
        index -= 1

    # Check if there are elements left in the second array
    while n >= 0:
        nums1[index] = nums2[n]
        n -= 1
        index -= 1
    return nums1


if __name__ == "__main__":
    nums1 = [1, 2, 3, 0, 0, 0]
    nums2 = [2, 5, 6]
    print(merge(nums1, nums2))

    nums1 = [1]
    nums2 = []
    print(merge(nums1, nums2))

    nums1 = [0, 0]
    nums2 = [1]
    print(merge(nums1, nums2))

    nums1 = [1, 3, 5, 7, 0, 0, 0, 0, 0]
    nums2 = [0, 2, 6, 8, 9]
    print(merge(nums1, nums2))
