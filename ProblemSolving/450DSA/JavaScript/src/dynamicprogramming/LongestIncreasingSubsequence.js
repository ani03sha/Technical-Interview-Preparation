/**
 * @author Anirudh Sharma
 * 
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * 
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements
 * without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence
 * of the array [0,3,1,6,2,2,7].
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 */
const lengthOfLIS = (nums) => {
    // Special case
    if (nums === undefined || nums.length === 0) {
        return 0;
    }
    // Length of the array
    const n = nums.length;
    // Lookup table to store the longest increasing
    // subsequence until a certain index.
    // lookup[i] => length of longest increasing sub
    // -sequence ending at index i
    const lookup = Array(n);
    // Since every element is an increasing sequence of
    // length 1.
    nums.fill(1);
    // Loop through the array
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j] && lookup[i] < lookup[j] + 1) {
                lookup[i] = lookup[j] + 1;
            }
        }
    }
    // Find the maximum value in the lookup table
    let longest = 0;
    for (let x of lookup) {
        longest = Math.max(longest, x);
    }
    return longest;
};

const main = () => {
    let nums = [10, 9, 2, 5, 3, 7, 101, 18];
    console.log(lengthOfLIS(nums));

    nums = [0, 1, 0, 3, 2, 3];
    console.log(lengthOfLIS(nums));

    nums = [7, 7, 7, 7, 7, 7, 7];
    console.log(lengthOfLIS(nums));
};

main();