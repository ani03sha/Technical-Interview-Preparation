"""
@author Anirudh Sharma

Given an array of positive and negative numbers, arrange them in an alternate fashion such that
every positive number is followed by negative and vice-versa maintaining the order of appearance.

Number of positive and negative numbers need not be equal. If there are more positive numbers
they appear at the end of the array. If there are more negative numbers, they too appear in the
end of the array.

The space complexity should be O(1)
"""


def isAtCorrectPosition(a, index):
    if index % 2 == 0:
        return a[index] > 0
    else:
        return a[index] < 0


def getNextElementOfOppositeSign(a, index):
    for i in range(index + 1, len(a)):
        if a[i] * a[index] < 0:
            return i
    return -1


def rightRotateSubarray(a, left, right):
    lastSubarrayElement = a[right]
    for i in range(right, left, -1):
        a[i] = a[i - 1]
    a[left] = lastSubarrayElement


def rearrange(a):
    # Special cases
    if a is None or len(a) <= 1:
        return a
    # Loop for all the elements in the array
    for i in range(0, len(a)):
        # Check if the elements is at its correct
        # position or not.
        # Negative element should be at even index
        # and positive element should be at odd index
        if isAtCorrectPosition(a, i):
            # Get the index of next element of opposite sign
            nextOppositeElementIndex = getNextElementOfOppositeSign(a, i)
            if nextOppositeElementIndex != -1:
                rightRotateSubarray(a, i, nextOppositeElementIndex)
    return a


if __name__ == "__main__":
    arr = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
    print(rearrange(arr))

    arr = [-1, 3, 2, 4, 5, -6, 7, -9]
    print(rearrange(arr))
