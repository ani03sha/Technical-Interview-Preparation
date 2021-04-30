"""
@author Anirudh Sharma

Given an integer n, calculate the square of a number without using *, / and pow().
"""


def findSquare(n):
   # Special case
    if n == 0:
        return 0
   # For negative numbers
    if n < 0:
        n = -n
   # Get floor(n/2) using right shift
    x = n >> 1
   # Check for even and odd
    if n % 2 == 0:
        return (findSquare(x) << 2)
    else:
        return (findSquare(x) << 2) + (x << 2) + 1


if __name__ == "__main__":
    print(findSquare(5))
    print(findSquare(38))
    print(findSquare(-63))
