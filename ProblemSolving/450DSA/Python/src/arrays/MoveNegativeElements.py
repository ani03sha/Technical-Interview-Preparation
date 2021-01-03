"""
@author Anirudh Sharma

An array contains both positive and negative numbers in random order. Rearrange the array elements so that all
negative numbers appear before all positive numbers.
"""


def moveNegatives(a):
    # Left and right pointers
    left = 0
    right = len(a) - 1
    # Loop through the array until two pointers meet
    while left <= right:
        # Case 1: both elements are negative
        if a[left] < 0 and a[right] < 0:
            left += 1
        # Case 2: If both elements are positive
        elif a[left] > 0 and a[right] > 0:
            right -= 1
        # Case 3: If left is positive and right is negative
        elif a[left] > 0 and a[right] < 0:
            # Swap
            a[left], a[right] = a[right], a[left]
            # Update the pointers
            left += 1
            right -= 1
        # Case 4: If left is negative and right is positive
        else:
            left += 1
            right -= 1
    return a


if __name__ == "__main__":
    print(moveNegatives([-1, 2, -3, 4, 5, 6, -7, 8, 9]))
    print(moveNegatives([-12, 11, -13, -5, 6, -7, 5, -3, 11]))
