"""
@author Anirudh Sharma

Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs
whereas the other two number occur exactly once and are distinct.

Find the other two numbers.
"""


def nonRepeating(A):
    # Set the first element as x
    x = A[0]
    # Loop through the array and find XOR
    for i in range(1, len(A)):
        x ^= A[i]
    # At this point x = a XOR b where
    # a and b are distinct numbers
    # Find the rightmost set bit of x
    rightmostSetBit = x & -x
    # Two distinct numbers
    a, b = 0, 0
    # Divide the elements into two groups
    for p in A:
        if (p & rightmostSetBit) != 0:
            a ^= p
        else:
            b ^= p
    return [a, b]


if __name__ == "__main__":
    A = [1, 2, 3, 2, 1, 4]
    print(nonRepeating(A))

    A = [2, 1, 3, 2]
    print(nonRepeating(A))
