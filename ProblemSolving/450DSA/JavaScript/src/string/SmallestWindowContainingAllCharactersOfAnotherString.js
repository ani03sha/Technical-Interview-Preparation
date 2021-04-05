/**
 * @author Anirudh Sharma
 * 
 * Given two strings S and P. Find the smallest window in the S consisting of all the characters of P.
 * 
 * Constraints:
 * 1 ≤ |S|, |P| ≤ 10^5
 */
const smallestWindow = (S, P) => {
    // Lengths of both the strings
    const sLength = S.length;
    const pLength = P.length;
    // Special case
    if (sLength < pLength) {
        return "";
    }
    // Frequency maps for characters of both the strings
    const pFrequencyMap = Array(256).fill(0);
    const sFrequencyMap = Array(256).fill(0);
    // Populate P's frequency map
    for (let c of P) {
        pFrequencyMap[c.charCodeAt(0)]++;
    }
    // Start of the window
    let start = 0;
    // Index where the desired window starts
    let startIndex = -1;
    // Minimum length of the window
    let minimumLength = Number.MAX_VALUE;
    // Count of distinct characters matched
    let count = 0;
    // Loop through S
    for (let i = 0; i < sLength; i++) {
        // Populate S' frequency map
        sFrequencyMap[S.charCodeAt(i)]++;
        // If S' character and P's characters match
        if (sFrequencyMap[S.charCodeAt(i)] <= pFrequencyMap[S.charCodeAt(i)]) {
            count++;
        }
        // If all characters are matched
        if (count === pLength) {
            // Try to minimize the window
            while (sFrequencyMap[S.charCodeAt(start)] > pFrequencyMap[S.charCodeAt(start)]
                || pFrequencyMap[S.charCodeAt(start)] === 0) {
                if (sFrequencyMap[S.charCodeAt(start)] > pFrequencyMap[S.charCodeAt(start)]) {
                    sFrequencyMap[S.charCodeAt(start)]--;
                }
                start++;
            }
            // Update window size
            let windowLength = i - start + 1;
            if (minimumLength > windowLength) {
                minimumLength = windowLength;
                startIndex = start;
            }
        }
    }
    // If no window found
    if (startIndex === -1) {
        return "";
    }
    return S.substring(startIndex, startIndex + minimumLength);
};

const main = () => {
    let S = "timetopractice";
    let P = "toc";
    console.log(smallestWindow(S, P));

    S = "zoomlazapzo";
    P = "oza";
    console.log(smallestWindow(S, P));
};

main();