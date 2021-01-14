/**
 * @author Anirudh Sharma
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * 
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 */
const merge = (intervals) => {
    // Sort the intervals by their start value
    intervals = intervals.sort((a, b) => a[0] - b[0]);
    // List of merged intervals
    const mergedIntervals = [];
    // Current interval
    let currentInterval = intervals[0];
    // Add this interval to the list
    mergedIntervals.push(currentInterval);
    // Loop for each interval
    for (let i = 0; i < intervals.length; i++) {
        // Get the end of the current interval
        const currentEnd = currentInterval[1];
        // Get the beginning of the next interval
        const nextBegin = intervals[i][0];
        // Get the end of the next interval
        const nextEnd = intervals[i][1];
        // If the nextBegin is less than or equal to
        // the currentEnd, we should merge the intervals
        if (nextBegin <= currentEnd) {
            currentInterval[1] = Math.max(currentEnd, nextEnd);
        }
        // If not, then we will add the next interval in the list
        else {
            currentInterval = intervals[i];
            mergedIntervals.push(currentInterval);
        }
    }
    return mergedIntervals;
};

console.log(merge([[1, 3], [2, 6], [8, 10], [15, 18]]));
console.log(merge([[1, 4], [4, 5]]));