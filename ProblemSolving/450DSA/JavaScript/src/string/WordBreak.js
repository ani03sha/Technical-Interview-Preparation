/**
 * @author Anirudh Sharma
 * 
 * Given a string s, and a dictionary of n words wordDictionary,
 * find out if A can be segmented into a space-separated sequence of dictionary words.
 * 
 * 1 <= N <= 12
 * 1 <= s <= 1000, where s = length of string A
 * The length of each word is less than 15.
 */
const wordBreak = (s, wordDictionary) => {
    // Lookup for memoization
    const lookup = new Map();
    return wordBreakHelper(s, wordDictionary, lookup);
};

const wordBreakHelper = (s, wordDictionary, lookup) => {
    // Base case
    if (s === undefined || s.length === 0) {
        return true;
    }
    // Check if the subproblem is already solved
    if (lookup.get(s)) {
        return lookup.get(s);
    }
    // Loop through the dictionary
    for (let word of wordDictionary) {
        // Check if the string starts with this word
        if (s.indexOf(word) === 0) {
            // Get the remaining word
            let suffix = s.substring(word.length);
            if (wordBreakHelper(suffix, wordDictionary, lookup)) {
                lookup.set(s, true);
                return true;
            }
        }
    }
    lookup.set(s, false);
    return false;
};

const main = () => {
    let s = "ilike";
    let wordDictionary = ["i", "like", "sam", "sung", "samsung", "mobile",
        "ice", "cream", "icecream", "man", "go", "mango"];
    console.log(wordBreak(s, wordDictionary));

    s = "ilikesamsung";
    wordDictionary = ["i", "like", "sam", "sung", "samsung", "mobile",
        "ice", "cream", "icecream", "man", "go", "mango"];
    console.log(wordBreak(s, wordDictionary));
};

main();