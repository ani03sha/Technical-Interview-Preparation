/**
 * @author Anirudh Sharma
 * 
 * You are given an array of positive integers nums.
 * 
 * Count and print the number of (contiguous) subarrays where the product of
 * all the elements in the subarray is less than k.
 * 
 * Note:
 * 
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */
const numSubsequencesProductLessThanK = (nums, k) => {
    // Special cases
    if (nums === undefined || nums.length === 0) {
        return 0;
    }
    // Length of the array
    const n = nums.length;
    // Lookup table to store the number of sequences
    // that are required after using first j terms to
    // make product less than i.
    const lookup = Array.from(Array(k + 1), () => Array(n + 1).fill(0));
    // Populate the table for all sums
    for (let i = 1; i <= k; i++) {
        for (let j = 1; j <= n; j++) {
            // Number of sequences using j - 1 terms
            lookup[i][j] = lookup[i][j - 1];
            if (nums[j - 1] <= i && nums[j - 1] > 0) {
                // Number of subsequences using 1 to j - 1
                // terms and j-th term
                lookup[i][j] += lookup[parseInt(i / nums[j - 1])][j - 1] + 1;
            }
        }
    }
    return lookup[k][n];
};

const main = () => {
    let nums = [1, 2, 3, 4];
    let k = 10;
    console.log(numSubsequencesProductLessThanK(nums, k));

    nums = [4, 8, 7, 2];
    k = 50;
    console.log(numSubsequencesProductLessThanK(nums, k));
};

main();