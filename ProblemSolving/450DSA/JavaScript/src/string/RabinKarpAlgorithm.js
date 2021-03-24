/**
 * @author Anirudh Sharma
 * 
 * Given a text t[0..n-1] and a pattern p[0..m-1], write a function search(char p[], char t[])
 * that prints all occurrences of p[] in t[]. You may assume that n > m.
 */
const search = (pattern, text) => {
    // Maximum number of characters in the inputs
    const d = 256;
    // A prime number to manipulate the hash
    const q = 257;
    // Array to store the indices where pattern starts
    const indices = [];
    // Lengths of pattern and text
    const patternLength = pattern.length;
    const textLength = text.length;
    // Hashes for pattern and text
    let patternHash = 0;
    let textHash = 0;
    // To determine higher order position
    let h = 1;
    for (let i = 0; i < patternLength - 1; i++) {
        h = (h * d) % q;
    }
    // Find hash of the pattern and first window of
    // length patternLength in the text
    for (let i = 0; i < patternLength; i++) {
        patternHash = (patternHash * d + pattern.charCodeAt(i)) % q;
        textHash = (textHash * d + text.charCodeAt(i)) % q;
    }
    // Perform sliding window matching on text
    for (let i = 0; i <= textLength - patternLength; i++) {
        // If the hashes match, then only we will match the
        // characters of both the strings
        if (patternHash === textHash) {
            // Check for characters one by one
            for (let j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) !== pattern.charAt(j)) {
                    break;
                }
            }
            indices.push(i);
        }
        // Calculate the hash for the next window
        if (i < textLength - patternLength) {
            textHash = (d * (textHash - text.charCodeAt(i) * h) + text.charCodeAt(i + patternLength)) % q;
            // For negative value of textHash, convert it to positive
            if (textHash < 0) {
                textHash += q;
            }
        }
    }
    return indices;
}

const main = () => {
    let text = "ABCCDDAEFG";
    let pattern = "CDD";
    console.log(search(pattern, text));

    text = "12348765765";
    pattern = "765";
    console.log(search(pattern, text));

    text = "balloonsandcupcakes";
    pattern = "cupcakes";
    console.log(search(pattern, text));
};

main();