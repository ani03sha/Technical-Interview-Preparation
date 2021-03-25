/**
 * @author Anirudh Sharma
 * 
 * Given a text t[0..n-1] and a pattern p[0..m-1], write a function search(char p[], char t[])
 * that prints all occurrences of p[] in t[]. You may assume that n > m.
 */
const search = (pattern, text) => {
    // Prepare the pi table of prefix-suffix table
    const lps = findLPS(pattern);
    // Indices to move through text and pattern
    // respectively
    let textIndex = 0;
    let patternIndex = 0;
    // Loop until we reach to the end
    while (textIndex < text.length && patternIndex < pattern.length) {
        // If the characters match
        if (text.charAt(textIndex) === pattern.charAt(patternIndex)) {
            textIndex++;
            patternIndex++;
        } else {
            if (patternIndex !== 0) {
                patternIndex = lps[patternIndex - 1];
            } else {
                textIndex++;
            }
        }
    }
    return patternIndex === pattern.length;
};

const findLPS = (pattern) => {
    const lps = [];
    // Index for checking the pattern
    let index = 0;
    for (let i = 1; i < pattern.length;) {
        if (pattern.charAt(i) === pattern.charAt(index)) {
            lps.push(index + 1);
            index++;
            i++;
        } else {
            if (index != 0) {
                index = lps[index - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
};

const main = () => {
    let text = "abcxabcdabcdabcy";
    let pattern = "abcdabcy";
    console.log(`Does pattern exist? ${search(pattern, text)}`);
};

main();