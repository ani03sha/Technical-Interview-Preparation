/**
 * @author Anirudh Sharma
 * 
 * Given an array of N integers, and an integer K,
 * find the number of pairs of elements in the array whose sum is equal to K.
 * 
 * Constraints:
 * 1 <= N <= 10^5
 * 1 <= K <= 10^8
 * 1 <= a[i] <= 10^6
 */
const getPairsCount = (a, K) => {
    // Count of pairs
    let count = 0;
    // Map to store the frequencies of each element in the array
    const frequencies = new Map();
    // Loop for all the elements in the array
    for (let i = 0; i < a.length; i++) {
        if (frequencies.has(a[i])) {
            const frequency = frequencies.get(a[i]);
            frequencies.set(a[i], frequency + 1);
        } else {
            frequencies.set(a[i], 1);
        }
    }
    // Traverse the array again to find the pairs
    for (let i = 0; i < a.length; i++) {
        if (frequencies.has(K - a[i])) {
            count += frequencies.get(K - a[i]);
        }
        // For same elements
        if (K - a[i] == a[i]) {
            count--;
        }
    }
    return parseInt(count / 2);
};


console.log(getPairsCount([1, 5, 7, 1], 6));
console.log(getPairsCount([1, 1, 1, 1], 2));