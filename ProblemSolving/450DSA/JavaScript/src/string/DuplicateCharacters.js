/**
 * @author Anirudh Sharma
 * 
 * Write an efficient program to print all the duplicates and their counts in the input string.
 */
const printDuplicateCharacters = (s) => {
    // Map to store the count of the characters
    const characterCount = new Map();
    // Loop through the entire string
    [...s].forEach(c => {
        characterCount.get(c) === undefined 
        ? characterCount.set(c, 1) 
        : characterCount.set(c, characterCount.get(c) + 1);
    });
    // Loop through the map to show the duplicate characters
    for (let [key, value] of characterCount) {
        if (value > 1) {
            console.log(`Character: ${key} Count: ${value}`);
        }
    }
};

const main = () => {
    let s = "test string";
    printDuplicateCharacters(s);

    s = "thisstringcontainsmanyduplicatecharacters";
    printDuplicateCharacters(s);
};

main();