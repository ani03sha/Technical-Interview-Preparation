/**
 * @author Anirudh Sharma
 * <p>
 * Find n-th catalan number
 */
const findCatalan = (n) => {
    // Lookup table
    const lookup = Array(n + 1).fill(-1);
    return findCatalanHelper(n, lookup);
};

const findCatalanHelper = (n, lookup) => {
    // Base case
    if (n <= 1) {
        return 1;
    }
    // Check if the value is cached in the lookup table
    if (lookup[n] !== -1) {
        return lookup[n];
    }
    // Variable to store result
    let result = 0;
    for (let i = 0; i < n; i++) {
        result += findCatalanHelper(i, lookup) * findCatalanHelper(n - i - 1, lookup);
    }
    // Cache value
    return lookup[n] = result;
};

const main = () => {
    console.log(findCatalan(8));
    console.log(findCatalan(14));
    console.log(findCatalan(21));
};

main();