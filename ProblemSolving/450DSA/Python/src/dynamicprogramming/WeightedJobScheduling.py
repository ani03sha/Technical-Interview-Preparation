import sys

"""
@author Anirudh Sharma

Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated (>= 0)
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
"""


def maxProfitInJobs(jobs):
    # Length of the array
    n = len(jobs)
    # Sort the array in ascending order by finish time
    sortedJobs = sorted(jobs, key=lambda x: x.endTime)
    # Lookup table to store the maximum profit
    lookup = [0] * n
    # Base initialization
    lookup[0] = sortedJobs[0].profit
    # Populate the remaining table
    for i in range(1, n):
        lookup[i] = max(lookup[i - 1], sortedJobs[i].profit)
        for j in range(i - 1, -1, -1):
            if sortedJobs[j].endTime <= sortedJobs[i].startTime:
                lookup[i] = max(lookup[i], lookup[j] + sortedJobs[i].profit)
                break
    # Maximum profit
    maxProfit = -sys.maxsize
    for profit in lookup:
        maxProfit = max(maxProfit, profit)
    return maxProfit


class Job:
    def __init__(self, startTime, endTime, profit):
        self.startTime = startTime
        self.endTime = endTime
        self.profit = profit


if __name__ == "__main__":
    jobs = [
        Job(3, 10, 20),
        Job(1, 2, 50),
        Job(6, 19, 100),
        Job(2, 100, 200)
    ]
    print(maxProfitInJobs(jobs))
