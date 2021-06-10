/**
 * @author Anirudh Sharma
 * 
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 */
const findLCS = (X, Y) => {
    // Special cases
    if (X === undefined || X.length === 0 || Y === undefined || Y.length === 0) {
        return 0;
    }
    // Lengths of the two strings
    const m = X.length;
    const n = Y.length;
    // Lookup table to store the lcs length
    const lookup = Array.from(Array(m + 1), () => Array(n + 1).fill(0));
    // Length of the final lcs
    let lcsLength = 0;
    for (let i = 0; i <= m; i++) {
        for (let j = 0; j <= n; j++) {
            if (i > 0 && j > 0 && X.charAt(i - 1) === Y.charAt(j - 1)) {
                lookup[i][j] = 1 + lookup[i - 1][j - 1];
                lcsLength = Math.max(lcsLength, lookup[i][j]);
            }
        }
    }
    return lcsLength;
};

const main = () => {
    let X = "ABCDGH";
    let Y = "ACDGHR";
    console.log(findLCS(X, Y));

    X = "ABC";
    Y = "ACB";
    console.log(findLCS(X, Y));
};

main();