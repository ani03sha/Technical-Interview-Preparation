/**
 * @author Anirudh Sharma
 * 
 * In the stock market, a person buys a stock and sells it on some future date.
 * Given the stock prices of N days in an array prices[] and a positive integer K,
 * find out the maximum profit a person can make in at-most K transactions.
 * 
 * A transaction is equivalent to (buying + selling) of a stock and new transaction
 * can start only when the previous transaction has been completed.
 */
const maxProfit = (prices, k) => {
    // Special case
    if (prices === undefined || prices.length < 2 || k < 1) {
        return 0;
    }
    // Array for buying prices
    const buyingPrices = new Array(k).fill(Number.NEGATIVE_INFINITY);
    // Array for selling prices
    const sellingPrices = new Array(k).fill(0);
    // Calculate for every combination of stock prices
    for (let price of prices) {
        // Buy first stock
        buyingPrices[0] = Math.max(buyingPrices[0], -price);
        sellingPrices[0] = Math.max(sellingPrices[0], buyingPrices[0] + price);
        // Buy remaining k - 1 stocks
        for (let j = 1; j < k; j++) {
            buyingPrices[j] = Math.max(buyingPrices[j], sellingPrices[j - 1] - price);
            sellingPrices[j] = Math.max(sellingPrices[j], buyingPrices[j] + price);
        }
    }
    return sellingPrices[k - 1];
};

const main = () => {
    let prices = [10, 22, 5, 75, 65, 80];
    let k = 2;
    console.log(maxProfit(prices, k));

    prices = [20, 580, 420, 900];
    k = 3;
    console.log(maxProfit(prices, k));

    prices = [100, 90, 80, 50, 25];
    k = 1;
    console.log(maxProfit(prices, k));
};

main();