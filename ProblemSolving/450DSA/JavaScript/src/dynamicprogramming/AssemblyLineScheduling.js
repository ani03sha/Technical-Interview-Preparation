/**
 * @author Anirudh Sharma
 * 
 * A car factory has two assembly lines, each with n stations. A station is denoted by Si,j where
 * i is either 1 or 2 and indicates the assembly line the station is on, and j indicates the number
 * of the station.
 * 
 * The time taken per station is denoted by ai,j. Each station is dedicated to some sort of work
 * like engine fitting, body fitting, painting, and so on. So, a car chassis must pass through
 * each of the n stations in order before exiting the factory.
 * 
 * The parallel stations of the two assembly lines perform the same task. After it passes through
 * station Si,j, it will continue to station Si,j+1 unless it decides to transfer to the other line.
 * 
 * Continuing on the same line incurs no extra cost, but transferring from line i at station j – 1
 * to station j on the other line takes time ti,j.
 * Each assembly line takes an entry time ei and exit time xi which may be different for the two lines.
 * 
 * Give an algorithm for computing the minimum time it will take to build a car chassis.
 */
const carAssembly = (a, t, e, x) => {
    // Total number of stations
    const n = a[0].length;
    // Lookup tables to store the minimum time to leave a
    // station on both lines. The lookup1[i]/lookup2[i]
    // represents the minimum time to leave from the i-th
    // station
    const lookup1 = Array(n).fill(0);
    const lookup2 = Array(n).fill(0);
    // Time taken to leave the first station on both the lines
    lookup1[0] = e[0] + a[0][0];
    lookup2[0] = e[1] + a[1][0];
    // Populate both the tables
    for (let i = 1; i < n; i++) {
        lookup1[i] = Math.min(lookup1[i - 1] + a[0][i], lookup2[i - 1] + t[1][i] + a[0][i]);
        lookup2[i] = Math.min(lookup2[i - 1] + a[1][i], lookup1[i - 1] + t[0][i] + a[1][i]);
    }
    // Now we need to return the maximum values plus the exit time
    return Math.min(lookup1[n - 1] + x[0], lookup2[n - 1] + x[1]);
}

const main = () => {
    let a = [[4, 5, 3, 2], [2, 10, 1, 4]];
    let t = [[0, 7, 4, 5], [0, 9, 2, 8]];
    let e = [10, 12];
    let x = [18, 7];
    console.log(carAssembly(a, t, e, x));
};

main();