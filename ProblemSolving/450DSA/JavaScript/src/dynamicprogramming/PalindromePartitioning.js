/**
 * @author Anirudh Sharma
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 */
const minimumCuts = (s) => {
    // Special cases
    if (s === undefined || s.length == 0) {
        return 0;
    }
    // Length of the string
    const n = s.length;
    if (n < 2) {
        return 1;
    }
    // Lookup table to store the partition position
    const lookup = Array.from(Array(n), () => Array(n).fill(0));
    // Array to store the cuts
    const cuts = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        // Set maximum number of cuts
        cuts[i] = i;
        for (let j = 0; j <= i; j++) {
            if (s.charAt(i) === s.charAt(j) && (i - j < 2 || lookup[j + 1][i - 1])) {
                lookup[j][i] = true;
                if (j > 0) {
                    cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                } else {
                    cuts[i] = 0;
                }
            }
        }
    }
    return cuts[n - 1];
};

const main = () => {
    let s = "aab";
    console.log(minimumCuts(s));

    s = "a";
    console.log(minimumCuts(s));

    s = "ab";
    console.log(minimumCuts(s));
};

main();