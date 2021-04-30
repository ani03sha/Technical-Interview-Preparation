/**
 * @author Anirudh Sharma
 * 
 * Given a string s find all possible subseqences of the string in lexicographically-sorted order
 */
const findSubsequences = (s) => {
    // Array to store results
    const result = [];
    // Map to store strings
    const sortedSubsequences = new Map();
    // length of the string
    const n = s.length;
    // Total number of non-empty subsequences
    const limit = parseInt(Math.pow(2, n)) - 1;
    // Loop for every combination
    for (let i = 1; i <= limit; i++) {
        // Get current subsequence
        let subsequence = getSubsequences(s, i, n);
        // String this sub sequences in map
        if (!sortedSubsequences.has(subsequence.length)) {
            sortedSubsequences.set(subsequence.length, []);
        }
        sortedSubsequences.get(subsequence.length).push(subsequence);
    }
    // Populate the resultant list
    for (let key of sortedSubsequences.keys()) {
        result.push(...sortedSubsequences.get(key));
    }
    result.sort();
    return result;
};

const getSubsequences = (s, index, n) => {
    let subSequence = "";
    for (let i = 0; i < n; i++) {
        // Check if i-th bit in index is 1
        if ((index & (1 << i)) !== 0) {
            subSequence += s.charAt(i);
        }
    }
    return subSequence;
};

const main = () => {
    console.log(findSubsequences("abc"));
    console.log(findSubsequences("axz"));
};

main();