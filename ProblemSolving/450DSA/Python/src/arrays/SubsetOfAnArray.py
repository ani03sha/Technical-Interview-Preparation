"""
@author Anirudh Sharma

Given two arrays: arr1[0..m-1] of size m and arr2[0..n-1] of size n.
Task is to check whether arr2[] is a subset of arr1[] or not.
"""


def isSubset(arr1, arr2):
    # Lengths of two arrays
    m, n = len(arr1), len(arr2)
    # Base condition
    if m < n:
        return False
    # Sort both lists
    arr1.sort()
    arr2.sort()
    # Indices to traverse both lists
    i, j = 0, 0
    # Loop for both arrays until elements left
    while i < m and j < n:
        # If the current element of arr1 is less
        # than the current element of arr2, it means
        # we need to search further in arr1
        if arr1[i] < arr2[j]:
            i += 1
        # If both current elements are equal,
        # we will move forward in both arrays
        elif arr1[i] == arr2[j]:
            i += 1
            j += 1
        # If the current element in arr1 is greater
        # than the current element in arr2, it means
        # the current element in arr2 is not present
        # in arr1, so we will return false
        else:
            return False
    # After traversing the whole arrays, i cannot be
    # less than the number of elements in arr2.
    return i >= n


if __name__ == "__main__":
    arr1 = [11, 1, 13, 21, 3, 7]
    arr2 = [11, 3, 7, 1]
    print(isSubset(arr1, arr2))

    arr1 = [1, 2, 3, 4, 5]
    arr2 = [1, 2, 4]
    print(isSubset(arr1, arr2))

    arr1 = [10, 5, 2, 23, 19]
    arr2 = [19, 5, 3]
    print(isSubset(arr1, arr2))
