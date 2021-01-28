"""
@author Anirudh Sharma

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time
(i.e., you must sell the stock before you buy again).

Constraints:

1 <= prices.length <= 10^5
0 <= prices[i] <= 10^5
"""


def findMaxProfit(prices):
    # Buying price of first stock
    firstBuyingPrice = float("-inf")
    # Selling price of first stock
    firstSellingPrice = 0
    # Buying price of second stock
    secondBuyingPrice = float("-inf")
    # Selling price of second stock
    secondSellingPrice = 0
    # Loop for every price
    for price in prices:
        firstBuyingPrice = max(firstBuyingPrice, -price)
        firstSellingPrice = max(firstSellingPrice, firstBuyingPrice + price)
        secondBuyingPrice = max(secondBuyingPrice, firstSellingPrice - price)
        secondSellingPrice = max(secondSellingPrice, secondBuyingPrice + price)
    return secondSellingPrice


if __name__ == "__main__":
    prices = [3, 3, 5, 0, 0, 3, 1, 4]
    print(findMaxProfit(prices))

    prices = [1, 2, 3, 4, 5]
    print(findMaxProfit(prices))

    prices = [7, 6, 4, 3, 1]
    print(findMaxProfit(prices))

    prices = [1]
    print(findMaxProfit(prices))
