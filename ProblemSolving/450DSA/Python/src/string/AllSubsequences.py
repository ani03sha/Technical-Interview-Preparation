"""
@author Anirudh Sharma

Given a string, we have to find out all subsequences of it. A String is a subsequence of a given String,
that is generated by deleting some character of a given string without changing its order.
"""


def findSubsequencesHelper(s, current, subsequences):
    # Special case
    if len(s) == 0:
        subsequences.append(current)
        return
    # Include first character
    findSubsequencesHelper(s[1:], current + s[0], subsequences)
    # Skip first character
    findSubsequencesHelper(s[1:], current, subsequences)


def findSubsequences(s):
    # List to store the result
    subsequences = []
    findSubsequencesHelper(s, "", subsequences)
    return subsequences


if __name__ == "__main__":
    print(findSubsequences("Hello"))
    print(findSubsequences("abcd"))