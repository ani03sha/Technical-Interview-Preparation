"""
@author Anirudh Sharma

A sequence {x1, x2, .. xn} is alternating sequence if its elements satisfy one of the
following relations :
x1 < x2 > x3 < x4 > x5..... or  x1 >x2 < x3 > x4 < x5.....
Your task is to find the longest such sequence.
"""


def getSign(n):
    if n == 0:
        return 0
    else:
        return 1 if n > 0 else -1


def longestAlternatingSubsequence(nums):
    # Length of the longest wiggle subsequence
    longestWiggleSubsequence = 1
    # Sign of the difference of alternating numbers
    lastSign = 0
    # Loop from the second element to the end
    for i in range(1, len(nums)):
        currentSign = getSign(nums[i] - nums[i - 1])
        if currentSign != 0 and currentSign != lastSign:
            lastSign = currentSign
            longestWiggleSubsequence += 1
    return longestWiggleSubsequence


if __name__ == "__main__":
    nums = [1, 5, 4]
    print(longestAlternatingSubsequence(nums))

    nums = [1, 17, 5, 10, 13, 15, 10, 5, 16, 8]
    print(longestAlternatingSubsequence(nums))
