/**
 * @author Anirudh Sharma
 * 
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * A subsequence is a sequence that can be derived from another sequence by deleting some
 * or no elements without changing the order of the remaining elements.
 */
const longestPalindromeSubsequence = (s) => {
    // Special case
    if (s === undefined || s.length === 0) {
        return 0;
    }
    // Length of the string
    const n = s.length;
    // Lookup table to store the lengths of longest
    // palindromic substrings from string i to j
    const lookup = Array.from(Array(n), () => Array(n).fill(0));
    // Populate the table
    for (let i = n - 1; i >= 0; i--) {
        // Longest palindromic string in a string of
        // length 1 is 1.
        lookup[i][i] = 1;
        for (let j = i + 1; j < n; j++) {
            // If characters at both ends are equal
            if (s.charAt(i) == s.charAt(j)) {
                lookup[i][j] = lookup[i + 1][j - 1] + 2;
            } else {
                lookup[i][j] = Math.max(lookup[i + 1][j], lookup[i][j - 1]);
            }
        }
    }
    return lookup[0][n - 1];
};

const main = () => {
    console.log(longestPalindromeSubsequence("bbbab"));
    console.log(longestPalindromeSubsequence("cbbd"));
};

main();