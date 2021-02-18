/**
 * @author Anirudh Sharma
 * 
 * Check if a string is the valid shuffle of two other strings.
 * In order to be a valid shuffle, the order of string should be maintained.
 */
const checkIfValidShuffle = (a, b, c) => {
    // Check if sum of lengths of a and b is equal to
    // the length of c.
    if (a.length + b.length !== c.length) {
        return false;
    }
    // Pointers to iterate through different strings
    let i = 0;
    let j = 0;
    let k = 0;
    // Loop until k reaches the end of c
    while (k < c.length) {
        // Check if the character of a matches with
        // the character of c
        if (i < a.length && a[i] === c[k]) {
            i++;
        }
        // Check if character of b matches with
        // the character of c
        else if (j < b.length && b[j] === c[k]) {
            j++;
        }
        // If none of the characters match
        else {
            return false;
        }
        k++;
    }
    // Check if there are remaining characters in a or b
    return i >= a.length && j >= b.length;
};

const main = () => {
    let a = "XY";
    let b = "12";
    let c = "1XY2";
    console.log(checkIfValidShuffle(a, b, c));

    c = "Y12X";
    console.log(checkIfValidShuffle(a, b, c));
};

main();