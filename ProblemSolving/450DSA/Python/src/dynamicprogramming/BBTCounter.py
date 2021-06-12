"""
@author Anirudh Sharma

Given a height h, count the maximum number of balanced binary trees possible with height h.
Print the result modulo 10^9 + 7.
"""


def countBT(h):
    MODULUS = 1000000007
    # Lookup table to store intermediate results
    lookup = [0] * (h + 1)
    # Base initialization
    lookup[0] = 1
    lookup[1] = 1
    # Populate the remaining table
    for i in range(2, h + 1):
        lookup[i] = (lookup[i - 1] * ((2 * lookup[i - 2]) %
                                      MODULUS + lookup[i - 1]) % MODULUS) % MODULUS
    return lookup[h]


if __name__ == "__main__":
    print(countBT(2))
    print(countBT(3))
