/**
 * @author Anirudh Sharma
 * 
 * Given two sequences, find the length of longest subsequence present in both of them.
 * Both the strings are of uppercase.
 */
const lcs = (s1, s2) => {
    // Special case
    if (s1 === undefined || s1.length ==- 0 || s2 === undefined || s2.length == 0) {
        return 0;
    }
    // Lengths of the two strings
    const m = s1.length;
    const n = s2.length;
    // Lookup table to store the longest common subsequence
    // for a given value of m and n.
    const lookup = Array.from(Array(m + 1), () => Array(n + 1).fill(0));
    // Populate the table for each character
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            // If current characters are same
            if (s1.charAt(i - 1) === s2.charAt(j - 1)) {
                lookup[i][j] = 1 + lookup[i - 1][j - 1];
            } else {
                lookup[i][j] = Math.max(lookup[i - 1][j], lookup[i][j - 1]);
            }
        }
    }
    return lookup[m][n];
};

const main = () => {
    let s1 = "ABCDGH";
    let s2 = "AEDFHR";
    console.log(lcs(s1, s2));

    s1 = "ABC";
    s2 = "AC";
    console.log(lcs(s1, s2));
};

main();