"""
@author Anirudh Sharma

You are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of
all the elements in the subarray is less than k.

Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
"""


def numSubsequencesProductLessThanK(nums, k):
    # Special cases
    if nums is None or len(nums) == 0:
        return 0
    # Length of the array
    n = len(nums)
    # Lookup table to store the number of sequences
    # that are required after using first j terms to
    # make product less than i.
    lookup = [[0 for y in range(n + 1)] for x in range(k + 1)]
    # Populate the table for all sums
    for i in range(1, k + 1):
        for j in range(1, n + 1):
            # Number of sequences using j - 1 terms
            lookup[i][j] = lookup[i][j - 1]
            if nums[j - 1] <= i and nums[j - 1] > 0:
                # Number of subsequences using 1 to j - 1
                # terms and j-th term
                lookup[i][j] += lookup[i // nums[j - 1]][j - 1] + 1
    return lookup[k][n]


if __name__ == "__main__":
    nums = [1, 2, 3, 4]
    k = 10
    print(numSubsequencesProductLessThanK(nums, k))

    nums = [4, 8, 7, 2]
    k = 50
    print(numSubsequencesProductLessThanK(nums, k))
