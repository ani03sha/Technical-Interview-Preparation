/**
 * @author Anirudh Sharma
 * 
 * Given a string 'S'. The task is to find the smallest window length that contains all
 * the characters of the given string at least one time.
 * For eg. A = "aabcbcdbca", then the result would be 4 as of the smallest window
 * will be "dbca".
 * 
 * Constraints:
 * 1 ≤ |S| ≤ 10^5
 * String may contain both type of English Alphabets.
 */
const findSubstring = (S) => {
    // Array to check if a character is visited
    const visited = Array(256);
    visited.fill(false);
    // Count of distinct characters
    let distinctCharacterCount = 0;
    // Loop through the array
    for (let c of S) {
        if (!visited[c]) {
            visited[c] = true;
            distinctCharacterCount++;
        }
    }
    // Minimum length of the window
    let minimumLength = Number.MAX_VALUE;
    // Start of the window
    let start = 0;
    // Index where the desired window starts
    let startIndex = -1;
    // Count of distinct characters matched
    let count = 0;
    // Frequency map of characters
    const frequencyMap = Array(256);
    frequencyMap.fill(0);
    // Loop over the string
    for (let i = 0; i < S.length; i++) {
        // Update the frequency of this character
        frequencyMap[S.charCodeAt(i)]++;
        // If any distinct character is found,
        // update the count
        if (frequencyMap[S.charCodeAt(i)] == 1) {
            count++;
        }
        // If all the characters are matched
        if (count === distinctCharacterCount) {
            // Now, we will minimize the window by
            // discarding a character that is occuring
            // more than once
            while (frequencyMap[S.charCodeAt(start)] > 1) {
                if (frequencyMap[S.charCodeAt(start)] > 1) {
                    frequencyMap[S.charCodeAt(start)]--;
                }
                start++;
            }
            // Update the window size
            let windowSize = i - start + 1;
            if (minimumLength > windowSize) {
                minimumLength = windowSize;
                startIndex = start;
            }
        }
    }
    return S.substring(startIndex, startIndex + minimumLength);
};

const main = () => {
    console.log(findSubstring("AABBBCBBAC"));
    console.log(findSubstring("aaab"));
};

main();