package org.redquark.techinterview.dsa.string;

public class SearchAWordIn2DMatrix {

    private static boolean search(char[][] board, String word) {
        // Special cases
        if (board == null || board.length == 0) {
            return false;
        }
        // Loop through every cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Check if the first letter and the remaining
                // letters in the words match
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int currentIndex, String word) {
        // If the currentIndex is equal to the length of the
        // word, it means we have found the word
        if (currentIndex == word.length()) {
            return true;
        }
        // If we are out of boundaries of the board or the
        // characters don't match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(currentIndex)) {
            return false;
        }
        // Get the current character from the board
        char temp = board[i][j];
        // Make the current index in board as space
        // to mark it as visited
        board[i][j] = ' ';
        // Check for all the words adjacent to the current
        // character in the board
        boolean doesExist = dfs(board, i, j + 1, currentIndex + 1, word)
                || dfs(board, i, j - 1, currentIndex + 1, word)
                || dfs(board, i + 1, j, currentIndex + 1, word)
                || dfs(board, i - 1, j, currentIndex + 1, word);
        // Restore the value of current cell
        board[i][j] = temp;
        return doesExist;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'B', 'B', 'M', 'B', 'B', 'B'},
                {'C', 'B', 'A', 'B', 'B', 'B'},
                {'I', 'B', 'G', 'B', 'B', 'B'},
                {'G', 'B', 'I', 'B', 'B', 'B'},
                {'A', 'B', 'C', 'B', 'B', 'B'},
                {'M', 'C', 'I', 'G', 'A', 'M'}
        };
        String word = "MAGIC";
        System.out.println(search(board, word));

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "ABCCED";
        System.out.println(search(board, word));

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "SEE";
        System.out.println(search(board, word));

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "ABCB";
        System.out.println(search(board, word));
    }
}
