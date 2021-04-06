"""
@author Anirudh Sharma

Given a string S delete the characters which are appearing more than once consecutively.

Constraints:
1<=|S|<=10^5
All characters are lowercase alphabets.
"""


def removeConsecutiveCharacters(S):
    # To store the final result
    s = ""
    # Loop through the string
    g = iter(range(len(S)))
    for i in g:
        s += S[i]
        while i + 1 < len(S) and S[i] == S[i + 1]:
            i = next(g)
    return s


if __name__ == "__main__":
    print(removeConsecutiveCharacters("aaab"))
    print(removeConsecutiveCharacters("aabaa"))
