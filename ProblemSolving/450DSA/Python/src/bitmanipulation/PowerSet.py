"""
@author Anirudh Sharma

Given a string s find all possible subsequences of the string in lexicographically-sorted order
"""


def getSubsequences(s, index, n):
    subsequence = ""
    for i in range(n):
        # Check if i-th bit in index is 1
        if ((index & (1 << i)) != 0):
            subsequence += s[i]
    return subsequence


def findSubsequences(s):
    # List to store result
    result = []
    # Map to store string lexicographically
    sortedSubsequences = {}
    # Length of the string
    n = len(s)
    # Total number of non-empty substrings
    limit = 2 ** n
    # Loop for every combination
    for i in range(1, limit):
        # Current subsequence
        subsequence = getSubsequences(s, i, n)
        # Storing in the map by length
        if len(subsequence) in sortedSubsequences.keys():
            sortedSubsequences[len(subsequence)] = tuple(
                list(sortedSubsequences[len(subsequence)]) + [subsequence])
        else:
            sortedSubsequences[len(subsequence)] = [subsequence]
    # Populate the resultant list
    for key in sortedSubsequences:
        for k in sorted(list(sortedSubsequences[key])):
            result.append(k)
    result.sort()
    return result


if __name__ == "__main__":
    print(findSubsequences("abc"))
    print(findSubsequences("axz"))
