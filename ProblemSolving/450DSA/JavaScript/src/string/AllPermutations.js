/**
 * @author Anirudh Sharma
 * 
 * Given a string S. The task is to print all permutations of a given string.
 * 
 * Constraints:
 * 1 ≤ T ≤ 10
 * 1 ≤ size of string ≤ 5
 */
const findPermutations = (s) => {
    // Array to store result
    const permutations = [];
    // Recursive call
    findPermutationsHelper(s, "", permutations);
    return permutations;
};

const findPermutationsHelper = (s, prefix, permutations) => {
    // Length of the string
    const n = s.length;
    // Special case
    if (n === 0) {
        permutations.push(prefix);
        return;
    }
    for (let i = 0; i < n; i++) {
        findPermutationsHelper(s.substring(0, i) + s.substring(i + 1, n), prefix + s.charAt(i), permutations);
    }
};

const main = () => {
    console.log(findPermutations("ABC"));
    console.log(findPermutations("ABSG"));
};

main();