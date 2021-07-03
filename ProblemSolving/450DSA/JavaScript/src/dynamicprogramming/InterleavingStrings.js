/**
 * @author Anirudh Sharma
 * 
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * 
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty
 * substrings such that:
 * 
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 
 * Note: a + b is the concatenation of strings a and b.
 */
const isInterleave = (s1, s2, s3) => {
    // Special case
    if (s1 === undefined || s2 === undefined || s3 === undefined) {
        return false;
    }
    // Lengths of the strings
    const m = s1.length;
    const n = s2.length;
    // Special case
    if (m + n !== s3.length) {
        return false;
    }
    // Lookup table to store if the substrings ending
    // at i and j are interleaved or not
    const lookup = Array.from(Array(m + 1), () => Array(n + 1).fill(false));
    // Populate the lookup table
    for (let i = 0; i <= m; i++) {
        for (let j = 0; j <= n; j++) {
            if (i === 0 && j === 0) {
                lookup[i][j] = true;
            } else if (i === 0) {
                if (s2.charAt(j - 1) === s3.charAt(j - 1)) {
                    lookup[i][j] = lookup[i][j - 1];
                }
            } else if (j === 0) {
                if (s1.charAt(i - 1) === s3.charAt(i - 1)) {
                    lookup[i][j] = lookup[i - 1][j];
                }
            } else if (s1.charAt(i - 1) === s3.charAt(i + j - 1) && s2.charAt(j - 1) !== s3.charAt(i + j - 1)) {
                lookup[i][j] = lookup[i - 1][j];
            } else if (s1.charAt(i - 1) !== s3.charAt(i + j - 1) && s2.charAt(j - 1) === s3.charAt(i + j - 1)) {
                lookup[i][j] = lookup[i][j - 1];
            } else if (s1.charAt(i - 1) === s3.charAt(i + j - 1) && s2.charAt(j - 1) === s3.charAt(i + j - 1)) {
                lookup[i][j] = lookup[i - 1][j] || lookup[i][j - 1];
            }
        }
    }
    return lookup[m][n];
};

const main = () => {
    let s1 = "YX";
    let s2 = "X";
    let s3 = "XXY";
    console.log(isInterleave(s1, s2, s3));

    s1 = "XY";
    s2 = "X";
    s3 = "XXY";
    console.log(isInterleave(s1, s2, s3));
};

main();