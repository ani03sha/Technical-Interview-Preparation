"""
@author Anirudh Sharma

Given the mobile numeric keypad. You can only press buttons that are up, left, right, or down to
the current button.
You are not allowed to press bottom row corner buttons (i.e.and # ).
Given a number N, the task is to find out the number of possible numbers of the given length.
"""


def getCount(N):
    # Array to store the allowed keys which can
    # be pressed before a certain key
    allowedKeys = [
        [0, 8],
        [1, 2, 4],
        [1, 2, 3, 5],
        [2, 3, 6],
        [1, 4, 5, 7],
        [2, 4, 5, 6, 8],
        [3, 5, 6, 9],
        [4, 7, 8],
        [5, 7, 8, 9, 0],
        [6, 8, 9]
    ]
    # Lookup table to store the total number of
    # combinations where i represents the total
    # number of pressed keys and j represents the
    # actual keys present
    lookup = [[0 for y in range(10)] for x in range(N + 1)]
    # Populate the table
    for i in range(1, N + 1):
        for j in range(10):
            if i == 1:
                lookup[i][j] = 1
            else:
                # Loop for all the allowed previous keys
                for previous in allowedKeys[j]:
                    lookup[i][j] += lookup[i - 1][previous]
    # Total sum
    totalSum = 0
    for value in lookup[N]:
        totalSum += value
    return totalSum


if __name__ == "__main__":
    print(getCount(1))
    print(getCount(2))
    print(getCount(3))
    print(getCount(4))
    print(getCount(5))
    print(getCount(16))
