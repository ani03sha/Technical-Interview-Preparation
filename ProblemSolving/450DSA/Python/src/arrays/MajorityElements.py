"""
@author Anirudh Sharma

Given an array of size n, find all elements in array that appear more than n/k times.
"""


class Element:
    def __init__(self, value = 0, count = 0):
        self.value = value
        self.count = count


def findElements(nums, k):
    # Special cases
    if nums is None or len(nums) < 1: 
        return None
    if k < 2:
        return nums
    # List to store the final result
    result = []
    # Length of the array
    n = len(nums)
    # Create list of size k - 1 of type Element.
    # The number of elements in the output cannot be
    # more than k - 1
    elements = []
    # Fill the array and set count of every element 0
    for i in range(k - 1):
        elements.append(Element(0, 0))
    # Process all elements in the given array
    for num in nums:
        # If current element num is already
        # present in the array then increment
        # its count
        j = 0
        while j < k - 1:
            if num == elements[j].value:
                elements[j].count += 1
                break
            j += 1
        # If the current element is not present in the
        # elements array
        if j == k - 1:
            # If there is position available in elements
            # // then place nums[i] there and set its count
            # to 1.
            l = 0
            while l < k - 1:
                if elements[l].count == 0:
                    elements[l].value = num
                    elements[l].count = 1
                    break
                l += 1
            # If all the positions are filled,
            # then decrement the count of every
            # element by 1
            if l == k - 1:
                l = 0
                for l in range(k - 1):
                    elements[l].count -= 1
    # Check in elements for items which have count
    # more than n/k
    for i in range(k - 1):
        # Actual count of elements
        actualCount = 0
        for num in nums:
            if num == elements[i].value:
                actualCount += 1
        if actualCount > n // k:
            result.append(elements[i].value)
    return result


if __name__ == "__main__":
    nums = [4, 5, 6, 7, 8, 4, 4]
    k = 3
    print(findElements(nums, k))

    nums = [4, 2, 2, 7]
    k = 3
    print(findElements(nums, k))

    nums = [2, 7, 2]
    k = 2
    print(findElements(nums, k))

    nums = [2, 3, 3, 2]
    k = 3
    print(findElements(nums, k))
