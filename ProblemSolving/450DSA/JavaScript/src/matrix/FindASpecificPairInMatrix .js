/**
 * @author Anirudh Sharma
 * 
 * Given an n x n matrix mat[n][n] of integers, find the maximum value of mat(c, d) – mat(a, b)
 * over all choices of indexes such that both c > a and d > b.
 */
const findMaxValue = (matrix) => {
    // Order of matrix
    const n = matrix.length;
    // Matrix to store maximum of elements from i,j to N-1,N-1
    const maxValues = Array.from(Array(n), () => new Array(n));
    // Fill the array
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            maxValues[i][j] = 0;
        }
    }
    // Last value in maxValues will be the last value in the
    // input matrix
    let maxValue = matrix[n - 1][n - 1];
    // Preprocess Last row
    let maxV = matrix[n - 1][n - 1];
    for (let i = n - 2; i >= 0; i--) {
        maxV = Math.max(matrix[n - 1][i], maxV);
        maxValues[n - 1][i] = maxV;
    }
    // Preprocess last column
    maxV = matrix[n - 1][n - 1];
    for (let i = n - 2; i >= 0; i--) {
        maxV = Math.max(maxV, matrix[i][n - 1]);
        maxValues[i][n - 1] = maxV;
    }
    // Preprocess rest of the matrix
    for (let i = n - 2; i >= 0; i--) {
        for (let j = n - 2; j >= 0; j--) {
            maxValue = Math.max(maxValue, maxValues[i + 1][j + 1] - matrix[i][j]);
            maxValues[i][j] = Math.max(matrix[i][j], Math.max(maxValues[i][j + 1], maxValues[i + 1][j]));
        }
    }
    return maxValue;
};

const main = () => {
    let matrix = [[1, 2, - 1, -4, -20], [-8, -3, 4, 2, 1], [ 3, 8, 6, 1, 3 ], [ -4, -1, 1, 7, -6 ], [ 0, -4, 10, -5, 1 ]];
    console.log(findMaxValue(matrix));
};

main();