/**
 * @author Anirudh Sharma
 * 
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * Constraints:
 * 
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 */
const search = (board, word) => {
    // Special cases
    if (board === undefined || board.length === 0) {
        return false;
    }
    // Loop through every cell in the board
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            // Check if the first letter and the remaining
            // letters in the words match
            if (board[i][j] === word.charAt(0) && dfs(board, i, j, 0, word)) {
                return true;
            }
        }
    }
    return false;
};

const dfs = (board, i, j, currentIndex, word) => {
    // If the currentIndex is equal to the length of the
    // word, it means we have found the word
    if (currentIndex === word.length) {
        return true;
    }
    // If we are out of boundaries of the board or the
    // characters don't match
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] !== word.charAt(currentIndex)) {
        return false;
    }
    // Get the current character from the board
    let temp = board[i][j];
    // Make the current index in board as space
    // to mark it as visited
    board[i][j] = ' ';
    // Check for all the words adjacent to the current
    // character in the board
    let doesExist = dfs(board, i, j + 1, currentIndex + 1, word)
        || dfs(board, i, j - 1, currentIndex + 1, word)
        || dfs(board, i + 1, j, currentIndex + 1, word)
        || dfs(board, i - 1, j, currentIndex + 1, word);
    // Restore the value of current cell
    board[i][j] = temp;
    return doesExist;
};

const main = () => {
    let board = [
        ['B', 'B', 'M', 'B', 'B', 'B'],
        ['C', 'B', 'A', 'B', 'B', 'B'],
        ['I', 'B', 'G', 'B', 'B', 'B'],
        ['G', 'B', 'I', 'B', 'B', 'B'],
        ['A', 'B', 'C', 'B', 'B', 'B'],
        ['M', 'C', 'I', 'G', 'A', 'M']
    ];
    let word = "MAGIC";
    console.log(search(board, word));

    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ];
    word = "ABCCED";
    console.log(search(board, word));

    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ];
    word = "SEE";
    console.log(search(board, word));

    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ];
    word = "ABCB";
    console.log(search(board, word));
};

main();