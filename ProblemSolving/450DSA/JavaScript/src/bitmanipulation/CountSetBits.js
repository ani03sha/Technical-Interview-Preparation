/**
 * @author Anirudh Sharma
 * 
 * Given a positive integer N, print count of set bits in it.
 */
const countSetBits = (N) => {
    // Count of set bits
    let count = 0;
    // Loop until N becomes zero
    while (N > 0) {
        N &= (N - 1);
        count++;
    }
    return count;
};

const main = () => {
    console.log(countSetBits(6));
    console.log(countSetBits(31));
    console.log(countSetBits(13));
    console.log(countSetBits(40));
};

main();