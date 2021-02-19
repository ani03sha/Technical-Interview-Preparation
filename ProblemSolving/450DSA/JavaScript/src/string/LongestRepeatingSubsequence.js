/**
 * @author Anirudh Sharma
 * 
 * Given a string str, find length of the longest repeating subseequence such that the two
 * subsequence don’t have same string character at same position, i.e., any i-th character
 * in the two subsequences shouldn’t have the same index in the original string.
 * 
 * Constraints:
 * 1 <= |s| <= 500
 */
const longestRepeatingSubsequence = (s) => {
    // Length of the string
    const n = s.length;
    // DP array
    const dp = Array.from(Array(n + 1), () => new Array(n + 1).fill(0));
    // Fill the dp array
    
    // Fill the DP array
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= n; j++) {
            if (s[i - 1] === s[j - 1] && i !== j) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    return dp[n][n];
};

const main = () => {
    console.log(longestRepeatingSubsequence("banana"));
    console.log(longestRepeatingSubsequence("abcd"));
    console.log(longestRepeatingSubsequence("axxxy"));
    console.log(longestRepeatingSubsequence("aab"));
};

main();