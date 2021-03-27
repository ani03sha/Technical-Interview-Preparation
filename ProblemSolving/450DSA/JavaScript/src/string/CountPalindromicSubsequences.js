/**
 * @author Anirudh Sharma
 * 
 * Given a string s, find number of palindromic subsequence (need not necessarily be distinct)
 * which could be formed from the string.
 */
const countPalindromicSubsequences = (s) => {
    // Count of all the palindromic subsequences
    let count = 0;
    // Loop through the string
    for (let i = 0; i < s.length; i++) {
        // For odd length string, expand from s[i]
        count += expandFromMiddle(s, i, i);
        // For even length string, expand from s[i]
        // and s[i+1]
        count += expandFromMiddle(s, i, i + 1);
    }
    return count;
};

const expandFromMiddle = (s, left, right) => {
    let count = 0;
    // Check for the equality
    while (left >= 0 && right < s.length && s.charAt(left) === s.charAt(right)) {
        // Increment the count
        count++;
        // Expand from both sides
        left--;
        right++;
    }
    return count;
};

const main = () => {
    console.log(countPalindromicSubsequences("abcd"));
    console.log(countPalindromicSubsequences("aab"));
    console.log(countPalindromicSubsequences("aaaaaaaaaaaaaaaaaaaaaaaaaaa"));
};

main();