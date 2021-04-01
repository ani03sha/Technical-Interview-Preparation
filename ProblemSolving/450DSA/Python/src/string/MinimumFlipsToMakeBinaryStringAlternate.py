"""
@author Anirudh Sharma

Given a binary string, that is it contains only 0s and 1s. We need to make this string a
sequence of alternate characters by flipping some of the bits, our goal is to minimize
the number of bits to be flipped.

Constraints:
1<=|S|<=10^5
"""


def getFlips(s, expected):
    # Count of flips to make
    flips = 0
    # Loop through the entire string
    for i in range(len(s)):
        # If the character is not expected,
        # increment the flips
        if s[i] != expected:
            flips += 1
        # Update the expected character
        expected = '1' if expected == '0' else '0'
    return flips


def minimumFlips(s):
    return min(getFlips(s, '0'), getFlips(s, '1'))


if __name__ == "__main__":
    s = "001"
    print(minimumFlips(s))

    s = "0001010111"
    print(minimumFlips(s))
