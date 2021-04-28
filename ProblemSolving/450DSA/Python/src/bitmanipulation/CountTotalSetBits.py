"""
@author Anirudh Sharma

You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
"""


def totalSetBits(N):
    # compensate for zero
    N += 1
    # To store the powers of two
    powerOfTwo = 2
    # Total set bits
    setBits = N // 2
    # Loop until powerOfTwo exceeds N
    while powerOfTwo <= N:
        # Total pairs of 0s and 1s
        pairs = N // powerOfTwo
        # Get only pairs of 1s and multiply it with powerOfTwo
        setBits += powerOfTwo * (pairs // 2)
        # If pairs were odd
        setBits += N % powerOfTwo if (pairs % 2 == 1) else 0
        # Next power of two
        powerOfTwo <<= 1
    return setBits


if __name__ == "__main__":
    print(totalSetBits(2))
    print(totalSetBits(14))
