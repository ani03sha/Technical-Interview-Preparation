"""
@author Anirudh Sharma
 
Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify
the height of each tower either by increasing or decreasing them by K only once.

After modifying, height should be a non-negative integer.

Find out what could be the possible minimum difference of the height of shortest and
longest towers after you have modified each tower.
"""


def getMinDiff(a, k):
    # Length of the array
    n = len(a)
    # Base condition
    if n <= 1:
        return 0
    # Sort the array
    a.sort()
    # Maximum difference
    maximumDifference = a[n - 1] - a[0]
    # Smallest height
    smallest = a[0] + k
    # Biggest height
    biggest = a[n - 1] - k
    if smallest > biggest:
        smallest, biggest = biggest, smallest
    # Loop for the remaining elements in the array
    for i in range (1, n - 1):
        # Value after adding k to the current value
        add = a[i] + k
        # Value after subtracting k from the current value
        subtract = a[i] - k
        if subtract >= smallest or add <= biggest:
            continue
        if biggest - subtract <= add - smallest:
            smallest = subtract
        else:
            biggest = add
    return min(maximumDifference, biggest - smallest)


if __name__ == "__main__":
    print(getMinDiff([1, 15, 10], 6))
    print(getMinDiff([1, 5, 15, 10], 3))
    print(getMinDiff([1, 5, 8, 10], 2))
    print(getMinDiff([3, 9, 12, 16, 20], 3))
    print(getMinDiff([6, 1, 9, 1, 1, 7, 9, 5, 2, 10], 4))
