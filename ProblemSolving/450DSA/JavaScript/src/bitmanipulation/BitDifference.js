/**
 * @author Anirudh Sharma
 * 
 * You are given two numbers A and B.
 * The task is to count the number of bits needed to be flipped to convert A to B.
 * 
 * Constraints:
 * 1 ≤ A, B ≤ 10^6
 */
const countBits = (A, B) => {
    // Variable to store count
    let count = 0;
    // Variable to store XOR of A and B
    let C = A ^ B;
    // Loop until C becomes 0
    while (C !== 0) {
        count++;
        C &= (C - 1);
    }
    return count;
};

const main = () => {
    console.log(countBits(10, 20));
    console.log(countBits(20, 25));
};

main();