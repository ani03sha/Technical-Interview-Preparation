/**
 * @author Anirudh Sharma
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the
 * stock before you buy again).
 */
const maxProfit = (prices) => {
    // Special cases
    if (prices === undefined || prices.length < 2) {
        return 0;
    }
    // First buying price
    let firstBuyingPrice = Number.NEGATIVE_INFINITY;
    // First selling price
    let firstSellingPrice = 0;
    // Second buying price
    let secondBuyingPrice = Number.NEGATIVE_INFINITY;
    // Second selling price
    let secondSellingPrice = 0;
    // Loop for every element in the array
    for (let price of prices) {
        // If we are buying then we subtract the current
        // price value from 0 for the first transaction
        // because we have 0 profit before the first transaction
        firstBuyingPrice = Math.max(firstBuyingPrice, -price);
        // Now we need to sell the stock and maximize the profit
        // And since we are selling, we will add the current price
        // to our profit
        firstSellingPrice = Math.max(firstSellingPrice, firstBuyingPrice + price);
        // Now we have to buy the second stock and we have capital
        // equals to the firstSellingPrice and since we are buying,
        // we need to subtract the current price
        secondBuyingPrice = Math.max(secondBuyingPrice, firstSellingPrice - price);
        // Second selling price will be the final output and since
        // we are selling, we will add the current price
        secondSellingPrice = Math.max(secondSellingPrice, secondBuyingPrice + price);
    }
    return secondSellingPrice;
};

const main = () => {
    let prices = [3, 3, 5, 0, 0, 3, 1, 4];
    console.log(maxProfit(prices));

    prices = [1, 2, 3, 4, 5];
    console.log(maxProfit(prices));

    prices = [7, 6, 4, 3, 1];
    console.log(maxProfit(prices));

    prices = [1];
    console.log(maxProfit(prices));
};

main();