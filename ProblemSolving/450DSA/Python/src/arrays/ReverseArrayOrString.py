"""
@author Anirudh Sharma

Given an array (or string), the task is to reverse the array/string.
"""


def reverseArray(a):
    # Base condition
    if not a:
        return a
    # Left pointer (moves forward)
    # Right pointer (moves backward)
    left = 0
    right = len(a) - 1
    # Loop through the array until two pointers meet
    while left <= right:
        # Swap two left and right elements
        a[left], a[right] = a[right], a[left]
        # Update the pointers
        left += 1
        right -= 1
    return a


def reverseString(s):
    # Base condition
    if not s:
        return s
    # String to store the reversed value
    reversedString = ""
    for c in s:
        reversedString = c + reversedString
    return reversedString


if __name__ == '__main__':
    print(reverseArray([1, 2, 3]))
    print(reverseArray([4, 5, 1, 2]))
    print(reverseString("Anirudh"))
    print(reverseString("Problem Solving"))
