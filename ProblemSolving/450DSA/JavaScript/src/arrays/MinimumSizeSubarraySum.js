/**
 * @author Anirudh Sharma
 * 
 * Given an array of positive integers nums and a positive integer target, return the minimal
 * length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is
 * greater than or equal to target. If there is no such subarray, return 0 instead.
 * 
 * Constraints:
 * 
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
const minSubArrayLen = (target, nums) => {
    // Length of the array
    const n = nums.length;
    // Start and end pointers
    let start = 0;
    let end = 0;
    // Minimum length of the subarray
    let minimumLength = Number.MAX_VALUE;
    // Sum of the subarray
    let sum = 0;
    // Loop until the end pointer reaches to the end
    // of the array
    while (end < n) {
        // Loop until we get sum greater than or
        // equal to the target
        while (sum < target && end < n) {
            sum += nums[end];
            end++;
        }
        // As soon as we get sum greater than target,
        // we will start removing elements from the start
        while (sum >= target && start < n) {
            minimumLength = Math.min(minimumLength, end - start);
            sum -= nums[start];
            start++;
        }
    }
    return minimumLength == Number.MAX_VALUE ? 0 : minimumLength;
};


let a = [2, 3, 1, 2, 4, 3];
let t = 7;
console.log(minSubArrayLen(t, a));

a = [1, 4, 4];
t = 4;
console.log(minSubArrayLen(t, a));

a = [1, 1, 1, 1, 1, 1, 1, 1];
t = 11;
console.log(minSubArrayLen(t, a));

