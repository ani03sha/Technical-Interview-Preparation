"""
@author Anirudh Sharma

Given an array of N integers, and an integer K,
find the number of pairs of elements in the array whose sum is equal to K.

Constraints:
1 <= N <= 10^5
1 <= K <= 10^8
1 <= a[i] <= 10^6
"""


def getPairsCount(a, K):
    # Count of pairs
    count = 0
    # Dictionary to store frequencies of array elements
    frequencies = {}
    # Loop for elements in the array
    for i in a:
        if i in frequencies:
            frequencies[i] += 1
        else:
            frequencies[i] = 1
    # Traverse the array again to find the pairs
    for i in a:
        if (K - i) in frequencies:
            count += frequencies[K - i]
        # Check for same elements
        if K - i == i:
            count -= 1
    return count // 2


if __name__ == "__main__":
    print(getPairsCount([1, 5, 7, 1], 6))
    print(getPairsCount([1, 1, 1, 1], 2))
