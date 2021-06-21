package org.redquark.techinterview.dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anirudh Sharma
 * <p>
 * Given N jobs where every job is represented by following three elements of it.
 * <p>
 * Start Time
 * Finish Time
 * Profit or Value Associated (>= 0)
 * Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 */
public class WeightedJobScheduling {

    private static int maxProfit(Job[] jobs) {
        // Sort the array in ascending order by finish time
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));
        // Lookup table to store the maximum profit
        int[] lookup = new int[jobs.length];
        // Base initialization
        lookup[0] = jobs[0].profit;
        // Populate the remaining table
        for (int i = 1; i < jobs.length; i++) {
            lookup[i] = Math.max(lookup[i - 1], jobs[i].profit);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j].endTime <= jobs[i].startTime) {
                    lookup[i] = Math.max(lookup[i], lookup[j] + jobs[i].profit);
                    break;
                }
            }
        }
        // Maximum profit
        int maxProfit = Integer.MIN_VALUE;
        for (int profit : lookup) {
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(3, 10, 20),
                new Job(1, 2, 50),
                new Job(6, 19, 100),
                new Job(2, 100, 200)
        };
        System.out.println(maxProfit(jobs));
    }

    static class Job {
        final int startTime;
        final int endTime;
        final int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
