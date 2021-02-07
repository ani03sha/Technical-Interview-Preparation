"""
@author Anirudh Sharma

There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the
array obtained after merging the above 2 arrays(i.e. array of length 2n).

The complexity should be O(log(n)).
"""


def findMedian(a, b, n):
    # Special cases
    if n == 0:
        return -1
    if n == 1:
        return (a[0] + b[0]) // 2
    if n == 2:
        return (max(a[0], b[0]) + min(a[1], b[1])) // 2
    # Median of individual arrays
    ma = (a[n // 2] + a[n // 2 - 1]) // 2 if n % 2 == 0 else a[n // 2]
    mb = (b[n // 2] + b[n // 2 - 1]) // 2 if n % 2 == 0 else b[n // 2]
    # If both ma and mb are equal, return either of those
    if ma == mb:
        return ma
    # If ma is less than mb then the median lies in a[...ma] and b[mb...]
    if ma < mb:
        return findMedian(a[n // 2 - 1:], b, n - n // 2 + 1) if n % 2 == 0 else findMedian(a[n // 2:], b, n - n // 2)
    # If ma is greater than mb then median must lie in a[ma...] and b[...mb]
    return findMedian(b[n // 2 - 1:], a, n - n // 2 + 1) if n % 2 == 0 else findMedian(b[n // 2:], a, n - n // 2)


if __name__ == "__main__":
    a = [1, 2, 3, 6]
    b = [4, 6, 8, 10]
    print(findMedian(a, b, 4))

    a = [1, 2, 15, 26, 38]
    b = [2, 13, 17, 30, 45]
    print(findMedian(a, b, 5))
