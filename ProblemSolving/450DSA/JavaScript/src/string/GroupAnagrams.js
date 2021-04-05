/**
 * @author Anirudh Sharma
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * The groups must be created in order of their appearance in the original array.
 * 
 * Constraints:
 * 1<=N<=100
 */
const groupAnagrams = (words) => {
    // Copy all the words in the array to a list
    const wordList = [];
    for (let word of words) {
        wordList.push(word);
    }
    // Sort these words on the list alphabetically
    for (let i = 0; i < wordList.length; i++) {
        // Sort this word and store it in the list
        wordList[i] = wordList[i].split("").sort().join("");
    }
    // Map to store a word and its corresponding indices
    const anagrams = new Map();
    // Loop through the words array
    for (let i = 0; i < words.length; i++) {
        if (anagrams.has(wordList[i])) {
            anagrams.get(wordList[i]).push(i);
        } else {
            anagrams.set(wordList[i], [i]);
        }
    }
    // Final result
    const result = [];
    // Loop through the map
    for (let [, value] of anagrams) {
        // List of words which are anagrams
        const currentWordList = [];
        for (let index of value) {
            currentWordList.push(words[index]);
        }
        result.push(currentWordList);
    }
    return result;
};

const main = () => {
    let words = ["CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
        "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
        "SUED", "LEAN", "SCAR", "DESIGN"];
    console.table(groupAnagrams(words));

    words = ["CAT", "ACT", "DOG", "TAC", "GOD"];
    console.table(groupAnagrams(words));
};

main();