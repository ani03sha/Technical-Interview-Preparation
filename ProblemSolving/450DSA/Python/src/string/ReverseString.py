"""
@author Anirudh Sharma

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input
array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
"""


def reverse(s):
    left = 0
    right = len(s) - 1
    # Loop until the two pointers meet
    while left <= right:
        # swap left and right characters
        s[left], s[right] = s[right], s[left]
        # Update the pointers
        left += 1
        right -= 1
    return ''.join(s)


if __name__ == "__main__":
    s = ["h", "e", "l", "l", "o"]
    print(reverse(s))

    s = ["H", "a", "n", "n", "a", "h"]
    print(reverse(s))
