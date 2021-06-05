/**
 * @author Anirudh Sharma
 * 
 * Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].
 * 
 * Matrix [r+1] [c]
 * Matrix [r+1] [c-1]
 * Matrix [r+1] [c+1]
 * 
 * Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
 */
const maximumPath = (matrix) => {
    // Special case
    if (matrix === undefined || matrix.length === 0) {
        return 0;
    }
    // Order of the matrix
    const N = matrix.length;
    // Start from the second last row and move upward
    for (let i = N - 2; i >= 0; i--) {
        for (let j = 0; j < N; j++) {
            // Current value
            let current = matrix[i][j];
            if (j > 0) {
                current = Math.max(current, matrix[i + 1][j - 1]);
            }
            if (j < N - 1) {
                current = Math.max(current, matrix[i + 1][j + 1]);
            }
            matrix[i][j] += current;
        }
    }
    // Maximum sum
    let maxSum = Number.MIN_VALUE;
    for (let i = 0; i < N; i++) {
        maxSum = Math.max(maxSum, matrix[0][i]);
    }
    return maxSum;
};

const main = () => {
    let matrix = [
        [348, 391],
        [618, 193]
    ];
    console.log(maximumPath(matrix));

    matrix = [
        [2, 2],
        [2, 2]
    ];
    console.log(maximumPath(matrix));
};

main();