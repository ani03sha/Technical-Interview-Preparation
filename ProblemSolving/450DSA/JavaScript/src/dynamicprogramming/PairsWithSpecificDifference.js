/**
 * @author Anirudh Sharma
 * 
 * Given an array of integers arr[] and a number K.You can pair two numbers of the array
 * if the difference between them is strictly less than K.
 * 
 * The task is to find the maximum possible sum of such disjoint pairs.
 * The Sum of P pairs is the sum of all 2P numbers of pairs.
 */
const maxSumPairWithDifferenceLessThanK = (nums, K) => {
    // Special case
    if (nums === undefined || nums.length === 0) {
        return 0;
    }
    // Sort the array
    nums.sort((a, b) => a - b);
    // Lookup table maximum disjoin sum for first i elements
    const lookup = new Array(nums.length).fill(0);
    // Populate the table
    for (let i = 1; i < nums.length; i++) {
        lookup[i] = lookup[i - 1];
        if (nums[i] - nums[i - 1] < K) {
            if (i >= 2) {
                lookup[i] = Math.max(lookup[i], lookup[i - 2] + nums[i] + nums[i - 1]);
            } else {
                lookup[i] = Math.max(lookup[i], nums[i] + nums[i - 1]);
            }
        }
    }
    return lookup[nums.length - 1];
};

const main = () => {
    let nums = [3, 5, 10, 15, 17, 12, 9];
    let K = 4;
    console.log(maxSumPairWithDifferenceLessThanK(nums, K));

    nums = [5, 15, 10, 300];
    K = 12;
    console.log(maxSumPairWithDifferenceLessThanK(nums, K));
};

main();

