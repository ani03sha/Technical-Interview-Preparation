/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings, find the length of longest subsequence present in both of them.
 * Can we do this in O(n) space
 */
const spaceOptimizedLCS = (s1, s2) => {
    // Special case
    if (s1 === undefined || s1.length === 0 || s2 === undefined || s2.length == 0) {
        return 0;
    }
    // Lengths of two strings
    const m = s1.length;
    const n = s2.length;
    // Lookup table to store the longest common subsequence
    // for a given value of m and n.
    const lookup = Array.from(Array(2), () => Array(n + 1).fill(0));
    // Binary index used to index current and previous rows
    let binary = 0;
    // Loop over the strings
    for (let i = 1; i <= m; i++) {
        // Current binary index
        binary = i & 1;
        for (let j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) === s2.charAt(j - 1)) {
                lookup[binary][j] = 1 + lookup[1 - binary][j - 1];
            } else {
                lookup[binary][j] = Math.max(lookup[1 - binary][j], lookup[binary][j - 1]);
            }
        }
    }
    return lookup[binary][n];
};

const main = () => {
    let s1 = "ABCDGH";
    let s2 = "AEDFHR";
    console.log(spaceOptimizedLCS(s1, s2));

    s1 = "ABC";
    s2 = "AC";
    console.log(spaceOptimizedLCS(s1, s2));
};

main();