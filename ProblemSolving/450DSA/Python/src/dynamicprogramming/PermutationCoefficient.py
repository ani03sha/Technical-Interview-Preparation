"""
 @author Anirudh Sharma
 
 Given two integers n and r, find nPr.
 Since the answer may be very large, calculate the answer modulo 10^9+7.
 
 Constraints:
 1 ≤ n ≤ 1000
 1 ≤ r ≤ 800
"""


def calculateCoefficientHelper(n, r, lookup):
    # Base case
    if n < r:
        return 0
    # If r is zero, or n is equal to r
    if r == 0:
        return 1
    # Get the memoized value
    if lookup[n][r] != -1:
        return lookup[n][r]
    lookup[n][r] = calculateCoefficientHelper(
        n - 1, r, lookup) + r * calculateCoefficientHelper(n - 1, r - 1, lookup)
    return lookup[n][r]


def calculateCoefficient(n, r):
    # Lookup table
    lookup = [[-1 for y in range(r + 1)] for x in range(n + 1)]
    # Fill the array with default values
    return calculateCoefficientHelper(n, r, lookup)


if __name__ == "__main__":
    n = 10
    r = 2
    print(calculateCoefficient(n, r))

    n = 10
    r = 3
    print(calculateCoefficient(n, r))

    n = 10
    r = 0
    print(calculateCoefficient(n, r))

    n = 10
    r = 1
    print(calculateCoefficient(n, r))
