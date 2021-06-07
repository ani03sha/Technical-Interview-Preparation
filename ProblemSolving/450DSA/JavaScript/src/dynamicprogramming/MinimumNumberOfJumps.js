/**
 * @author Anirudh Sharma
 * 
 * Given an array of non-negative integers nums, you are initially positioned at the first
 * index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 */
const jump = (a) => {
    // Current position
    let currentPosition = 0;
    // Destination reached from an index
    let destination = 0;
    // Number of jumps required
    let jumps = 0;
    // Loop for the elements of the array
    for (let i = 0; i < a.length - 1; i++) {
        // Destination index will be maximum of the current position
        // and the index that can be reached after jumping
        destination = Math.max(destination, i + a[i]);
        // If we need to take jump
        if (currentPosition == i) {
            currentPosition = destination;
            jumps++;
        }
    }
    return jumps;
};

const main = () => {
    let a = [2, 3, 1, 1, 4];
    console.log(jump(a));

    a = [2, 3, 0, 1, 4];
    console.log(jump(a));
};

main();