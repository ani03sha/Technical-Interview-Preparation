/**
 * @author Anirudh Sharma
 * 
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
 * The problem is not actually to perform the multiplications, but merely to decide in which order
 * to perform the multiplications.
 */
const chainMultiplication = (orders) => {
    // Lookup table
    const lookup = Array.from(Array(orders.length), () => Array(orders.length).fill(-1));
    return chainMultiplicationHelper(orders, 1, orders.length - 1, lookup);
};

const chainMultiplicationHelper = (orders, i, j, lookup) => {
    // Base case
    if (i === j) {
        return 0;
    }
    // Check the cache
    if (lookup[i][j] !== -1) {
        return lookup[i][j];
    }
    // Minimum number of operations
    let minimumOperations = Number.MAX_VALUE;
    // Place parentheses at different positions between
    // first and last matrices and recursively calculate
    // the count of operations
    for (let k = i; k < j; k++) {
        let count = chainMultiplicationHelper(orders, i, k, lookup)
            + chainMultiplicationHelper(orders, k + 1, j, lookup)
            + orders[i - 1] * orders[k] * orders[j];
        minimumOperations = Math.min(minimumOperations, count);
    }
    return lookup[i][j] = minimumOperations;
};

const main = () => {
    let orders = [1, 2, 3, 4, 3];
    console.log(chainMultiplication(orders));

    orders = [10, 30, 5, 60];
    console.log(chainMultiplication(orders));
};

main();