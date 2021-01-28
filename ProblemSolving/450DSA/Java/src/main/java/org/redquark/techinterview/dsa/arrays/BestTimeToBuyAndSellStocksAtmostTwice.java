package org.redquark.techinterview.dsa.arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 */
public class BestTimeToBuyAndSellStocksAtmostTwice {

    private static int findMaxProfit(int[] prices) {
        // Buying price of first stock
        int firstBuyingPrice = Integer.MIN_VALUE;
        // Selling price of first stock
        int firstSellingPrice = 0;
        // Buying price of second stock
        int secondBuyingPrice = Integer.MIN_VALUE;
        // Selling price of second stock
        int secondSellingPrice = 0;
        // Loop for every price in the array
        for (int price : prices) {
            firstBuyingPrice = Math.max(firstBuyingPrice, -price);
            firstSellingPrice = Math.max(firstSellingPrice, firstBuyingPrice + price);
            secondBuyingPrice = Math.max(secondBuyingPrice, firstSellingPrice - price);
            secondSellingPrice = Math.max(secondSellingPrice, secondBuyingPrice + price);
        }
        return secondSellingPrice;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(findMaxProfit(prices));

        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(findMaxProfit(prices));

        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(findMaxProfit(prices));

        prices = new int[]{1};
        System.out.println(findMaxProfit(prices));
    }
}
