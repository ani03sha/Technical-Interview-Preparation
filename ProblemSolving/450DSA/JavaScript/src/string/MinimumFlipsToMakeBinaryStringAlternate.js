/**
 * @author Anirudh Sharma
 * 
 * Given a binary string, that is it contains only 0s and 1s. We need to make this string a
 * sequence of alternate characters by flipping some of the bits, our goal is to minimize
 * the number of bits to be flipped.
 * 
 * Constraints:
 * 1<=|S|<=10^5
 */
const minimumFlips = (s) => {
    return Math.min(getFlips(s, '0'), getFlips(s, '1'));
}

const getFlips = (s, expected) => {
    // Count of flips to make
    let flips = 0;
    // Loop through the entire string
    for (let i = 0; i < s.length; i++) {
        // If the character is not expected,
        // increment the flips
        if (s.charAt(i) != expected) {
            flips++;
        }
        // Update the expected character
        expected = expected === '0' ? '1' : '0';
    }
    return flips;
};

const main = () => {
    let s = "001";
    console.log(minimumFlips(s));

    s = "0001010111";
    console.log(minimumFlips(s));
};

main();