import math as m

"""
@author Anirudh Sharma

Given a number N having only one ‘1’ and all other ’0’s in its binary representation,
find position of the only set bit.

If there are 0 or more than 1 set bit the answer should be -1.

Position of  set bit '1' should be counted starting with 1 from LSB side in binary
representation of the number.
"""


def findPosition(n):
    return m.log(n, 2) + 1 if (n & (n - 1)) == 0 else -1


if __name__ == "__main__":
    print(findPosition(2))
    print(findPosition(8))
    print(findPosition(5))
