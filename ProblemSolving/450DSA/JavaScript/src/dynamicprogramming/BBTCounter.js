/**
 * @author Anirudh Sharma
 * 
 * Given a height h, count the maximum number of balanced binary trees possible with height h.
 * Print the result modulo 10^9 + 7.
 */
const countBT = (h) => {
    const MODULUS = 1000000007;
    // Lookup table to store intermediate results
    const lookup = new Array(h + 1).fill(0);
    // Base initialization
    lookup[0] = 1;
    lookup[1] = 1;
    // Populate the remaining table
    for (let i = 2; i <= h; i++) {
        lookup[i] = (lookup[i - 1] * ((2 * lookup[i - 2]) % MODULUS + lookup[i - 1]) % MODULUS) % MODULUS;
    }
    return lookup[h];
};

const main = () => {
    console.log(countBT(2));
    console.log(countBT(3));
};

main();