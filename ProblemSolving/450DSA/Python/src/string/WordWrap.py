import sys

"""
@author Anirudh Sharma

Given a sequence of words, and a limit on the number of characters that can be put in one line
(line width).
Put line breaks in the given sequence such that the lines are printed neatly.
Assume that the length of each word is smaller than the line width.

The problem is to minimize the following total cost.
Cost of a line = (Number of extra spaces in the line)^2
Total Cost = Sum of costs for all lines
"""


def printSolution(p, n):
    if p[n] == 1:
        k = 1
    else:
        k = printSolution(p, p[n] - 1) + 1    
    print(str(p[n]) + " " + str(n), end=" ")
    return k


def wordWrap(words, lineWidth):
    # Infinite cost
    infinity = sys.maxsize
    # Words represent the length of different words
    # Total number of words
    n = len(words)
    # The below array represents the number of extra spaces
    # left in each line if words from i-th index to j-th index
    # are written i.e. extraSpaces[i][[j] represents the extra
    # spaces left when words[i] to words[j] are written in the
    # single line
    extraSpaces = [[0 for i in range(n + 1)] for i in range(n + 1)]
    # Below array represents the costs of lines which has words
    # from i to j
    cost = [[0 for i in range(n + 1)] for i in range(n + 1)]
    # Below array represents the optimal cost of first word to
    # the i-th word
    optimalCost = [0 for i in range(n + 1)]
    # Below array will be used to store the solution
    print = [0 for i in range(n + 1)]
    # Calculate extra spaces in each combination of words from
    # i to j
    for i in range(1, n + 1):
        # Space for the current word
        extraSpaces[i][i] = lineWidth - words[i - 1]
        # For the combination of other words
        for j in range(i + 1, n + 1):
            extraSpaces[i][j] = extraSpaces[i][j - 1] - words[j - 1] - 1
    # Now, we will calculate the cost for each line using the
    # cost function (extra spaces) ^ 3.
    # cost[i][j] means the cost of putting words from i to j
    # in a single line
    for i in range(1, n + 1):
        for j in range(i, n + 1):
            # If words take space more than lineWidth
            if extraSpaces[i][j] < 0:
                cost[i][j] = infinity
            # If we have used all the words i.e. the last line
            elif j == n and extraSpaces[i][j] >= 0:
                cost[i][j] = 0
            # Calculate the cost
            else:
                cost[i][j] = extraSpaces[i][j] * extraSpaces[i][j]
    # Now, we will attempt to optimize the cost
    # optimalCost[i] means optimized cost to arrange
    # words  from 1 to i
    optimalCost[0] = 0
    for i in range(1, n + 1):
        optimalCost[i] = infinity
        for j in range(1, i + 1):
            if optimalCost[j - 1] != infinity and cost[j][i] != infinity and optimalCost[j - 1] + cost[j][i] < optimalCost[i]:
                optimalCost[i] = optimalCost[j - 1] + cost[j][i]
                print[i] = j
    printSolution(print, n)


if __name__ == "__main__":
    words = [3, 2, 2, 5]
    lineWidth = 6
    wordWrap(words, lineWidth)

    print()

    words = [3, 2, 2]
    lineWidth = 4
    wordWrap(words, lineWidth)