/**
 * @author Anirudh Sharma
 * 
 * Given an array cost[] of positive integers of size N and an integer W, cost[i] represents
 * the cost of ‘i’ kg packet of oranges, the task is to find the minimum cost to buy W kgs of oranges.
 * 
 * If it is not possible to buy exactly W kg oranges then the output will be -1
 * 
 * Note:
 * 1. cost[i] = -1 means that ‘i’ kg packet of orange is unavailable
 * 2. It may be assumed that there is infinite supply of all available packet types.
 */
const minimumCost = (cost, W) => {
    // Special case
    if (cost === undefined || cost.length === 0) {
        return -1;
    }
    // Length of the cost array
    const N = cost.length;
    // Lookup table to store minimum cost
    const lookup = new Array(W + 1);
    // Fill the array with default values
    lookup.fill(Number.MAX_VALUE);
    // Base initialization
    lookup[0] = 0;
    // Populate the table
    for (let i = 1; i <= W; i++) {
        for (let j = 0; j < i; j++) {
            if (j < N && cost[j] != -1) {
                let difference = lookup[i - j - 1];
                if (difference !== Number.MAX_VALUE) {
                    lookup[i] = Math.min(lookup[i], difference + cost[j]);
                }
            }
        }
    }
    return lookup[W] == Number.MAX_VALUE ? -1 : lookup[W];
};

const main = () => {
    let cost = [20, 10, 4, 50, 100];
    let W = 5;
    console.log(minimumCost(cost, W));

    cost = [-1, -1, 4, 3, -1];
    W = 5;
    console.log(minimumCost(cost, W));
};

main();