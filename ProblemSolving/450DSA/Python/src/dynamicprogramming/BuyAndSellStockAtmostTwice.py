import sys

"""
@author Anirudh Sharma

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the
stock before you buy again).
"""


def maxProfit(prices):
    # Special cases
    if prices is None or len(prices) == 0:
        return 0
    # First buying price
    firstBuyingPrice = -sys.maxsize
    # First selling price
    firstSellingPrice = 0
    # Second buying price
    secondBuyingPrice = -sys.maxsize
    # Second selling price
    secondSellingPrice = 0
    # Loop for every element in the array
    for price in prices:
        # If we are buying then we subtract the current
        # price value from 0 for the first transaction
        # because we have 0 profit before the first transaction
        firstBuyingPrice = max(firstBuyingPrice, -price)
        # Now we need to sell the stock and maximize the profit
        # And since we are selling, we will add the current price
        # to our profit
        firstSellingPrice = max(firstSellingPrice, firstBuyingPrice + price)
        # Now we have to buy the second stock and we have capital
        # equals to the firstSellingPrice and since we are buying,
        # we need to subtract the current price
        secondBuyingPrice = max(secondBuyingPrice, firstSellingPrice - price)
        # Second selling price will be the final output and since
        # we are selling, we will add the current price
        secondSellingPrice = max(secondSellingPrice, secondBuyingPrice + price)
    return secondSellingPrice


if __name__ == "__main__":
    prices = [3, 3, 5, 0, 0, 3, 1, 4]
    print(maxProfit(prices))

    prices = [1, 2, 3, 4, 5]
    print(maxProfit(prices))

    prices = [7, 6, 4, 3, 1]
    print(maxProfit(prices))

    prices = [1]
    print(maxProfit(prices))
