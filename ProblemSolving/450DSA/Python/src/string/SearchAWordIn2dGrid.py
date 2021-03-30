"""
/**
@author Anirudh Sharma

Given a 2D grid of characters and a word, find all occurrences of given word in grid.
A word can be matched in all 8 directions at any point.

Word is said be found in a direction if all characters match in this direction
(not in zig-zag form). The 8 directions are, horizontally left, horizontally right,
vertically up, vertically down and 4 diagonal directions.

Constraints:
1 <= n <= m <= 100
1 <= |word| <= 10
"""

# Coordinates for searching in all eight directions
x = [-1, -1, -1, 0, 0, 1, 1, 1]
y = [-1, 0, 1, -1, 1, -1, 0, 1]


def doesWordExist(grid, row, column, word):
    # Check if the current character in the
    # grid matches with the first character
    # in the word
    if grid[row][column] != word[0]:
        return False
    # Check word in all eight directions
    for i in range(8):
        # Starting position for the current direction
        rowDirection = row + x[i]
        columnDirection = column + y[i]
        # number of matched characters
        matchedCount = 1
        # Since first character is already checked,
        # we check for remaining characters
        for j in range(1, len(word)):
            # Check for out of bounds
            if rowDirection < 0 or rowDirection >= len(grid) or columnDirection < 0 or columnDirection >= len(grid[0]):
                break
            # If the characters don't match
            if grid[rowDirection][columnDirection] != word[j]:
                break
            # Updated matched count
            matchedCount += 1
            # Move in a particular direction
            rowDirection += x[i]
            columnDirection += y[i]
        # Check if all the characters match
        if matchedCount == len(word):
            return True
    return False


def search(grid, word):
    # List to store the result
    result = []
    # Loop through every cell of the grid
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if doesWordExist(grid, i, j, word):
                result.append([i, j])

    return result


if __name__ == "__main__":
    grid = [
        ['a', 'b', 'c'],
        ['d', 'e', 'f'],
        ['g', 'h', 'i']
    ]
    word = "abc"
    print(search(grid, word))

    grid = [
        ['a', 'b', 'a', 'b'],
        ['a', 'b', 'e', 'b'],
        ['e', 'b', 'e', 'b']
    ]
    word = "abe"
    print(search(grid, word))
