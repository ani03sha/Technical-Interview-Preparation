/**
 * @author Anirudh Sharma
 * 
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * 
 * Constraints:
 * 
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
const rotate = (matrix) => {
    // Special cases
    if (matrix == null || matrix.length == 0) {
        return matrix;
    }
    // Order of the matrix
    const N = matrix.length;
    // Traverse the matrix
    for (let i = 0; i < N / 2; i++) {
        for (let j = i; j < N - i - 1; j++) {
            // SWap elements of each cycle in clockwise order
            let temp = matrix[i][j];
            matrix[i][j] = matrix[N - 1 - j][i];
            matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
            matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
            matrix[j][N - 1 - i] = temp;
        }
        return matrix
    }
};

const main = () => {
    let matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    console.table(rotate(matrix));

    matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]];
    console.table(rotate(matrix));
};

main();