"""
@author Anirudh Sharma

Given N integers and K, find the minimum number of elements that should be removed,
such that Amax-Amin<=K. After the removal of elements, Amax and Amin is considered
among the remaining elements.
"""


def minimumElementsRemoved(nums, k):
    # Special cases
    if nums is None or len(nums) == 0:
        return 0
    # Length of the array
    n = len(nums)
    # Lookup table
    lookup = [-1] * n
    # Base initialization
    lookup[0] = 0
    # In worst case, all the elements need to be removed
    # except one element
    removedElements = n - 1
    # Populate the lookup table
    for i in range(1, n):
        lookup[i] = i
        j = lookup[i - 1]
        while j != i and nums[i] - nums[j] > k:
            j += 1
        lookup[i] = min(lookup[i], j)
        removedElements = min(removedElements, n - (i - j + 1))
    return removedElements


if __name__ == "__main__":
    nums = [1, 3, 4, 9, 10, 11, 12, 17, 20]
    k = 4
    print(minimumElementsRemoved(nums, k))
