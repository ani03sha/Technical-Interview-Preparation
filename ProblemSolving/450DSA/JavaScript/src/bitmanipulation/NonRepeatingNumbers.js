/**
 * @author Anirudh Sharma
 * 
 * Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs
 * whereas the other two number occur exactly once and are distinct.
 * 
 * Find the other two numbers.
 */
const nonRepeating = (A) => {
    // Set the first element as x
    let x = A[0];
    // Loop through the array and find XOR
    for (let i = 1; i < A.length; i++) {
        x ^= A[i];
    }
    // At this point x = a XOR b where
    // a and b are distinct numbers
    // Find the rightmost set bit of x
    let rightmostSetBit = x & -x;
    // Two distinct numbers
    let a = 0;
    let b = 0;
    // Divide the elements into two groups
    for (let p of A) {
        if ((p & rightmostSetBit) !== 0) {
            a ^= p;
        } else {
            b ^= p;
        }
    }
    return [a, b];
};

const main = () => {
    let A = [1, 2, 3, 2, 1, 4];
    console.log(nonRepeating(A));

    A = [2, 1, 3, 2];
    console.log(nonRepeating(A));
};

main();