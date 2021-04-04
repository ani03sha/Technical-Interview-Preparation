/**
 * @author Anirudh Sharma
 * 
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent
 * to each other are not the same.
 * 
 * If possible, output any possible result.  If not possible, return the empty string.
 * 
 * Note:
 * S will consist of lowercase letters and have length in range [1, 500].
 */
const reorganizeString = (S) => {
    // Map to store the frequencies of characters
    const frequencyMap = {};
    // Populate the map
    for (let c of S) {
        frequencyMap[c] = frequencyMap[c] + 1 || 1;
    }
    // Max heap to store the key value pairs
    const maxHeap = [];
    for (let key in frequencyMap) {
        maxHeap.push([key, frequencyMap[key]]);
    }
    // Sort the maxHeap based on the frequency of characters
    maxHeap.sort((a, b) => b[1] - a[1]);
    // To store result
    let result = "";
    // Loop until the maxHeap is empty
    while (maxHeap.length !== 0) {
        // Get the last character
        let lastCharacter = result[result.length - 1];
        // Get the first key from the heap
        let first = maxHeap.shift();
        // Check if last character is not equal to the key
        if (lastCharacter !== first[0]) {
            result += first[0];
            // If their counts is greater than zero, we need to
            // put them back in the heap
            if (first[1] !== 1) {
                maxHeap.push([first[0], first[1] - 1]);
            }
        } else {
            // Second key in the heap
            let second = maxHeap.shift();
            if (second === undefined) {
                return "";
            }
            result += second[0];
            maxHeap.push(first);
            // If their counts is greater than zero, we need to
            // put them back in the heap
            if (second[1] !== 1) {
                maxHeap.push([second[0], second[1] - 1]);
            }
        }
        // Sort the heap
        maxHeap.sort((a, b) => b[1] - a[1]);
    }
    return result;
};

const main = () => {
    console.log(reorganizeString("aab"));
    console.log(reorganizeString("aaab"));
};

main();