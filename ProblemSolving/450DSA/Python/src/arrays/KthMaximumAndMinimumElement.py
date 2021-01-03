"""
@author Anirudh Sharma

Given an array arr[] and a number K where K is smaller than size of
array, the task is to find the Kth smallest element in the given
array. It is given that all array elements are distinct.
"""


def partitionSmallest(nums, left, right):
    # Pivot element
    pivot = nums[right]
    # Index to determine the position of last element
    # that should occur before pivot
    i = left - 1
    # Loop through the array (until right - 1)
    for j in range(left, right):
        # If current element is less than or equal to the pivot
        # then swap
        if nums[j] <= pivot:
            i += 1
            nums[i], nums[j] = nums[j], nums[i]
    nums[i + 1], nums[right] = nums[right], nums[i + 1]
    return i + 1


def findKthSmallestHelper(nums, k, left, right):
    # Base condition
    if left == right:
        return nums[left]
    # Find the pivot index
    pivotIndex = partitionSmallest(nums, left, right)
    # Number of elements in the left of the array
    countLeft = pivotIndex - left + 1
    # Check for various cases
    # If the number of elements in left is equal to k
    # then pivot is the required element
    if countLeft == k:
        return nums[pivotIndex]
    # If number of elements in left is greater than k
    # then we need to move pivot to the left
    elif countLeft > k:
        return findKthSmallestHelper(nums, k, left, pivotIndex - 1)
    #  If the number of elements in left is less than k
    # then we need to move pivot to the right
    else:
        return findKthSmallestHelper(nums, k - pivotIndex + left - 1, pivotIndex + 1, right)


def findKthSmallest(nums, k):
    return findKthSmallestHelper(nums, k, 0, len(nums) - 1)


def partitionLargest(nums, left, right):
    # Choosing right most element as the pivot
    pivot = nums[right]
    # Index to determine the position of last element
    # that should occur before pivot
    i = left
    # Loop through the array(until right - 1)
    for j in range(left, right):
        # If current element is less than or equal to the pivot
        # then swap
        if nums[j] > pivot:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
    # Swap again
    nums[i], nums[right] = nums[right], nums[i]
    return i


def findKthLargestHelper(nums, k, left, right):
    # Base case i.e. there is single element
    if k < left or k > right:
        return -1
    # Find the pivot index
    pivotIndex = partitionLargest(nums, left, right)
    # Check for various cases
    # If the number of elements in left is equal to k
    # then pivot is the required element
    if pivotIndex == k:
        return nums[pivotIndex]
    # If number of elements in left is greater than k
    # then we need to move pivot to the left
    elif pivotIndex > k:
        return findKthLargestHelper(nums, k, left, pivotIndex - 1)
    #If the number of elements in left is less than k
    # then we need to move pivot to the right
    else:
        return findKthLargestHelper(nums, k, pivotIndex + 1, right)


def findKthLargest(nums, k):
    return findKthLargestHelper(nums, k - 1, 0, len(nums) - 1)


if __name__ == "__main__":
    print(findKthSmallest([7, 10, 4, 3, 20, 15], 3))
    print(findKthSmallest([7, 10, 4, 20, 15], 4))
    print(findKthLargest([7, 10, 4, 3, 20, 15], 3))
    print(findKthLargest([7, 10, 4, 20, 15], 1))
