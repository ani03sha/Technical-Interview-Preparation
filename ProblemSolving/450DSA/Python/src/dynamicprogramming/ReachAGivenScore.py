"""
@author Anirudh Sharma
 
Consider a game where a player can score 3 or 5 or 10 points in a move.
 Given a total score n, find number of distinct combinations to reach the given score.
"""


def countCombinations(n):
    # Create an array to store the possible score
    scores = [3, 5, 10]
    # Lookup table to store the intermediate results
    lookup = [0] * (n + 1)
    # Base initialization - 0 can be made with one combination
    # where we don't select anything
    lookup[0] = 1
    # Populate the remaining table
    for score in scores:
        for i in range(score, n + 1):
            lookup[i] += lookup[i - score]
    return lookup[n]


if __name__ == "__main__":
    print(countCombinations(8))
    print(countCombinations(20))
    print(countCombinations(13))
