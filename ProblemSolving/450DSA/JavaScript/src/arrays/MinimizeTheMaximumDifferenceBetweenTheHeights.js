/**
 * @author Anirudh Sharma
 * 
 * Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify
 * the height of each tower either by increasing or decreasing them by K only once.
 * <p>
 * After modifying, height should be a non-negative integer.
 * <p>
 * Find out what could be the possible minimum difference of the height of shortest and
 * longest towers after you have modified each tower.
 */
const getMinDiff = (a, k) => {
    // Length of the array
    const n = a.length;
    // Base condition
    if (n <= 1) {
        return 0;
    }
    // Sort the array
    a.sort((x, y) => x - y);
    // Maximum difference
    const maximumDifference = a[n - 1] - a[0];
    // Biggest height
    let biggest = a[n - 1] - k;
    // Smallest height
    let smallest = a[0] + k;
    if (smallest > biggest) {
        let temp = smallest;
        smallest = biggest;
        biggest = temp;
    }
    // Loop for the remaining elements of the array
    for (let i = 1; i < n - 1; i++) {
        // Value after adding k to current value
        let add = a[i] + k;
        // Value after subtracting k from current value
        let subtract = a[i] - k;
        if (subtract >= smallest || add <= biggest) {
            continue;
        }
        if (biggest - subtract <= add - smallest) {
            smallest = subtract;
        } else {
            biggest = add;
        }
    }
    return Math.min(maximumDifference, biggest - smallest);
};

console.log(getMinDiff([1, 15, 10], 6));
console.log(getMinDiff([1, 5, 15, 10], 3));
console.log(getMinDiff([1, 5, 8, 10], 2));
console.log(getMinDiff([3, 9, 12, 16, 20], 3));
console.log(getMinDiff([6, 1, 9, 1, 1, 7, 9, 5, 2, 10], 4));