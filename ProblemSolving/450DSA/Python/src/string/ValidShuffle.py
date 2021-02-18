"""
@author Anirudh Sharma

Check if a string is the valid shuffle of two other strings.
In order to be a valid shuffle, the order of string should be maintained.
"""


def checkIfValidShuffle(a, b, c):
    # Check if sum of lengths of a and b is equal to
    # the length of c.
    if len(a) + len(b) != len(c):
        return False
    # Pointers to iterate through different strings
    i, j, k = 0, 0, 0
    # Loop until k reaches the end of c
    while k < len(c):
        # Check if the character of a matches with
        # the character of c
        if i < len(a) and a[i] == c[k]:
            i += 1
        # Check if the character of b matches with
        # the character of c
        elif j < len(b) and b[j] == c[k]:
            j += 1
        # If none of the characters match
        else:
            return False
        k += 1
    # Check if there are remaining characters in a or b
    return i >= len(a) and j >= len(b)


if __name__ == "__main__":
    a, b = "XY", "12"
    c = "1XY2"
    print(checkIfValidShuffle(a, b, c))

    c = "Y12X"
    print(checkIfValidShuffle(a, b, c))
