/**
 * @author Anirudh Sharma
 *
 * Given an integer array arr and an integer difference, return the length of the
 * longest subsequence in arr which is an arithmetic sequence such that the difference
 * between adjacent elements in the subsequence equals difference.
 * 
 * A subsequence is a sequence that can be derived from arr by deleting some or no elements
 * without changing the order of the remaining elements.
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 */
const longestSubsequence = (nums, difference) => {
    // Special case
    if (nums === undefined || nums.length === 0) {
        return 0;
    }
    // Lookup table to store the difference between the
    // current element and the given difference.
    // This will allow us to mark all the elements that
    // are valid for the subsequence
    const lookup = new Map();
    // Variable to store the longest length;
    let longestLength = 0;
    // Loop through the array
    for (let num of nums) {
        if (lookup.has(num - difference)) {
            lookup.set(num, lookup.get(num - difference) + 1);
        } else {
            lookup.set(num, 1);
        }
        longestLength = Math.max(longestLength, lookup.get(num));
    }
    return longestLength;
};

const main = () => {
    let nums = [1, 2, 3, 4];
    let difference = 1;
    console.log(longestSubsequence(nums, difference));

    nums = [1, 3, 5, 7];
    difference = 1;
    console.log(longestSubsequence(nums, difference));

    nums = [1, 5, 7, 8, 5, 3, 4, 2, 1];
    difference = -2;
    console.log(longestSubsequence(nums, difference));
};

main();