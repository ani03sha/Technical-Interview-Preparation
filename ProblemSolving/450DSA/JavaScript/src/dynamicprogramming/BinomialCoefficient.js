/**
 * @author Anirudh Sharma
 * <p>
 * Given two integers n and r, find nCr.
 * Since the answer may be very large, calculate the answer modulo 10^9+7.
 * <p>
 * Constraints:
 * 1 ≤ n ≤ 1000
 * 1 ≤ r ≤ 800
 */
const calculateCoefficient = (n, r) => {
    // Lookup table
    const lookup = Array.from(Array(n + 1), () => Array(r + 1).fill(-1));
    // Fill the array with default values
    return calculateCoefficientHelper(n, r, lookup) % 1000000007;
};

const calculateCoefficientHelper = (n, r, lookup) => {
    // Base case
    if (n < r) {
        return 0;
    }
    // If r is zero, or n is equal to r
    if (r === 0 || n === r) {
        return 1;
    }
    // Get the memoized value
    if (lookup[n][r] !== -1) {
        return lookup[n][r];
    }
    return lookup[n][r] = calculateCoefficientHelper(n - 1, r - 1, lookup)
        + calculateCoefficientHelper(n - 1, r, lookup);
};

const main = () => {
    let n = 3;
    let r = 2;
    console.log(calculateCoefficient(n, r));

    n = 10;
    r = 5;
    console.log(calculateCoefficient(n, r));

    n = 778;
    r = 116;
    console.log(calculateCoefficient(n, r));
};

main();