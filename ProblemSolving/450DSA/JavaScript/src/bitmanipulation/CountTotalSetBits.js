/**
 * @author Anirudh Sharma
 * 
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
 */
const totalSetBits = (N) => {
    // compensate for zero
    N++;
    // To store the powers of two
    let powerOfTwo = 2;
    // Total set bits
    let setBits = parseInt(N / 2);
    // Loop until powerOfTwo exceeds N
    while (powerOfTwo <= N) {
        // Total pairs of 0s and 1s
        let pairs = parseInt(N / powerOfTwo);
        // Get only pairs of 1s and multiply it with powerOfTwo
        setBits += powerOfTwo * parseInt((pairs / 2));
        // If pairs were odd
        setBits += (pairs % 2 === 1) ? N % powerOfTwo : 0;
        // Next power of two
        powerOfTwo <<= 1;
    }
    return setBits;
};

const main = () => {
    console.log(totalSetBits(2));
    console.log(totalSetBits(14));
};

main();