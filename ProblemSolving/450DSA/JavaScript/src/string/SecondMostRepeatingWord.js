/**
 * @author Anirudh Sharma
 * 
 * Given a sequence of strings, the task is to find out the second most repeated (or frequent)
 * string in the given sequence.
 * 
 * Note: No two strings are the second most repeated, there will be always a single string.
 * 
 * Constraints:
 * 1<=N<=10^3
 */
const secondMostFrequent = (strings) => {
    // Map to store the frequencies of strings
    // in the array
    const frequencyMap = new Map();
    for (let s of strings) {
        if (frequencyMap.get(s)) {
            let count = frequencyMap.get(s);
            frequencyMap.set(s, count + 1);
        } else {
            frequencyMap.set(s, 1);
        }
    }
    // Max and second max
    let max = Number.MIN_VALUE;
    let secondMax = Number.MIN_VALUE;
    // Loop through the map to find the second map value
    for(let [, v] of frequencyMap) {
        if (max < v) {
            secondMax = max;
            max = v;
        } else if (v > secondMax && v !== max) {
            secondMax = v;
        }
    }
    // Again iterate through the map to get the key
    // corresponding to the the second max value
    for (let [k, v] of frequencyMap) {
        if (v === secondMax) {
            return k;
        }
    }
    return null;
};

const main = () => {
    let strings = ["aaa", "bbb", "ccc", "bbb", "aaa", "aaa"];
    console.log(secondMostFrequent(strings));

    strings = ["geek", "for", "geek", "for", "geek", "aaa"];
    console.log(secondMostFrequent(strings));
};

main();