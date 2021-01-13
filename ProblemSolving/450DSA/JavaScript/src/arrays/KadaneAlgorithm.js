/**
 * @author Anirudh Sharma
 * 
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 */
const maxSumArraySubarray = (a) => {
    if (a === undefined || a.length === 0) {
        return 0;
    }
    // Global maxima
    let globalMax = a[0];
    let localMax = a[0];
    // Loop through the elements of the list
    for (let i = 1; i < a.length; i++) {
        localMax = Math.max(a[i], a[i] + localMax);
        globalMax = Math.max(localMax, globalMax);
    }
    return globalMax;
};

console.log(maxSumArraySubarray([1, 2, 3, -2, 5]));
console.log(maxSumArraySubarray([-1, -2, -3, -4]));
console.log(maxSumArraySubarray([-2, 1, -3, 4, -1, 2, 1, -5, 4]));
console.log(maxSumArraySubarray([1]));
console.log(maxSumArraySubarray([0]));
console.log(maxSumArraySubarray([-1]));