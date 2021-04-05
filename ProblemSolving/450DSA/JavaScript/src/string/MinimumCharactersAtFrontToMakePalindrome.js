/**
 * @author Anirudh Sharma
 * 
 * Given a string s we need to tell minimum characters to be added at front of string to make string palindrome.
 */
const getCount = (s) => {
    // Reversed String
    const reversedString = s.split("").reverse().join("");
    // Add this reverse string to the original string with
    // a special character
    let S = s + "$" + reversedString;
    // Get the LPS array
    const lps = findLPS(S);
    return s.length - lps[S.length - 1];
};

const findLPS = (pattern) => {
    const lps = Array(pattern.length).fill(0);
    // Index for checking the pattern
    let index = 0;
    for (let i = 1; i < pattern.length;) {
        if (pattern.charAt(i) === pattern.charAt(index)) {
            index++;
            lps[i] = index;
            i++;
        } else {
            if (index !== 0) {
                index = lps[index - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
};

const main = () => {
    console.log(getCount("AACECAAAA"));
    console.log(getCount("ABC"));
};

main();