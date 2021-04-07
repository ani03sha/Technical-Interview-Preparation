"""
@author Anirudh Sharma
 
Given two strings A and B, the task is to convert A to B if possible.
The only operation allowed is to put any character from A and insert it at front.
 
Find if it’s possible to convert the string. If yes, then output minimum no. of operations
required for transformation.
"""


def minimumOperations(A, B):
    # Base checks for possible conversions
    if len(A) != len(B):
        return -1
    # Frequency map of characters in both strings
    frequencyMap = [0] * 256
    # Loop through both strings
    for i in range(len(A)):
        frequencyMap[ord(A[i])] += 1
        frequencyMap[ord(B[i])] -= 1
    # If frequency of any character is not zero,
    # then we know that conversion is not possible
    for num in frequencyMap:
        if num != 0:
            return -1
    # Count of operations needed
    count = 0
    # Variables to iterate through both strings
    indexA = len(A) - 1
    indexB = len(B) - 1
    # Loop from right to left
    while indexA >= 0:
        # If the characters don't match,
        # keep incrementing count
        if ord(A[indexA]) != ord(B[indexB]):
            count += 1
        else:
            indexB -= 1
        indexA -= 1
    return count


if __name__ == "__main__":
    A = "EACBD"
    B = "EABCD"
    print(minimumOperations(A, B))

    A = "ABD"
    B = "BAD"
    print(minimumOperations(A, B))
