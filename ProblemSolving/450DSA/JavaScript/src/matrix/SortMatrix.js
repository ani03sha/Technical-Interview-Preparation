/**
 * @author Anirudh Sharma
 *
 * Given an NxN matrix Mat. Sort all elements of the matrix.
 */
const sort = (matrix) => {
    // Special case
    if (matrix === undefined || matrix.length === 0) {
        return matrix;
    }
    // Rows and columns of the matrix
    const rows = matrix.length;
    const columns = matrix[0].length;
    // Elements of the matrix
    const elements = [];
    // Index of elements array
    let index = 0;
    // Store all the elements of the matrix in the array
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            elements[index] = matrix[i][j];
            index++;
        }
    }
    // Sort the elements array
    elements.sort((a, b) => a - b);
    // Reset the index
    index = 0;
    // Now store the elements in the matrix again
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            matrix[i][j] = elements[index];
            index++;
        }
    }
    return matrix;
};


const main = () => {
    let matrix = [[10, 20, 30, 40], [15, 25, 35, 45], [27, 29, 37, 48], [32, 33, 39, 50]];
    console.log(sort(matrix));

    matrix = [[1, 5, 3], [2, 8, 7], [4, 6, 9]];
    console.log(sort(matrix));
};

main();