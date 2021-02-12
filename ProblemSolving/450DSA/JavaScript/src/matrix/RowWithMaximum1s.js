/**
 * @author Anirudh Sharma
 * 
 * Given a boolean 2D array of n x m dimensions where each row is sorted.
 * Find the 0-based index of the first row that has the maximum number of 1's.
 * 
 * Constraints:
 * 1 ≤ N, M ≤ 10^3
 * 0 ≤ Arr[i][j] ≤ 1
 */
const rowWithMaximum1s = (matrix) => {
    // Index of rows with maximum 1s
    let rowWithMaximum1sIndex = -1;
    // Rows and columns of the matrix
    const rows = matrix.length;
    const columns = matrix[0].length;
    // Current column
    let currentColumn = columns - 1;
    // Loop for every row
    for (let i = 0; i < rows; i++) {
        // Start from top right corner of the matrix
        while (currentColumn >= 0 && matrix[i][currentColumn] == 1) {
            currentColumn--;
            rowWithMaximum1sIndex = i;
        }
    }
    return rowWithMaximum1sIndex;
};

const main = () => {
    let matrix = [[0, 1, 1, 1], [0, 0, 1, 1], [1, 1, 1, 1], [0, 0, 0, 0]];
    console.log(rowWithMaximum1s(matrix));

    matrix = [[0, 0], [1, 1]];
    console.log(rowWithMaximum1s(matrix));
};

main();