/**
 * @author Anirudh Sharma
 * 
 * Given two strings A and B, the task is to convert A to B if possible.
 * The only operation allowed is to put any character from A and insert it at front.
 * 
 * Find if it’s possible to convert the string. If yes, then output minimum no. of operations
 * required for transformation.
 */
const minimumOperations = (A, B) => {
    // Base checks for possible conversions
    if (A.length !== B.length) {
        return -1;
    }
    // Frequency map of characters in both strings
    const frequencyMap = Array(256).fill(0);
    // Loop through both strings
    for (let i = 0; i < A.length; i++) {
        frequencyMap[A.charCodeAt(i)]++;
        frequencyMap[B.charCodeAt(i)]--;
    }
    // If frequency of any character is not zero,
    // then we know that conversion is not possible
    for (let num of frequencyMap) {
        if (num !== 0) {
            return -1;
        }
    }
    // Count of operations needed
    let count = 0;
    // Variables to iterate through both strings
    let indexA = A.length - 1;
    let indexB = B.length - 1;
    // Loop from right to left
    while (indexA >= 0) {
        // If the characters don't match,
        // keep incrementing count
        if (A.charAt(indexA) !== B.charAt(indexB)) {
            count++;
        } else {
            indexB--;
        }
        indexA--;
    }
    return count;
};

const main = () => {
    let A = "EACBD";
    let B = "EABCD";
    console.log(minimumOperations(A, B));

    A = "ABD";
    B = "BAD";
    console.log(minimumOperations(A, B));
};

main();