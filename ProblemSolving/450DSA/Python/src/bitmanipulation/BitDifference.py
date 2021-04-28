"""
@author Anirudh Sharma

You are given two numbers A and B.
The task is to count the number of bits needed to be flipped to convert A to B.

Constraints:
1 ≤ A, B ≤ 10^6
"""


def countBits(A, B):
    # Variable to store count of bits
    count = 0
    # XOR of A and B
    C = A ^ B
    # Loop until C becomes empty
    while C != 0:
        count += 1
        C &= (C - 1)
    return count


if __name__ == "__main__":
    print(countBits(10, 20))
    print(countBits(20, 25))