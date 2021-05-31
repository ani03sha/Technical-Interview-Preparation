/**
 * @author Anirudh Sharma
 * 
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
 * 
 * You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher
 * than f will break, and any egg dropped at or below floor f will not break.
 * 
 * Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n).
 * If the egg breaks, you can no longer use it.
 * 
 * However, if the egg does not break, you may reuse it in future moves.
 * 
 * Return the minimum number of moves that you need to determine with certainty what the value of f is.
 *
 * Constraints:
 *
 * 1 <= k <= 100
 * 1 <= n <= 10^4
 */
// Lookup table to store the minimum attempts
// needed to find critical floor with i eggs
// and j floors
const lookup = Array.from(Array(10001), () => Array(101));

const eggDrop = (k, n) => {
    // Some base cases
    // 1. If there is only one egg
    // 2. If there is only 0 or 1 floor
    if (k === 1 || n <= 1) {
        return n;
    }
    // 3. If we have already calculated the result
    // using memoization
    if (lookup[k][n] !== undefined) {
        return lookup[k][n];
    }
    // Minimum attempts needed to find critical floor
    let minimum = Number.MAX_VALUE;
    // Search for the critical floor using binary search
    // Left and right pointers
    let left = 1;
    let right = n;
    // Loop until the two pointers meet
    while (left <= right) {
        // Middle point
        let middle = left + parseInt((right - left) / 2);
        // If egg breaks, search below
        let below = eggDrop(k - 1, middle - 1);
        // If egg survives, search above
        let above = eggDrop(k, n - middle);
        // We need worst case from both attempts
        // 1 is added because we have tried once
        // for the middle floor
        let attempts = 1 + Math.max(below, above);
        // If below attempts are less, we need only above
        // attempts and vice-versa
        if (below < above) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
        // Minimum attempts for all worst cases
        minimum = Math.min(minimum, attempts);
    }
    lookup[k][n] = minimum;
    return lookup[k][n];
};

const main = () => {
    let k = 1;
    let n = 2;
    console.log(eggDrop(k, n));

    k = 2;
    n = 6;
    console.log(eggDrop(k, n));

    k = 3;
    n = 14;
    console.log(eggDrop(k, n));
};

main();