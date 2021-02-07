/**
 * @author Anirudh Sharma
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * Constraints:
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
const spiralOrder = (matrix) => {
    // List for storing elements in spiral order
    const spiral = [];
    // Special case
    if (matrix === undefined || matrix.length === 0) {
        return spiral;
    }
    // Rows and columns of matrix
    const rows = matrix.length;
    const columns = matrix[0].length;
    // Variables to move left, right, top and bottom
    let left = 0;
    let right = columns - 1;
    let top = 0;
    let bottom = rows - 1;
    // Total number of elements in the matrix
    const numberOfElements = rows * columns;
    // Loop until the size of list is equal to number of
    // elements in the matrix
    while (spiral.length < numberOfElements) {
        // Move from left to right
        for (let i = left; i <= right && spiral.length < numberOfElements; i++) {
            spiral.push(matrix[top][i]);
        }
        top++;
        // Move from top to bottom
        for (let i = top; i <= bottom && spiral.length < numberOfElements; i++) {
            spiral.push(matrix[i][right]);
        }
        right--;
        // Move right to left
        for (let i = right; i >= left && spiral.length < numberOfElements; i--) {
            spiral.push(matrix[bottom][i]);
        }
        bottom--;
        // Move bottom to top
        for (let i = bottom; i >= top && spiral.length < numberOfElements; i--) {
            spiral.push(matrix[i][left]);
        }
        left++;
    }
    return spiral;
};


let grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
console.log(spiralOrder(grid));

grid = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]];
console.log(spiralOrder(grid));