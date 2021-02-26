"""
@author Anirudh Sharma

Given a binary string str of length N, the task is to find the maximum count of substrings 's'
can be divided into such that all the substrings are balanced i.e. they have equal number of 0s and 1s.

If it is not possible to split str satisfying the conditions then print -1.
"""


def countOfBalancedSubstrings(s):
    # Count of ones and zeros in the string
    zeroCount, oneCount = 0, 0
    # Count of balanced substrings
    count = 0
    # Loop through the entire string
    for c in s:
        if c == '0':
            zeroCount += 1
        elif c == '1':
            oneCount += 1
        if zeroCount == oneCount:
            count += 1
    return count if zeroCount == oneCount else -1


if __name__ == "__main__":
    print(countOfBalancedSubstrings("0100110101"))
    print(countOfBalancedSubstrings("0111100010"))
