/**
 * @author Anirudh Sharma
 * 
 * Given a binary string of 0s and 1s. The task is to find the maximum difference of the number
 * of 0s and the number of 1s (number of 0s – number of 1s) in the substrings of a string.
 * 
 * Note: In the case of all 1s, the answer will be -1.
 */
const maxDifference = (s) => {
    // Special case
    if (s === undefined || s.length === 0 || checkIfAllOnes(s)) {
        return -1;
    }
    // Length of the String
    const n = s.length;
    // Array containing the integer values
    const nums = new Array(n);
    // Fill this array => -1 for '1' and 1 for '0'
    for (let i = 0; i < n; i++) {
        nums[i] = s.charAt(i) === '0' ? 1 : -1;
    }
    // Lookup table to store two cases
    // lookup[i][0] -> maxDifference up to i, if we skip i-th element
    // lookup[i][1] -> maxDifference up to i, if we consider i-th element
    const lookup = Array.from(Array(n), () => Array(2).fill(-1));
    return findLength(nums, n, 0, 0, lookup);
};

const findLength = (nums, n, index, choice, lookup) => {
    // If we have reached the end of the string
    if (index >= n) {
        return 0;
    }
    // If we already have calculated the state
    if (lookup[index][choice] !== -1) {
        return lookup[index][choice];
    }
    if (choice === 0) {
        return lookup[index][choice] = Math.max(
            nums[index] + findLength(nums, n, index + 1, 1, lookup),
            findLength(nums, n, index + 1, 0, lookup));
    } else {
        return lookup[index][choice] = Math.max(
            nums[index] + findLength(nums, n, index + 1, 1, lookup),
            0);
    }
};

const checkIfAllOnes = (s) => {
    // Count of ones
    let oneCount = 0;
    for (let c of s) {
        if (c === '1') {
            oneCount++;
        }
    }
    return oneCount === s.length;
};

const main = () => {
    console.log(maxDifference("11000010001"));
    console.log(maxDifference("111111"));
};

main();