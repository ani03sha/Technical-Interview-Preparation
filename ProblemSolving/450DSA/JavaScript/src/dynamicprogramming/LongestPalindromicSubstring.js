/**
 * @author Anirudh Sharma
 * 
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Constraints
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case).
 */
const longestPalindromicSubstring = (s) => {
    // Special case
    if (s === undefined || s.length === 0) {
        return "";
    }
    // Start and ending pointers
    let start = 0;
    let end = 0;
    // Loop through the string and treat each character
    // as the center and expand around it
    for (let i = 0; i < s.length; i++) {
        // Case where length is even
        let a = expandFromCenter(s, i, i);
        // Case where length is odd
        let b = expandFromCenter(s, i, i + 1);
        // Maximum length between the two
        let c = Math.max(a, b);
        // Get the length of the longest palindromic substring
        if (c > end - start) {
            start = i - parseInt((c - 1) / 2);
            end = i + parseInt(c / 2);
        }
    }
    return s.substring(start, end + 1);
};

const expandFromCenter = (s, left, right) => {
    // Base case
    if (s === undefined || left > right) {
        return 0;
    }
    // Loop until left character is equal to the right character
    while (left >= 0 && right < s.length && s[left] === s[right]) {
        // Move towards left and right from the center
        left--;
        right++;
    }
    return right - left - 1;
};

const main = () => {
    console.log(longestPalindromicSubstring("babad"));
    console.log(longestPalindromicSubstring("cbbd"));
    console.log(longestPalindromicSubstring("a"));
    console.log(longestPalindromicSubstring("ac"));
};

main();