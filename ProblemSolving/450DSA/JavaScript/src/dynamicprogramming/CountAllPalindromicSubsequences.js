/**
 * @author Anirudh Sharma
 *
 * Find how many palindromic subsequences (need not necessarily be distinct) can be formed
 * in a given string.
 * Note that the empty string is not considered as a palindrome.
 */
const countPalindromicSubsequences = (s) => {
    // Special case
    if (s == undefined || s.length === 0) {
        return 0;
    }
    // Length of the string
    const n = s.length;
    // Lookup table to store the palindromic subsequences
    const lookup = Array.from(Array(n), () => Array(n).fill(0));
    // Populate the lookup table for strings of length 1
    for (let i = 0; i < n; i++) {
        lookup[i][i] = 1;
    }
    // Populate for other combinations
    for (let i = 2; i <= n; i++) {
        for (let j = 0; j <= n - i; j++) {
            let k = i + j - 1;
            // If extreme characters are same
            if (s.charAt(j) === s.charAt(k)) {
                lookup[j][k] = lookup[j + 1][k] + lookup[j][k - 1] + 1;
            } else {
                lookup[j][k] = lookup[j + 1][k] + lookup[j][k - 1] - lookup[j + 1][k - 1];
            }
        }
    }
    return lookup[0][n - 1];
};

const main = () => {
    let s = "abcb";
    console.log(countPalindromicSubsequences(s));

    s = "abcd";
    console.log(countPalindromicSubsequences(s));

    s = "aaaa";
    console.log(countPalindromicSubsequences(s));
};

main();