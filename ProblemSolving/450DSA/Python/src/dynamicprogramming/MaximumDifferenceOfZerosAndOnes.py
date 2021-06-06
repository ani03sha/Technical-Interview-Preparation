"""
@author Anirudh Sharma

Given a binary string of 0s and 1s. The task is to find the maximum difference of the number
of 0s and the number of 1s (number of 0s – number of 1s) in the substrings of a string.

Note: In the case of all 1s, the answer will be -1.
"""


def checkIfAllOnes(s):
    # Count of ones
    oneCount = 0
    for c in s:
        if c == '1':
            oneCount += 1
    return oneCount == len(s)


def findLength(nums, n, index, choice, lookup):
    # If we have reached the end of the string
    if index >= n:
        return 0
    # If we already have calculated the state
    if lookup[index][choice] != -1:
        return lookup[index][choice]
    if choice == 0:
        lookup[index][choice] = max(
            nums[index] + findLength(nums, n, index + 1, 1, lookup),
            findLength(nums, n, index + 1, 0, lookup))
        return lookup[index][choice]
    else:
        lookup[index][choice] = max(
            nums[index] + findLength(nums, n, index + 1, 1, lookup), 0)
        return lookup[index][choice]


def maxDifference(s):
    # Special cases
    if s is None or len(s) == 0 or checkIfAllOnes(s):
        return -1
    # Length of the string
    n = len(s)
    # Array containing the integer values
    nums = [0] * n
    # Fill this array = > -1 for '1' and 1 for '0'
    for i in range(n):
        nums[i] = 1 if s[i] == '0' else -1
    # Lookup table to store two cases
    # lookup[i][0] -> maxDifference up to i, if we skip i-th element
    # lookup[i][1] -> maxDifference up to i, if we consider i-th element
    lookup = [[-1 for y in range(2)] for x in range(n)]
    return findLength(nums, n, 0, 0, lookup)


if __name__ == "__main__":
    print(maxDifference("11000010001"))
    print(maxDifference("111111"))
