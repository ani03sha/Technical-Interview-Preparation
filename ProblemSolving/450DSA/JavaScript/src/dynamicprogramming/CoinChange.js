/**
 * @author Anirudh Sharma
 * 
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 * 
 * Note:
 * 
 * You can assume that
 * 
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 */
const change = (amount, coins) => {
    // DP array to store the amount i.e.
    // dp[i] suggests that number of ways
    // i amount can be made from coins
    const dp = new Array(amount + 1);
    dp.fill(0);
    // For 0 amount, there's only one way,
    // i.e. don't choose anything
    dp[0] = 1;
    // Loop for all the coins
    coins.forEach(c => {
        for (let i = c; i <= amount; i++) {
            dp[i] += dp[i - c];
        }
    });
    return dp[amount];
};

const main = () => {
    let amount = 5;
    let coins = [1, 2, 5];
    console.log(change(amount, coins));

    amount = 3;
    coins = [2];
    console.log(change(amount, coins));

    amount = 10;
    coins = [10];
    console.log(change(amount, coins));
};

main();