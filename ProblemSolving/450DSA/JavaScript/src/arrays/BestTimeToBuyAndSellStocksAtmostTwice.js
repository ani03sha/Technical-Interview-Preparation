/**
 * @author Anirudh Sharma
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 */
const findMaxProfit = (prices) => {
    // Buying price of first stock
    let firstBuyingPrice = Number.NEGATIVE_INFINITY;
    // Selling price of first stock
    let firstSellingPrice = 0;
    // Buying price of second stock
    let secondBuyingPrice = Number.NEGATIVE_INFINITY;
    // Selling price of second stock
    let secondSellingPrice = 0;
    // Loop for every price in the array
    prices.forEach(price => {
        firstBuyingPrice = Math.max(firstBuyingPrice, -price);
        firstSellingPrice = Math.max(firstSellingPrice, firstBuyingPrice + price);
        secondBuyingPrice = Math.max(secondBuyingPrice, firstSellingPrice - price);
        secondSellingPrice = Math.max(secondSellingPrice, secondBuyingPrice + price);
    });
    return secondSellingPrice;
};


let pricesArray = [3, 3, 5, 0, 0, 3, 1, 4];
console.log(findMaxProfit(pricesArray));

pricesArray = [1, 2, 3, 4, 5];
console.log(findMaxProfit(pricesArray));

pricesArray = [7, 6, 4, 3, 1];
console.log(findMaxProfit(pricesArray));

pricesArray = [1];
console.log(findMaxProfit(pricesArray));