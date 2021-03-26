/**
 * @author Anirudh Sharma
 * 
 * Given a sentence in the form of a string, convert it into its equivalent mobile
 * numeric keypad sequence.
 */
const convert = (input) => {
    // Array to store all the possible combinations
    const inputMap = [
        "2", "22", "222",
        "3", "33", "333",
        "4", "44", "444",
        "5", "55", "555",
        "6", "66", "666",
        "7", "77", "777", "7777",
        "8", "88", "888",
        "9", "99", "999", "9999"
    ];
    // String to store output
    let output = "";
    // Loop through every character of the string
    for (let i = 0; i < input.length; i++) {
        // Get current character
        if (input.charAt(i) === ' ') {
            output += "0";
        } else {
            output += inputMap[input.charCodeAt(i) - 65];
        }
    }
    return output;
};

const main = () => {
    let input = "ANIRUDH";
    console.log(convert(input));

    input = "RED QUARK";
    console.log(convert(input));
};

main();