"""
@author Anirudh Sharma

Given a string s we need to tell minimum characters to be added at front of string to make string palindrome.
"""


def findLPS(pattern):
    lps = [0] * len(pattern)
    # Index for checking the pattern
    index = 0
    i = 1
    while i < len(pattern):
        if pattern[i] == pattern[index]:
            index += 1
            lps[i] = index
            i += 1
        else:
            if index != 0:
                index = lps[index - 1]
            else:
                lps[i] = 0
                i += 1
    return lps


def getCount(s):
    # Reversed string
    reversedString = s[::-1]
    # Add this reverse string to the original string with
    # a special character
    S = s + "$" + reversedString
    # Get the LPS array
    lps = findLPS(S)
    return len(s) - lps[len(S) - 1]


if __name__ == "__main__":
    print(getCount("AACECAAAA"))
    print(getCount("ABC"))
