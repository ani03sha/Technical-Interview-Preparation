"""
@author Anirudh Sharma

Given an array, cyclically rotate an array by one.
"""


def rotateArray(a):
    # Base condition
    if a == None or len(a) <= 1:
        return a
    # Save the last element of the array for future
    lastElement = a[len(a) - 1]
    # Index pointing at the end of the array
    i = len(a) - 2
    while i >= 0:
        a[i + 1] = a[i]
        i -= 1
    # Put last element at the start (0th index)
    a[0] = lastElement
    return a


if __name__ == "__main__":
    print(rotateArray([1, 2, 3, 4, 5]))
    print(rotateArray([1, 2]))
    print(rotateArray([1]))
    print(rotateArray([]))
