"""
@author Anirudh Sharma

Given an array of integers. Find the Inversion Count in the array.

Inversion Count: For an array, inversion count indicates how far (or close) the array
is from being sorted. If array is already sorted then the inversion count is 0.

If an array is sorted in the reverse order then the inversion count is the maximum.

Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
"""


def merge(a, auxiliary, low, middle, high):
    # Index for left subarray
    i = low
    # Index for right subarray
    j = middle + 1
    # Index for auxiliary array
    k = low
    # Inversion count
    count = 0
    # Loop until there are elements in left and
    # right subarray
    while i <= middle and j <= high:
        if a[i] <= a[j]:
            auxiliary[k] = a[i]
            i += 1
        else:
            auxiliary[k] = a[j]
            j += 1
            count += (middle - i + 1)
        k += 1
    # For remaining elements in the left subarray
    while i <= middle:
        auxiliary[k] = a[i]
        i += 1
        k += 1
    # For remaining elements in the right subarray
    while j <= high:
        auxiliary[k] = a[j]
        j += 1
        k += 1
    # Copy the elements of auxiliary into the
    # original array
    for l in range(low, high + 1):
        a[l] = auxiliary[l]
    return count


def mergeSortAndCount(a, auxiliary, low, high):
    # Count of inversions
    count = 0
    # For valid indices
    if low < high:
        # Middle of the array
        middle = low + (high - low) // 2
        # Left subarray count
        count += mergeSortAndCount(a, auxiliary, low, middle)
        # Right subarray count
        count += mergeSortAndCount(a, auxiliary, middle + 1, high)
        # Merge count
        count += merge(a, auxiliary, low, middle, high)
    return count


def inversionCount(a):
    auxiliary = [0] * len(a)
    return mergeSortAndCount(a, auxiliary, 0, len(a) - 1)


if __name__ == "__main__":
    print(inversionCount([2, 4, 1, 3, 5]))
    print(inversionCount([2, 3, 4, 5, 6]))
    print(inversionCount([10, 10, 10]))
    print(inversionCount([4, 3, 2, 1]))
