/**
 * @author Anirudh Sharma
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
const maxProfit = (prices) => {
    // Base condition
    if (prices === undefined || prices.length < 2) {
        return 0;
    }
    // Minimum value of the stock
    let minimum = prices[0];
    // Maximum profit
    let maximumProfit = 0;
    // Loop for the remaining elements
    for (let i = 1; i < prices.length; i++) {
        maximumProfit = Math.max(maximumProfit, prices[i] - minimum);
        minimum = Math.min(minimum, prices[i]);
    }
    return maximumProfit;
};


console.log(maxProfit([7, 1, 5, 3, 6, 4]));
console.log(maxProfit([7, 6, 4, 3, 1]));