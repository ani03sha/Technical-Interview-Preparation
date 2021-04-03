/**
 * @author Anirudh Sharma
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string with some
 * characters (can be none) deleted without changing the relative order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * 
 * Constraints:
 * 
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
const longestCommonSubsequence = (text1, text2) => {
    // Lengths of the strings
    const m = text1.length;
    const n = text2.length;
    // DP array
    const dp = Array.from(Array(m + 1), () => Array(n + 1).fill(0));
    // Loop through the texts
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            // Check if characters are same
            if (text1.charAt(i - 1) === text2.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    return dp[m][n];
};

const main = () => {
    let text1 = "abcde";
    let text2 = "ace";
    console.log(longestCommonSubsequence(text1, text2));

    text1 = "abc";
    text2 = "abc";
    console.log(longestCommonSubsequence(text1, text2));

    text1 = "abc";
    text2 = "def";
    console.log(longestCommonSubsequence(text1, text2));
};

main();