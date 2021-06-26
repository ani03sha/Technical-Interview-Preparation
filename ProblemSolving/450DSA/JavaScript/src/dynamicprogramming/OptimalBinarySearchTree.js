/**
 * @author Anirudh Sharma
 * 
 * Given a sorted array key [0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts,
 * where freq[i] is the number of searches for keys[i].
 * 
 * Construct a binary search tree of all keys such that the total cost of all the searches is as small
 * as possible.
 * 
 * The cost of a BST node is the level of that node multiplied by its frequency. The level of the root is 1.
 */
const optimalCost = (keys, frequencies) => {
    // Base case
    if (keys === undefined || keys.length === 0) {
        return 0;
    }
    // Total number of keys/nodes in BST
    const n = keys.length;
    // Lookup table to store optimal costs
    const lookup = Array.from(Array(n + 1), () => Array(n + 1).fill(0));
    // For single keys
    for (let i = 0; i < n; i++) {
        lookup[i][i] = keys[i];
    }
    // Populate the table
    for (let level = 1; level <= n; level++) {
        for (let i = 0; i <= n - level + 1; i++) {
            let j = level + i - 1;
            lookup[i][j] = Number.MAX_VALUE;
            for (let k = i; k <= j; k++) {
                let x = getSum(frequencies, i, j) + (k > i ? lookup[i][k - 1] : 0) + (k < j ? lookup[k + 1][j] : 0);
                if (x < lookup[i][j]) {
                    lookup[i][j] = x;
                }
            }
        }
    }
    return lookup[0][n - 1];
};

const getSum = (frequencies, i, j) => {
    let sum = 0;
    for (let k = i; k <= j; k++) {
        if (k >= frequencies.length) {
            continue;
        }
        sum += frequencies[k];
    }
    return sum;
};

const main = () => {
    let keys = [10, 12, 20];
    let frequencies = [34, 8, 50];
    console.log(optimalCost(keys, frequencies));
};

main();