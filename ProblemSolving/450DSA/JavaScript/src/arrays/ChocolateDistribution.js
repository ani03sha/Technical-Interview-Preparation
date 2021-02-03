/**
 * @author Anirudh Sharma
 * 
 * Given an array A of positive integers of size N, where each value represents number of chocolates in a packet.
 * Each packet can have variable number of chocolates.
 * 
 * There are M students, the task is to distribute chocolate packets such that :
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates given to the students having packet
 * with maximum chocolates and student having packet with minimum chocolates is minimum.
 * 
 * Constraints:
 * 1 <= N <= 10^7
 * 1 <= A[i] <= 10^18
 * 1 <= M <= N
 */
const distribute = (A, M) => {
    // Special case
    if (A === undefined || A.length < M) {
        return 0;
    }
    // Minimum difference between max and min chocolates
    let minimumDifference = Number.MAX_VALUE;
    // Sort the array
    A.sort((x, y) => x - y);
    // Loop through the array in the window of size M
    for (let i = 0; i + M - 1 < A.length; i++) {
        // Difference between current min and max
        let difference = A[i + M - 1] - A[i];
        minimumDifference = Math.min(difference, minimumDifference);
    }
    return minimumDifference;
};


let a = [7, 3, 2, 4, 9, 12, 56];
let m = 3;
console.log(distribute(a, m));

a = [3, 4, 1, 9, 56, 7, 9, 12];
m = 5;
console.log(distribute(a, m));

a = [12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50];
m = 7;
console.log(distribute(a, m));