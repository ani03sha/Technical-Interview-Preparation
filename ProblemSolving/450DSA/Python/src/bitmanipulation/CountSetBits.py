"""
@author Anirudh Sharma

Given a positive integer N, print count of set bits in it.
"""


def countSetBits(N):
    # Count of set bits
    count = 0
    # Loop until N becomes zero
    while N > 0:
        N &= (N - 1)
        count += 1
    return count


if __name__ == "__main__":
    print(countSetBits(6))
    print(countSetBits(31))
    print(countSetBits(13))
    print(countSetBits(40))
