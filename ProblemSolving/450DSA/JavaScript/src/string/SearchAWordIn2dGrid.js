/**
 * @author Anirudh Sharma
 * 
 * Given a 2D grid of characters and a word, find all occurrences of given word in grid.
 * A word can be matched in all 8 directions at any point.
 * 
 * Word is said be found in a direction if all characters match in this direction
 * (not in zig-zag form). The 8 directions are, horizontally left, horizontally right,
 * vertically up, vertically down and 4 diagonal directions.
 * 
 * Constraints:
 * 1 <= n <= m <= 100
 * 1 <= |word| <= 10
 */

// Coordinates for searching in all eight directions
const x = [-1, -1, -1, 0, 0, 1, 1, 1];
const y = [-1, 0, 1, -1, 1, -1, 0, 1];

const search = (grid, word) => {
    // List to store the results
    const result = [];
    // Loop through every cell of the grid
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (doesWordExist(grid, i, j, word)) {
                result.push([i, j]);
            }
        }
    }
    return result;
};

const doesWordExist = (grid, row, column, word) => {
    // Check if the current character in the
    // grid matches with the first character
    // in the word
    if (grid[row][column] !== word.charAt(0)) {
        return false;
    }
    // Check word in all eight directions
    for (let i = 0; i < 8; i++) {
        // Starting position for the current direction
        let rowDirection = row + x[i];
        let columnDirection = column + y[i];
        // Number of matched characters
        let matchedCount = 1;
        // Since first character is already checked,
        // we check for remaining characters
        for (let j = 1; j < word.length; j++) {
            // Check for out of bounds
            if (rowDirection < 0 || rowDirection >= grid.length || columnDirection < 0 || columnDirection >= grid[0].length) {
                break;
            }
            // If character don't match, break
            if (grid[rowDirection][columnDirection] !== word.charAt(j)) {
                break;
            }
            // Update the matched count
            matchedCount++;
            // Move in a particular direction
            rowDirection += x[i];
            columnDirection += y[i];
        }
        // Check if all the characters matched
        if (matchedCount === word.length) {
            return true;
        }
    }
    return false;
};

const main = () => {
    let grid = [
        ['a', 'b', 'c'],
        ['d', 'e', 'f'],
        ['g', 'h', 'i']
    ]
    let word = "abc"
    console.table(search(grid, word))

    grid = [
        ['a', 'b', 'a', 'b'],
        ['a', 'b', 'e', 'b'],
        ['e', 'b', 'e', 'b']
    ]
    word = "abe"
    console.table(search(grid, word))
};

main();