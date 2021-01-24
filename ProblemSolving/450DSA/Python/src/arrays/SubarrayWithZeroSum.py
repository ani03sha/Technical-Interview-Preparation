"""
@author Anirudh Sharma

Given an array of positive and negative numbers.
Find if there is a subarray (of size at-least one) with 0 sum.
"""


def doesZeroSumExist(A):
    # Set to store cumulative sum
    cumulativeSum = set()
    # Cumulative sum
    cSum = 0
    # Loop through all the elements in the array
    for i in range(len(A)):
        cSum += A[i]
        if A[i] == 0 or cSum == 0 or cSum in cumulativeSum:
            return True
        cumulativeSum.add(cSum)
    return False


if __name__ == "__main__":
    a = [4, 2, -3, 1, 6]
    print(doesZeroSumExist(a))

    a = [4, 2, 0, 1, 6]
    print(doesZeroSumExist(a))

    a = [4, 5, -4, -2, 1]
    print(doesZeroSumExist(a))
