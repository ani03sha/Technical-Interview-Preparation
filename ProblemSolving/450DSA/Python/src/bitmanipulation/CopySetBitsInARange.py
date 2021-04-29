"""
@author Anirudh Sharma

Given two numbers x and y, and a range [l, r] where 1 <= l, r <= 32.
The task is consider set bits of y in range [l, r] and set these bits in x also.
"""


def copy(x, y, l, r):
    # Base case
    if l < 1 or r > 32:
        return -1
    # Get the length of the mask
    maskLength = (1 << (r - l + 1)) - 1
    # Get the mask by shifting to the requested position
    # and "and" it with y
    mask = ((maskLength) << (l - 1)) & y
    x |= mask
    return x


if __name__ == "__main__":
    x, y, l, r = 10, 13, 2, 3
    print(copy(x, y, l, r))
