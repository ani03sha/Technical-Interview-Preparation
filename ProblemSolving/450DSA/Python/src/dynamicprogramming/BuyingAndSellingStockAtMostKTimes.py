import sys

"""
@author Anirudh Sharma

In the stock market, a person buys a stock and sells it on some future date.
Given the stock prices of N days in an array prices[] and a positive integer K,
find out the maximum profit a person can make in at-most K transactions.

A transaction is equivalent to (buying + selling) of a stock and new transaction
can start only when the previous transaction has been completed.
"""


def maxProfit(prices, k):
    # Special case
    if prices is None or len(prices) == 0:
        return 0
    # Array for buying prices
    buyingPrices = [-sys.maxsize] * k
    # Array for selling prices
    sellingPrices = [0] * k
    # Calculate for every combination of stock prices
    for price in prices:
        # Buy first stock
        buyingPrices[0] = max(buyingPrices[0], -price)
        sellingPrices[0] = max(sellingPrices[0], buyingPrices[0] + price)
        # Buy remaining k - 1 stocks
        for j in range(1, k):
            buyingPrices[j] = max(
                buyingPrices[j], sellingPrices[j - 1] - price)
            sellingPrices[j] = max(sellingPrices[j], buyingPrices[j] + price)
    return sellingPrices[k - 1]


if __name__ == "__main__":
    prices = [10, 22, 5, 75, 65, 80]
    k = 2
    print(maxProfit(prices, k))

    prices = [20, 580, 420, 900]
    k = 3
    print(maxProfit(prices, k))

    prices = [100, 90, 80, 50, 25]
    k = 1
    print(maxProfit(prices, k))
