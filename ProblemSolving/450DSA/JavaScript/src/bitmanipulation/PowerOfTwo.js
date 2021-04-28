/**
 * @author Anirudh Sharma
 * 
 * Given a non-negative integer N. The task is to check if N is a power of 2.
 * More formally, check if N can be expressed as 2^x for some x.
 */
const isPowerOfTwo = (n) => {
    if (n <= 0) {
        return false;
    }
    return (n & (n - 1)) == 0;
};

const main = () => {
    console.log(isPowerOfTwo(2097152));
    console.log(isPowerOfTwo(8336));
    console.log(isPowerOfTwo(1));
    console.log(isPowerOfTwo(0));
};

main();