/**
 * @author Anirudh Sharma
 * 
 * Given an array of integers where each element represents the max number of steps that can
 * be made forward from that element.
 * 
 * Find the minimum number of jumps to reach the end of the array (starting from the first element).
 * 
 * If an element is 0, then you cannot move through that element.
 */
const minJumps = (a) => {
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

console.log(minJumps([1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]));
console.log(minJumps([1, 4, 3, 2, 6, 7]));
console.log(minJumps([2, 3, 1, 1, 2, 4, 2, 0, 1, 1]));