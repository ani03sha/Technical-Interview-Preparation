/**
 * @author Anirudh Sharma
 * 
 * Given N jobs where every job is represented by following three elements of it.
 * 
 * Start Time
 * Finish Time
 * Profit or Value Associated (>= 0)
 * Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 */
const maxProfitInJobs = (jobs) => {
    // Length of the array
    const n = jobs.length;
    // Sort the array in ascending order by finish time
    jobs.sort((a, b) => (a.endTime < b.endTime) ? -1 : 1);
    // Lookup table to store the maximum profit
    const lookup = new Array(n).fill(0);
    // Base initialization
    lookup[0] = jobs[0].profit;
    // Populate the remaining table
    for (let i = 1; i < jobs.length; i++) {
        lookup[i] = Math.max(lookup[i - 1], jobs[i].profit);
        for (let j = i - 1; j >= 0; j--) {
            if (jobs[j].endTime <= jobs[i].startTime) {
                lookup[i] = Math.max(lookup[i], lookup[j] + jobs[i].profit);
                break;
            }
        }
    }
    // Maximum profit
    let maxProfit = Number.MIN_VALUE;
    for (let profit of lookup) {
        maxProfit = Math.max(maxProfit, profit);
    }
    return maxProfit;
};

function Job(startTime, endTime, profit) {
    this.startTime = (startTime === undefined ? 0 : startTime);
    this.endTime = (endTime === undefined ? 0 : endTime);
    this.profit = (profit === undefined ? null : profit);
}

const main = () => {
    const jobs = [
        new Job(3, 10, 20),
        new Job(1, 2, 50),
        new Job(6, 19, 100),
        new Job(2, 100, 200)
    ];
    console.log(maxProfitInJobs(jobs));
};

main();