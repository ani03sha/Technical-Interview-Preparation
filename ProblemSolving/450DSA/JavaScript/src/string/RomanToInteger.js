/**
 * @author Anirudh Sharma
 * 
 * Given a string in roman no format(s) your task is to convert it to an integer.
 * Various symbols and their values are given below.
 */
const romanToInteger = (s) => {
    // Map to store romans numerals
    const romanMap = new Map();
    // Fill the map
    romanMap.set('I', 1);
    romanMap.set('V', 5);
    romanMap.set('X', 10);
    romanMap.set('L', 50);
    romanMap.set('C', 100);
    romanMap.set('D', 500);
    romanMap.set('M', 1000);
    // Length of the given string
    const n = s.length;
    // Variable to store result
    let decimal = romanMap.get(s.charAt(n - 1));
    // Loop for each character from right to left
    for (let i = n - 2; i >= 0; i--) {
        // Check if the character at right of current character is
        // bigger or smaller
        if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i + 1))) {
            decimal += romanMap.get(s.charAt(i));
        } else {
            decimal -= romanMap.get(s.charAt(i));
        }
    }
    return decimal;
};

const main = () => {
    console.log(romanToInteger("V"));
    console.log(romanToInteger("III"));
};

main();