/**
 * @author Anirudh Sharma
 * <p>
 * A sequence {x1, x2, .. xn} is alternating sequence if its elements satisfy one of the
 * following relations :
 * x1 < x2 > x3 < x4 > x5..... or  x1 >x2 < x3 > x4 < x5.....
 * Your task is to find the longest such sequence.
 */
const longestAlternatingSubsequence = (nums) => {
    // Length of the longest wiggle subsequence
    let longestWiggleSubsequence = 1;
    // Sign of the difference of alternating numbers
    let lastSign = 0;
    // Loop from the second element to the end
    for (let i = 1; i < nums.length; i++) {
        let currentSign = getSign(nums[i] - nums[i - 1]);
        if (currentSign != 0 && currentSign != lastSign) {
            lastSign = currentSign;
            longestWiggleSubsequence++;
        }
    }
    return longestWiggleSubsequence;
};

const getSign = (n) => {
    if (n === 0) {
        return 0;
    } else {
        return n > 0 ? 1 : -1;
    }
};

const main = () => {
    let nums = [1, 5, 4];
    console.log(longestAlternatingSubsequence(nums));

    nums = [1, 17, 5, 10, 13, 15, 10, 5, 16, 8];
    console.log(longestAlternatingSubsequence(nums));
};

main();