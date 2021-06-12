/**
 * @author Anirudh Sharma
 * 
 * Given an array containing n integers. The problem is to find the sum of the elements of the
 * contiguous subarray having the smallest(minimum) sum.
 */
const smallestSumSubarray = (a) => {
    // Global and local minimum
    let globalMin = Number.MAX_VALUE;
    let localMin = Number.MAX_VALUE;
    // Traverse through the array
    for (let element of a) {
        // If local min is positive, it cannot
        // contribute to the minimum sum
        if (localMin > 0) {
            localMin = element;
        } else {
            localMin += element;
        }
        // Update the minimum
        globalMin = Math.min(localMin, globalMin);
    }
    return globalMin;
};

const main = () => {
    let a = [3, -4, 2, -3, -1, 7, -5];
    console.log(smallestSumSubarray(a));
};

main();