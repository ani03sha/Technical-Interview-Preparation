/**
 * @author Anirudh Sharma
 * 
 * Given a row wise sorted matrix of size RxC where R and C are always odd,
 * find the median of the matrix.
 * 
 * Constraints:
 * 1<= R,C <=150
 * 1<= matrix[i][j] <=1000
 */
const findMedian = (matrix) => {
    // Rows and columns in the matrix
    const rows = matrix.length;
    const columns = matrix[0].length;
    // Special cases
    if (rows === 1 && columns === 1) {
        return matrix[rows - 1][columns - 1];
    }
    // Maximum and minimum elements in the matrix
    let minimumElement = Number.MAX_VALUE;
    let maximumElement = Number.MIN_VALUE;
    // Loop through all the rows
    matrix.forEach(row => {
        minimumElement = Math.min(minimumElement, row[0]);
        maximumElement = Math.max(maximumElement, row[columns - 1]);
    });
    // Since now we have a range of minimum and maximum elements
    // in the matrix, we would run binary search on this range to
    // find the number of elements which are less than our median
    // index (rows + columns + 1) / 2.
    // Desired median index
    const desiredIndex = parseInt((rows * columns + 1) / 2);
    while (minimumElement < maximumElement) {
        // Middle element
        let middleElement = minimumElement + parseInt((maximumElement - minimumElement) / 2);
        // Count of elements less than middleElement
        let count = 0;
        // Loop for each row
        matrix.forEach(row => {
            // Index of middle element in a row
            let middleElementIndex = binarySearch(row, middleElement);
            // If element is not found in the row
            if (middleElementIndex < 0) {
                middleElementIndex = Math.abs(middleElementIndex) - 1;
            } else {
                // If element is found in the array
                while (middleElementIndex < columns && row[middleElementIndex] === middleElement) {
                    middleElementIndex++;
                }
            }
            count += middleElementIndex;
        });
        if (count < desiredIndex) {
            minimumElement = middleElement + 1;
        } else {
            maximumElement = middleElement;
        }
    }
    return minimumElement;
};

const binarySearch = (arr, x) => {
    let start = 0;
    let end = arr.length - 1;
    // Loop until the two pointers meet
    while (start <= end) {
        // Find the mid index 
        let mid = start + parseInt((end - start) / 2);
        // If element is present at mid, return True 
        if (arr[mid] === x) {
            return mid;
        }
        // Else look in left or right half accordingly 
        else if (arr[mid] < x) {
            start = mid + 1;
        }
        else {
            end = mid - 1;
        }
    }
    return -(start + 1);
};

const main = () => {
    const matrix = [[1, 3, 5], [2, 6, 9], [3, 6, 9]];
    console.log(findMedian(matrix));
};

main();