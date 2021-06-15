/**
 * @author Anirudh Sharma
 * 
 * Given a set of N items, each with a weight and a value, and a weight limit W.
 * 
 * Find the maximum value of a collection containing any of the N items any number
 * of times so that the total weight is less than or equal to W.
 */
const unboundedKnapsack = (values, weights, W) => {
    // Special cases
    if (values === undefined || weights === undefined || values.length === 0 || weights.length === 0) {
        return 0;
    }
    // Lookup table to store the collection
    const lookup = new Array(W + 1).fill(0);
    // Populated lookup table
    for (let i = 0; i <= W; i++) {
        for (let j = 0; j < values.length; j++) {
            if (weights[j] <= i) {
                lookup[i] = Math.max(lookup[i], values[j] + lookup[i - weights[j]]);
            }
        }
    }
    return lookup[W];
};

const main = () => {
    let values = [1, 1];
    let weights = [2, 1];
    let W = 3;
    console.log(unboundedKnapsack(values, weights, W));

    values = [1, 4, 5, 7];
    weights = [1, 3, 4, 5];
    W = 8;
    console.log(unboundedKnapsack(values, weights, W));
};

main();