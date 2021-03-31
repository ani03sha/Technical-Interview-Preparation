/**
 * @author Anirudh Sharma
 * 
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
 * search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].
 */
const search = (pattern, text) => {
    // List to store the indices of match
    const matchedIndices = [];
    // Lengths of pattern and text
    const patternLength = pattern.length;
    const textLength = text.length;
    // Array for storing the indices of bad characters
    const badCharacters = new Array(256);
    // Fill the badCharacters array using preprocessing
    // bad character heuristics function
    badCharacterHeuristics(pattern, patternLength, badCharacters);
    // Shift of the pattern w.r.t. text
    let shift = 0;
    // Loop through the text string
    while (shift <= textLength - patternLength) {
        // Pointer to move from right of the pattern
        let right = patternLength - 1;
        // Move from left to right as long as the
        // characters of pattern are matching with
        // the characters of text
        while (right >= 0 && pattern.charAt(right) === text.charAt(shift + right)) {
            right--;
        }
        // If the pattern is present at the current shift,
        // then right will become -1
        if (right < 0) {
            matchedIndices.push(shift);
            // Shift the pattern so that next character in text
            // aligns with the last occurrence of it in the pattern
            shift += (shift + patternLength < textLength)
                ? patternLength - badCharacters[text.charAt(shift + patternLength)]
                : 1;
        } else {
            // Shift the pattern so that the bad character
            // in text aligns with the last occurrence of
            // it in pattern. The max function is used to
            // make sure that we get a positive shift.
            // We may get a negative shift if the last
            // occurrence  of bad character in pattern
            // is on the right side of the current
            // character
            shift += Math.max(1, right - badCharacters[text.charAt(shift + right)]);
        }
    }
    return matchedIndices;
};

const badCharacterHeuristics = (pattern, patternLength, badCharacters) => {
    // Fill the array with -1
    badCharacters.fill(-1);
    // Fill actual value of last occurrence of a character
    for (let i = 0; i < patternLength; i++) {
        badCharacters[pattern.charAt(i)] = i;
    }
};

const main = () => {
    let text = "ABAAABCD";
    let pattern = "ABC";
    console.log(search(pattern, text));

    text = "ABCDABCD";
    pattern = "ABCD";
    console.log(search(pattern, text));
};

main();