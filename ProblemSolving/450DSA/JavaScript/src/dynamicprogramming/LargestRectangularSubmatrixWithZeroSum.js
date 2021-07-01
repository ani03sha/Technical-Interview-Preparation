/**
 * @author Anirudh Sharma
 *
 * Given a 2D matrix, find the largest rectangular sub-matrix whose sum is 0.
*/
const findMaximumSumZeroMatrix = (matrix) => {
    // Special case
    if (matrix === undefined || matrix.length === 0) {
        return;
    }
    // Order of matrix
    const m = matrix.length;
    const n = matrix[0].length;
    // Array to store the row prefix sum
    const prefixSum = Array.from(Array(m), () => Array(n).fill(0));
    // Base initialization
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            prefixSum[i][j] = matrix[i][j];
        }
    }
    // Calculate the prefix sum of each row
    for (let i = 0; i < m; i++) {
        for (let j = 1; j < n; j++) {
            prefixSum[i][j] += prefixSum[i][j - 1];
        }
    }
    // Variables for storing the starting and end
    // points of the largest zero sum sub matrix
    let startRow = 0;
    let endRow = 0;
    let startColumn = 0;
    let endColumn = 0;
    // Maximum size of the matrix
    let maxSize = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            // Stores sum between two columns for each row
            const temp = new Array(m).fill(0);
            for (let k = 0; k < m; k++) {
                temp[k] = prefixSum[k][j] - (i > 0 ? prefixSum[k][i - 1] : 0);
            }
            let currentSum = 0;
            // Map to store the row sum
            const rowSumMap = new Map();
            rowSumMap.set(0, -1);
            for (let k = 0; k < m; k++) {
                currentSum += temp[k];
                if (rowSumMap.has(currentSum)) {
                    let subMatrixSize = (j - i + 1) * (k - rowSumMap.get(currentSum));
                    if (subMatrixSize > maxSize) {
                        maxSize = subMatrixSize;
                        startColumn = i;
                        endColumn = j;
                        startRow = rowSumMap.get(currentSum) + 1;
                        endRow = k;
                    }
                } else {
                    rowSumMap.set(currentSum, k);
                }
            }
        }
    }
    for (let i = startRow; i <= endRow; i++) {
        for (let j = startColumn; j <= endColumn; j++) {
            console.log(matrix[i][j] + " ");
        }
        console.log();
    }
};

const main = () => {
    const matrix = [
        [9, 7, 16, 5],
        [1, -6, -7, 3],
        [1, 8, 7, 9],
        [7, -2, 0, 10]
    ];
    findMaximumSumZeroMatrix(matrix);
};

main();