/**
 * @author Anirudh Sharma
 * 
 * You are given weights and values of N items, put these items in a knapsack of capacity W
 * to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
 * 
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent
 * values and weights associated with N items respectively. Also given an integer W
 * which represents knapsack capacity, find out the maximum value subset of val[]
 * such that sum of the weights of this subset is smaller than or equal to W.
 * 
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * 
 * Constraints:
 * 1 ≤ N ≤ 1000
 * 1 ≤ W ≤ 1000
 * 1 ≤ wt[i] ≤ 1000
 * 1 ≤ v[i] ≤ 1000
 */
const knapSack = (W, weights, values) => {
    // DP array to store the weight-values combination
    const dp = Array.from(Array(weights.length + 1), () => new Array(W + 1));
    // Loop for all the combinations
    for (let i = 0; i <= weights.length; i++) {
        for (let j = 0; j <= W; j++) {
            // For zero weight
            if (i === 0 || j === 0) {
                dp[i][j] = 0;
                continue;
            }
            // If the total weight is less than the
            // current weight we are considering
            // i.e W < weights[i]
            if (j < weights[i - 1]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
            }
        }
    }
    return dp[weights.length][W];
};

const main = () => {
    let weights = [4, 5, 1];
    let values = [1, 2, 3];
    let W = 4;
    console.log(knapSack(W, weights, values));

    weights = [4, 5, 6];
    values = [1, 2, 3];
    W = 3;
    console.log(knapSack(W, weights, values));
};

main();