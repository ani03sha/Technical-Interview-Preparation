/**
 * @author Anirudh Sharma
 * 
 * Given a string S delete the characters which are appearing more than once consecutively.
 * 
 * Constraints:
 * 1<=|S|<=10^5
 * All characters are lowercase alphabets.
 */
const removeConsecutiveCharacters = (S) => {
    // To store the final result
    let s = "";
    // Loop through the string
    for (let i = 0; i < S.length; i++) {
        s += S.charAt(i);
        while (i + 1 < S.length && S.charAt(i) === S.charAt(i + 1)) {
            i++;
        }
    }
    return s;
};

const main = () => {
    console.log(removeConsecutiveCharacters("aabb"));
    console.log(removeConsecutiveCharacters("aabaa"));
};

main();