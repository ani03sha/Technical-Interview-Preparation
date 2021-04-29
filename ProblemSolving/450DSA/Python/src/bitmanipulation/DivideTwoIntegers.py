"""
@author Anirudh Sharma

Given a two integers say a and b, find the quotient after dividing a by b without
using multiplication, division and mod operator.
"""


def divide(a, b):
    # Sign of the quotient
    sign = -1 if (a < 0) ^ (b < 0) else 1
    # Get the absolute values
    a = abs(a)
    b = abs(b)
    # Quotient
    quotient = 0
    total = 0
    for i in range(31, -1, -1):
        if total + (b << i) <= a:
            # Update the current sum
            total += (b << i)
            # Update the quotient
            quotient |= (1 << i)
    return quotient * sign


if __name__ == "__main__":
    print(divide(10, 3))
    print(divide(-43, 8))
