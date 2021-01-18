package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
public class BestTimeToBuyAndSellStocks {

    /**
     * @param prices array of stock prices
     * @return maximum profit
     */
    private static int maxProfit(int[] prices) {
        // Base condition
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // Minimum value of the stock
        int minimum = prices[0];
        // Maximum profit
        int maximumProfit = 0;
        // Loop for the remaining elements of the array
        for (int i = 1; i < prices.length; i++) {
            maximumProfit = Math.max(maximumProfit, prices[i] - minimum);
            minimum = Math.min(minimum, prices[i]);
        }
        return maximumProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
