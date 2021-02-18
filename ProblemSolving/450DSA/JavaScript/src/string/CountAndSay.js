/**
 * @author Anirudh Sharma
 * 
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * 
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
 * which is then converted into a different digit string.
 * 
 * To determine how you "say" a digit string, split it into the minimal number of groups
 * so that each group is a contiguous section all of the same character.
 * 
 * Then for each group, say the number of characters, then say the character.
 * 
 * To convert the saying into a digit string, replace the counts with a number
 * and concatenate every saying.
 * 
 * Constraints:
 * 1 <= n <= 30
 */
const countAndSay = (n) => {
    // Base case
    if (n <= 0) {
        return null;
    }
    // Initialize the result
    let result = "1";
    // Counter for the n
    let i = 1;
    // Loop until we reach n
    while (i < n) {
        // StringBuilder to store intermediate results
        let sb = "";
        // Variable to count the number of occurrences of
        // the digit
        let count = 1;
        // Loop through the previous version of the string
        for (let j = 1; j < result.length; j++) {
            // Check if contiguous characters are same
            if (result[j] === result[j - 1]) {
                count++;
            }
            // If the characters are not same, we will append
            // the string
            else {
                sb += count;
                sb += result[j - 1];
                // Reset the count to 1
                count = 1;
            }
        }
        // For the last character
        sb += count;
        sb += result[result.length - 1];
        result = sb;
        i++;
    }
    return result;
};

const main = () => {
    console.log(countAndSay(1));
    console.log(countAndSay(4));
};

main();