/**
 * @author Anirudh Sharma
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Constraints:
 * 
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
const longestCommonPrefix = (strings) => {
    // This variable will store the longest common prefix
    let lcp = "";
    // Special cases
    if (strings === undefined || strings.length === 0) {
        return lcp;
    }
    // Find the length of the shortest string from
    // the array of strings
    let minLength = strings[0].length;
    for (let i = 1; i < strings.length; i++) {
        minLength = Math.min(minLength, strings[i].length);
    }
    // Loop until the minimum length
    for (let i = 0; i < minLength; i++) {
        // Get the current character from first string
        let current = strings[0].charAt(i);
        // Check if this character lies in every string
        // or not
        for (let s of strings) {
            if (s.charAt(i) !== current) {
                return lcp;
            }
        }
        lcp += current;
    }
    return lcp;
};

const main = () => {
    let strings = ["flower", "flow", "flight"];
    console.log(longestCommonPrefix(strings));

    strings = ["dog", "racecar", "car"];
    console.log(longestCommonPrefix(strings));
};

main();