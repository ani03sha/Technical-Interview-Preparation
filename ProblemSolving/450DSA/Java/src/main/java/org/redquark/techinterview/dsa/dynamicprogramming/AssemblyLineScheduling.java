package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * A car factory has two assembly lines, each with n stations. A station is denoted by Si,j where
 * i is either 1 or 2 and indicates the assembly line the station is on, and j indicates the number
 * of the station.
 * <p>
 * The time taken per station is denoted by ai,j. Each station is dedicated to some sort of work
 * like engine fitting, body fitting, painting, and so on. So, a car chassis must pass through
 * each of the n stations in order before exiting the factory.
 * <p>
 * The parallel stations of the two assembly lines perform the same task. After it passes through
 * station Si,j, it will continue to station Si,j+1 unless it decides to transfer to the other line.
 * <p>
 * Continuing on the same line incurs no extra cost, but transferring from line i at station j – 1
 * to station j on the other line takes time ti,j.
 * Each assembly line takes an entry time ei and exit time xi which may be different for the two lines.
 * <p>
 * Give an algorithm for computing the minimum time it will take to build a car chassis.
 */
public class AssemblyLineScheduling {

    private static int carAssembly(int[][] a, int[][] t, int[] e, int[] x) {
        // Total number of stations
        int n = a[0].length;
        // Lookup tables to store the minimum time to leave a
        // station on both lines. The lookup1[i]/lookup2[i]
        // represents the minimum time to leave from the i-th
        // station
        int[] lookup1 = new int[n];
        int[] lookup2 = new int[n];
        // Time taken to leave the first station on both the lines
        lookup1[0] = e[0] + a[0][0];
        lookup2[0] = e[1] + a[1][0];
        // Populate both the tables
        for (int i = 1; i < n; i++) {
            lookup1[i] = Math.min(lookup1[i - 1] + a[0][i], lookup2[i - 1] + t[1][i] + a[0][i]);
            lookup2[i] = Math.min(lookup2[i - 1] + a[1][i], lookup1[i - 1] + t[0][i] + a[1][i]);
        }
        // Now we need to return the maximum values plus the exit time
        return Math.min(lookup1[n - 1] + x[0], lookup2[n - 1] + x[1]);
    }

    public static void main(String[] args) {
        int[][] a = {
                {4, 5, 3, 2},
                {2, 10, 1, 4}
        };
        int[][] t = {
                {0, 7, 4, 5},
                {0, 9, 2, 8}
        };
        int[] e = {10, 12};
        int[] x = {18, 7};
        System.out.println(carAssembly(a, t, e, x));
    }
}
