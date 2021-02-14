/**
 * @author Anirudh Sharma
 * 
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * Constraints:
 * 
 * rows == matrix.length
 * cols == matrix.length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */
const maximalRectangle = (matrix) => {
    // Special cases
    if (matrix === undefined || matrix.length === 0) {
        return 0;
    }
    // Rows and columns of the matrix
    const rows = matrix.length;
    const columns = matrix[0].length;
    // Array to store every row
    const rowArray = Array(columns).fill(0);
    // Fill the row array with the first row of the matrix
    for (let i = 0; i < columns; i++) {
        rowArray[i] = parseInt(matrix[0][i]);
    }
    // Calculate the max area for this row
    let maxArea = largestRectangleInHistogram(rowArray);
    // Loop for every other row
    for (let i = 1; i < rows; i++) {
        // Again fill the row array
        for (let j = 0; j < columns; j++) {
            if (matrix[i][j] === '0') {
                rowArray[j] = 0;
            } else {
                rowArray[j] += parseInt(matrix[i][j]);
            }
        }
        maxArea = Math.max(maxArea, largestRectangleInHistogram(rowArray));
    }
    return maxArea;
};

const largestRectangleInHistogram = (heights) => {
    // Special cases
    if (heights === undefined || heights.length === 0) {
        return 0;
    }
    if (heights.length === 1) {
        return heights[0];
    }
    // Stack to store the index of elements whose value is
    // greater than the top of the stack
    const indices = [];
    // Maximum area of the histogram
    let maxArea = 0;
    // Index to iterate array
    let index = 0;
    // Loop through the copy array
    while (index <= heights.length) {
        if (indices.length === 0 || heights[indices[indices.length - 1]] <= heights[index]) {
            indices.push(index);
            index++;
        } else {
            // Height and width
            let height = heights[indices.pop()];
            let width = indices.length === 0 ? index : index - indices[indices.length - 1] - 1;
            maxArea = Math.max(maxArea, width * height);
        }
    }
    return maxArea;
};

const main = () => {
    let matrix = [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]
    console.log(maximalRectangle(matrix));

    matrix = [];
    console.log(maximalRectangle(matrix));

    matrix = [["0"]];
    console.log(maximalRectangle(matrix));

    matrix = [["1"]];
    console.log(maximalRectangle(matrix));

    matrix = [["1", "1"]];
    console.log(maximalRectangle(matrix));
};

main();