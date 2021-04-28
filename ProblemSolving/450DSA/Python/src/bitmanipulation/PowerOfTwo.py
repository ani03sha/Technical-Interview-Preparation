"""
@author Anirudh Sharma

Given a non-negative integer N. The task is to check if N is a power of 2.
More formally, check if N can be expressed as 2^x for some x.
"""


def isPowerOfTwo(n):
    if n <= 0:
        return False
    return (n & (n - 1)) == 0


if __name__ == "__main__":
    print(isPowerOfTwo(2097152))
    print(isPowerOfTwo(8336))
    print(isPowerOfTwo(1))
    print(isPowerOfTwo(0))
