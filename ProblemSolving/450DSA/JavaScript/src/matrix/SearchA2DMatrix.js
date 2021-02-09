/**
 * @author Anirudh Sharma
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * Constraints:
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */
const searchMatrix = (matrix, target) => {
    // Special case
    if (matrix === undefined || matrix.length === 0) {
        return false;
    }
    // Rows and columns of the matrix
    const rows = matrix.length;
    const columns = matrix[0].length;
    // Index for rows of the matrix
    let i = 0;
    // Loop row wise
    while (i < rows) {
        if (matrix[i][0] <= target && matrix[i][columns - 1] >= target) {
            // Perform binary search in the current row
            return binarySearch(matrix, i, columns, target);
        }
        i++;
    }
    return false;
};

const binarySearch = (matrix, row, column, target) => {
    // Start and end pointers
    let start = 0;
    let end = column - 1;
    // Loop until two pointers meet
    while (start <= end) {
        // Middle index
        let middle = start + parseInt((end - start) / 2);
        if (matrix[row][middle] === target) {
            return true;
        } else if (matrix[row][middle] < target) {
            start = middle + 1;
        } else {
            end = middle - 1;
        }
    }
    return false;
};


const main = () => {
    let matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]];
    let target = 3;
    console.log(searchMatrix(matrix, target));

    matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]];
    target = 13;
    console.log(searchMatrix(matrix, target));
};

main();
