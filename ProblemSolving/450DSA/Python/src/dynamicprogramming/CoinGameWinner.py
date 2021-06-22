"""
@author Anirudh Sharma
A and B are playing a game. At the beginning there are n coins. Given two more numbers x and y.
In each move a player can pick x or y or 1 coins. A always starts the game.
The player who picks the last coin wins the game or the person who is not able to pick any
coin loses the game.
For a given value of n, find whether A will win the game or not if both are playing optimally.
"""


def findWinner(x, y, n):
    # Lookup table to store the results for different
    # values of n
    lookup = [False] * (n + 1)
    # Initial values
    # A cannot pick up any coin
    lookup[0] = False
    # A can pick up the one and only coin
    lookup[1] = True
    # Populate the remaining values
    for i in range(2, n + 1):
        # If A loses any of i - 1 or i - x or i - y game,
        # then it will definitely win game i
        if i - 1 >= 0 and not lookup[i - 1]:
            lookup[i] = True
        elif i - x >= 0 and not lookup[i - x]:
            lookup[i - x] = True
        elif i - y >= 0 and not lookup[i - y]:
            lookup[i - y] = True
    return lookup[n]


if __name__ == "__main__":
    n = 5
    x = 3
    y = 4
    print(findWinner(x, y, n))

    n = 2
    x = 3
    y = 4
    print(findWinner(x, y, n))
