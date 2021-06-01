/**
 * @author Anirudh Sharma
 * 
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 * 
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 * 
 * Return the length longest chain which can be formed.
 * 
 * You do not need to use up all the given intervals. You can select pairs in any order.
 * 
 * Constraints:
 * 
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= lefti < righti < 1000
 */
const findLongestChain = (pairs) => {
    // Special case
    if (pairs == undefined || pairs.length === 0) {
        return 0;
    }
    // Sort the array by first value of pairs
    pairs = pairs.sort((a, b) => a[0] - b[0]);
    // Length of the array
    const n = pairs.length;
    // Lookup table to store the maximum chain length
    // until that index
    const lookup = new Array(n);
    // Since every pair is a valid chain pair of length 1
    lookup.fill(1);
    // Populate the table
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < i; j++) {
            // Compare the two pairs' first and second values
            if (pairs[i][0] > pairs[j][1]) {
                lookup[i] = Math.max(lookup[i], lookup[j] + 1);
            }
        }
    }
    // Find the maximum value stored in the lookup table
    let maxLength = Number.MIN_VALUE;
    for (let l of lookup) {
        maxLength = Math.max(l, maxLength);
    }
    return maxLength;
};

const main = () => {
    let pairs = [[1, 2], [2, 3], [3, 4]];
    console.log(findLongestChain(pairs));

    pairs = [[1, 2], [7, 8], [4, 5]];
    console.log(findLongestChain(pairs));
};

main();