package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the
 * stock before you buy again).
 */
public class BuyAndSellStockAtmostTwice {

    private static int maxProfit(int[] prices) {
        // Special cases
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // First buying price
        int firstBuyingPrice = Integer.MIN_VALUE;
        // First selling price
        int firstSellingPrice = 0;
        // Second buying price
        int secondBuyingPrice = Integer.MIN_VALUE;
        // Second selling price
        int secondSellingPrice = 0;
        // Loop for every element in the array
        for (int price : prices) {
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
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));

        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));

        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));

        prices = new int[]{1};
        System.out.println(maxProfit(prices));
    }
}
