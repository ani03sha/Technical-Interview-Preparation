/**
 * @author Anirudh Sharma
 * 
 * Given a number N having only one ‘1’ and all other ’0’s in its binary representation,
 * find position of the only set bit.
 * 
 * If there are 0 or more than 1 set bit the answer should be -1.
 * 
 * Position of  set bit '1' should be counted starting with 1 from LSB side in binary
 * representation of the number.
 */
const findPosition = (n) => {
    return (n & (n - 1)) === 0 ? parseInt((Math.log(n) / Math.log(2) + 1)) : -1;
};

const main = () => {
    console.log(findPosition(2));
    console.log(findPosition(8));
    console.log(findPosition(5));
};

main();