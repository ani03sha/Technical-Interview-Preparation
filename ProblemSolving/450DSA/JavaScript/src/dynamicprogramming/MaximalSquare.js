/**
 * @author Anirudh Sharma
 * 
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing
 * only 1's and return its area.
 * 
 * Constraints:
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 */
const maximalSquare = (matrix) => {
    // Special case
    if (matrix === undefined || matrix.length === 0) {
        return 0;
    }
    // Rows and columns of the matrix
    const m = matrix.length;
    const n = matrix[0].length;
    // Lookup table to store the size of the sub-matrix
    // of which current cell is the bottom right corner
    const lookup = Array.from(Array(m + 1), () => Array(n + 1).fill(0));
    // Variable to keep track of biggest square matrix seen so far
    let maxSize = 0;
    // Loop through the matrix and populate the lookup table
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            // If the current cell has 1, then we can consider
            // it as a valid case and try to make it as the part
            // of the valid sub matrix
            if (matrix[i - 1][j - 1] === '1') {
                lookup[i][j] = Math.min(lookup[i - 1][j], Math.min(lookup[i - 1][j - 1], lookup[i][j - 1])) + 1;
                maxSize = Math.max(maxSize, lookup[i][j]);
            }
        }
    }
    return maxSize * maxSize;
};

const main = () => {
    let matrix = [
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0']
    ];
    console.log(maximalSquare(matrix));

    matrix = [
        ['0', '1'],
        ['1', '0']
    ];
    console.log(maximalSquare(matrix));

    matrix = [
        ['0']
    ];
    console.log(maximalSquare(matrix));
};

main();