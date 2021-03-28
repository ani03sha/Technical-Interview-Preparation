"""
@author Anirudh Sharma

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
"""


def dfs(board, i, j, currentIndex, word):
    # If the currentIndex is equal to the length of the
    # word, it means we have found the word
    if currentIndex == len(word):
        return True
    # If we are out of boundaries of the board or the
    # characters don't match
    if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[currentIndex]:
        return False
    # Get the current character from the board
    temp = board[i][j]
    # Make the current index in board as space
    # to mark it as visited
    board[i][j] = ' '
    # Check for all the words adjacent to the current
    # character in the board
    doesExist = dfs(board, i, j + 1, currentIndex + 1, word) or dfs(board, i, j - 1, currentIndex + 1,
                                                                    word) or dfs(board, i + 1, j, currentIndex + 1, word) or dfs(board, i - 1, j, currentIndex + 1, word)
    # Restore the value of current cell
    board[i][j] = temp
    return doesExist


def search(board, word):
    # Special cases
    if board is None or len(board) == 0:
        return False
    # Loop through every cell in the board
    for i in range(len(board)):
        for j in range(len(board[0])):
            # Check if the first letter and the remaining
            # letters in the words match
            if board[i][j] == word[0] and dfs(board, i, j, 0, word):
                return True
    return False


if __name__ == "__main__":
    board = [
        ['B', 'B', 'M', 'B', 'B', 'B'],
        ['C', 'B', 'A', 'B', 'B', 'B'],
        ['I', 'B', 'G', 'B', 'B', 'B'],
        ['G', 'B', 'I', 'B', 'B', 'B'],
        ['A', 'B', 'C', 'B', 'B', 'B'],
        ['M', 'C', 'I', 'G', 'A', 'M']
    ]
    word = "MAGIC"
    print(search(board, word))

    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    word = "ABCCED"
    print(search(board, word))

    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    word = "SEE"
    print(search(board, word))

    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    word = "ABCB"
    print(search(board, word))
