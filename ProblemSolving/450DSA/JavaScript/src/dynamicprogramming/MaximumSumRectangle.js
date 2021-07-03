/**
 * @author Anirudh Sharma
 * 
 * Given a 2D matrix, find the maximum sum subarray in it.
 */
const maximumSumRectangle = (matrix) => {
    // Special case
    if (matrix === undefined || matrix.length === 0) {
        return 0;
    }
    // Dimensions of the matrix
    const m = matrix.length;
    const n = matrix[0].length;
    // Store the prefix sum of each row
    const prefixSum = Array.from(Array(m), () => Array(n).fill(0));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            prefixSum[i][j] = matrix[i][j];
        }
    }
    for (let i = 0; i < m; i++) {
        for (let j = 1; j < n; j++) {
            prefixSum[i][j] += prefixSum[i][j - 1];
        }
    }
    // Start and end pointers of required rectangle
    let startRow = 0;
    let endRow = 0;
    let startColumn = 0;
    let endColumn = 0;
    // Maximum sum
    let maxSum = Number.MIN_VALUE;
    // Try for every column
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            // Stores the between two columns for
            // each row
            const temp = new Array(m).fill(0);
            for (let k = 0; k < m; k++) {
                temp[k] = prefixSum[k][j] - (i > 0 ? prefixSum[k][i - 1] : 0);
            }
            let currentSum = 0;
            let currentMaxSum = 0;
            let currentStartRow = 0;
            let currentEndRow = -1;
            let tempStartRow = 0;
            for (let k = 0; k < m; k++) {
                currentSum += temp[k];
                if (currentSum < 0) {
                    currentSum = 0;
                    tempStartRow = k + 1;
                } else if (currentSum > currentMaxSum) {
                    currentMaxSum = currentSum;
                    currentStartRow = tempStartRow;
                    currentEndRow = k;
                }
            }
            if (currentEndRow == -1) {
                currentMaxSum = temp[0];
                currentStartRow = 0;
                currentEndRow = 0;
                for (let k = 1; k < m; k++) {
                    if (temp[k] > currentMaxSum) {
                        currentStartRow = k;
                        currentEndRow = k;
                    }
                }
            }
            if (currentMaxSum > maxSum) {
                maxSum = currentMaxSum;
                startColumn = i;
                endColumn = j;
                startRow = currentStartRow;
                endRow = currentEndRow;
            }
        }
    }
    console.log("Maximum sum rectangle:");
    for (let i = startRow; i <= endRow; i++) {
        for (let j = startColumn; j <= endColumn; j++) {
            console.log(matrix[i][j] + " ");
        }
        console.log();
    }
    return maxSum;
};

const main = () => {
    let matrix = [
        [1, 2, -1, -4, -20],
        [-8, -3, 4, 2, 1],
        [3, 8, 10, 1, 3],
        [-4, -1, 1, 7, -6]
    ];
    console.log("Max sum: " + maximumSumRectangle(matrix) + "\n");

    matrix = [
        [-1, -2],
        [-3, -4]
    ];
    console.log("Max sum: " + maximumSumRectangle(matrix) + "\n");
};

main();