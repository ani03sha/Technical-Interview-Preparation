package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 * <p>
 * In the stock market, a person buys a stock and sells it on some future date.
 * Given the stock prices of N days in an array prices[] and a positive integer K,
 * find out the maximum profit a person can make in at-most K transactions.
 * <p>
 * A transaction is equivalent to (buying + selling) of a stock and new transaction
 * can start only when the previous transaction has been completed.
 */
public class BuyingAndSellingStockAtMostKTimes {

    private static int maxProfit(int[] prices, int k) {
        // Special case
        if (prices == null || prices.length < 2 || k < 1) {
            return 0;
        }
        // Array for buying prices
        int[] buyingPrices = new int[k];
        // Fill the buying prices
        Arrays.fill(buyingPrices, Integer.MIN_VALUE);
        // Array for selling prices
        int[] sellingPrices = new int[k];
        // Calculate for every combination of stock prices
        for (int price : prices) {
            // Buy first stock
            buyingPrices[0] = Math.max(buyingPrices[0], -price);
            sellingPrices[0] = Math.max(sellingPrices[0], buyingPrices[0] + price);
            // Buy remaining k - 1 stocks
            for (int j = 1; j < k; j++) {
                buyingPrices[j] = Math.max(buyingPrices[j], sellingPrices[j - 1] - price);
                sellingPrices[j] = Math.max(sellingPrices[j], buyingPrices[j] + price);
            }
        }
        return sellingPrices[k - 1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{10, 22, 5, 75, 65, 80};
        int k = 2;
        System.out.println(maxProfit(prices, k));

        prices = new int[]{20, 580, 420, 900};
        k = 3;
        System.out.println(maxProfit(prices, k));

        prices = new int[]{100, 90, 80, 50, 25};
        k = 1;
        System.out.println(maxProfit(prices, k));
    }
}
