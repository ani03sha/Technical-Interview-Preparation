/**
 * @author Anirudh Sharma
 * 
 * Given an m x n matrix, find all common elements present in all rows in O(mn)
 * time and one traversal of matrix.
 */
const findCommonElements = (matrix) => {
    // Rows and columns of the matrix
    const rows = matrix.length;
    const columns = matrix[0].length;
    // List to store the result
    const commonElements = [];
    // Map to store the element and their count in the
    // current row
    const countMap = new Map();
    // Process the first row
    for (let i = 0; i < columns; i++) {
        countMap.set(matrix[0][i], 1);
    }
    // Traverse the rest of the matrix
    for (let i = 1; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            // If the element is present in the map
            // but not duplicated in the current row
            if (countMap.get(matrix[i][j]) !== undefined && countMap.get(matrix[i][j]) === i) {
                // We increment the count of the element
                countMap.set(matrix[i][j], i + 1);
                // If this is the last row
                if (i === rows - 1) {
                    commonElements.push(matrix[i][j]);
                }
            }
        }
    }
    return commonElements;
};

const main = () => {
    let matrix = [[1, 2, 1, 4, 8], [3, 7, 8, 5, 1], [8, 7, 7, 3, 1], [8, 1, 2, 7, 9]];
    console.log(findCommonElements(matrix));
};

main();