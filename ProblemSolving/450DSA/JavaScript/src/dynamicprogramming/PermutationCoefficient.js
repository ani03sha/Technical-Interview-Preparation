/**
 * @author Anirudh Sharma
 * 
 * Given two integers n and r, find nPr.
 * Since the answer may be very large, calculate the answer modulo 10^9+7.
 * 
 * Constraints:
 * 1 ≤ n ≤ 1000
 * 1 ≤ r ≤ 800
 */
const calculateCoefficient = (n, r) => {
    // Lookup table
    const lookup = Array.from(Array(n + 1), () => Array(r + 1).fill(-1));
    // Fill the array with default values
    return calculateCoefficientHelper(n, r, lookup);
};

const calculateCoefficientHelper = (n, r, lookup) => {
    if (n < r) {
        return 0;
    }
    if (r === 0) {
        return 1;
    }
    if (lookup[n][r] !== -1) {
        return lookup[n][r];
    }
    return lookup[n][r] = calculateCoefficient(n - 1, r) + r * calculateCoefficient(n - 1, r - 1);
};

const main = () => {
    let n = 10;
    let r = 2;
    console.log(calculateCoefficient(n, r));

    n = 10;
    r = 3;
    console.log(calculateCoefficient(n, r));

    n = 10;
    r = 0;
    console.log(calculateCoefficient(n, r));

    n = 10;
    r = 1;
    console.log(calculateCoefficient(n, r));
};

main();