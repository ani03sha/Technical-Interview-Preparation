/**
 * @author Anirudh Sharma
 * 
 * Given an array of n positive integers and a number k.
 * 
 * Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
 * 
 * Constraints:
 * 1 ≤ N ≤ 10^5
 * 1 ≤ nums[i], K ≤10^7
 */
const minimumSwaps = (nums, k) => {
    // Special cases
    if (nums === undefined || nums.length < 2) {
        return 0;
    }
    // Count elements which are less than or equal to k
    let lessThanOrEqualToK = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] <= k) {
            lessThanOrEqualToK++;
        }
    }
    // Count number of elements which are greater than k
    // int the first window of size lessThanOrEqualToK
    let greaterThanK = 0;
    for (let i = 0; i < lessThanOrEqualToK; i++) {
        if (nums[i] > k) {
            greaterThanK++;
        }
    }
    // Final count of swaps required
    let swaps = greaterThanK;
    // Using two pointer technique
    let left = 0;
    let right = lessThanOrEqualToK;
    // Loop until right pointer reaches to the end
    while (right < nums.length) {
        // Decrement count of previous window
        if (nums[left] > k) {
            --greaterThanK;
        }
        // Increment count of current window
        if (nums[right] > k) {
            ++greaterThanK;
        }
        left++;
        right++;
        swaps = Math.min(swaps, greaterThanK);
    }
    return swaps;
};


let arr = [2, 1, 5, 6, 3];
let K = 3;
console.log(minimumSwaps(arr, K));

arr = [2, 7, 9, 5, 8, 7, 4];
K = 6;
console.log(minimumSwaps(arr, K));