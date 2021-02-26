/**
 * @author Anirudh Sharma
 * 
 * Given a binary string str of length N, the task is to find the maximum count of substrings 's'
 * can be divided into such that all the substrings are balanced i.e. they have equal number of 0s and 1s.
 * 
 * If it is not possible to split str satisfying the conditions then print -1.
 */
const countOfBalancedSubstrings = (s) => {
    // Count of ones and zeros in the string
    let zeroCount = 0;
    let oneCount = 0;
    // Count of balanced substrings
    let count = 0;
    // Loop through the entire string
    for (let c of s) {
        if (c === '0') {
            zeroCount++;
        } else if (c === '1') {
            oneCount++;
        }
        if (zeroCount === oneCount) {
            count++;
        }
    }
    return zeroCount === oneCount ? count : -1;
};

const main = () => {
    console.log(countOfBalancedSubstrings("0100110101"));
    console.log(countOfBalancedSubstrings("0111100010"));
};

main();