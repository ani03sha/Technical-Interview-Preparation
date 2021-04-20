/**
 * @author Anirudh Sharma
 * 
 * Given a non-empty array nums containing only positive integers, find if the array can be
 * partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
const canPartition = (nums) => {
    // Base case
    if (nums === undefined || nums.length === 0) {
        return true;
    }
    // Calculate the sum of elements of the array
    let sum = 0;
    for (let n of nums) {
        sum += n;
    }
    // Check if the sum is odd
    if (sum % 2 === 1) {
        return false;
    }
    // Lookup table
    const lookup = Array.from(Array(nums.length + 1), () => Array(sum  + 1));
    // If the sum is even, then we will find a subarray
    // whose sum is equal to sum / 2
    return isSubsetSum(nums, nums.length - 1, sum / 2, lookup);
};

const isSubsetSum = (nums, n, sum, lookup) => {
    // If subarray is found
    if (sum === 0) {
        return true;
    }
    // Base case
    if (sum < 0 || n < 0) {
        return false;
    }
    // Check in cache
    if (lookup[n][sum] !== undefined) {
        return lookup[n][sum];
    }
    return lookup[n][sum] = isSubsetSum(nums, n - 1, sum - nums[n], lookup)
        || isSubsetSum(nums, n - 1, sum, lookup);
};

const main = () => {
    let nums = [1, 5, 11, 5];
    console.log(canPartition(nums));

    nums = [1, 2, 3, 5];
    console.log(canPartition(nums));

    nums = [3, 1, 1, 2, 2, 1];
    console.log(canPartition(nums));

    nums = [100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97];
    console.log(canPartition(nums));
};

main();