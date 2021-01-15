"""
@author Anirudh Sharma

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
 
Constraints:
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
"""
from typing import List


def merge(intervals: List[List[int]]) -> List[List[int]]:
    # Sort the intervals by the start values
    intervals.sort(key=lambda x: x[0])
    # List of the merged intervals
    mergedIntervals = []
    # Current interval
    currentInterval = intervals[0]
    # Add the current intervals to the list of merged intervals
    mergedIntervals.append(currentInterval)
    # Loop for each interval
    for interval in intervals:
        # If there is overlap, we will merge the intervals
        if mergedIntervals and mergedIntervals[-1][1] >= interval[0]:
            mergedIntervals[-1][1] = max(mergedIntervals[-1][1], interval[1])
        # # If no overlapping, simply append it
        else:
            mergedIntervals.append(interval)
    return mergedIntervals


if __name__ == "__main__":
    print(merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
    print(merge([[1, 4], [4, 5]]))
