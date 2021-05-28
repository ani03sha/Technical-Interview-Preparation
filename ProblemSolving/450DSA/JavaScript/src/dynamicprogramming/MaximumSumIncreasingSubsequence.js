/**
 * @author Anirudh Sharma
 * 
 * Given an array arr of N positive integers, the task is to find the maximum sum increasing
 * subsequence of the given array.
 */
const maximumSum = (nums) => {
    // Special case
    if (nums === undefined || nums.length === 0) {
        return 0;
    }
    // Length of the array
    const n = nums.length;
    // Lookup table to store the maximum sum until
    // a certain index
    const lookup = Array(n).fill(0);
    // Fill this table with the original array
    for (let i = 0; i < n; i++) {
        lookup[i] = nums[i];
    }
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                lookup[i] = Math.max(lookup[i], lookup[j] + nums[i]);
            }
        }
    }
    // Maximum value in the array
    let maximumValue = 0;
    for (let i = 0; i < n; i++) {
        maximumValue = Math.max(maximumValue, lookup[i]);
    }
    return maximumValue;
};

const main = () => {
    let nums = [1, 101, 2, 3, 100];
    console.log(maximumSum(nums));

    nums = [1, 2, 3];
    console.log(maximumSum(nums));
};

main();