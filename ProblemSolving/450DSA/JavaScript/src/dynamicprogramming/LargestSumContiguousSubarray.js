/**
 * @author Anirudh Sharma
 * 
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 */
const maxSubarraySum = (a) => {
    // Length of the array
    const n = a.length;
    // Global maxima
    let globalMax = a[0];
    let localMax = a[0];
    // Loop through the elements of the list
    for (let i = 1; i < n; i++) {
        localMax = Math.max(a[i], a[i] + localMax);
        globalMax = Math.max(localMax, globalMax);
    }
    return globalMax;
};

const main = () => {
    let a = [1, 2, 3, -2, 5];
    console.log(maxSubarraySum(a));

    a = [-1, -2, -3, -4];
    console.log(maxSubarraySum(a));
};

main();