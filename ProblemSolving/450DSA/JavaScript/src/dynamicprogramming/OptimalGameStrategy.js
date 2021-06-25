/**
 * @author Anirudh Sharma
 * 
 * You are given an array A of size N. The array contains integers and is of even length.
 * The elements of the array represent N coin of values V1, V2, ....Vn.
 * You play against an opponent in an alternating way.
 * 
 * In each turn, a player selects either the first or last coin from the row, removes it from
 * the row permanently, and receives the value of the coin.
 * 
 * You need to determine the maximum possible amount of money you can win if you go first.
 * Note: Both the players are playing optimally.
 */
const countMaximum = (nums) => {
    // Special case
    if (nums == undefined || nums.length === 0) {
        return 0;
    }
    // Length of the array
    const n = nums.length;
    // Lookup table to store the maximum value between
    // certain indices
    const lookup = Array.from(Array(n), () => Array(n).fill(0));
    for (let gap = 0; gap < n; gap++) {
        for (let i = 0, j = gap; j < n; i++, j++) {
            if (gap == 0) {
                lookup[i][j] = nums[i];
            } else if (gap == 1) {
                lookup[i][j] = Math.max(nums[i], nums[j]);
            } else {
                lookup[i][j] = Math.max(nums[i] + Math.min(lookup[i + 2][j], lookup[i + 1][j - 1]),
                    nums[j] + Math.min(lookup[i + 1][j - 1], lookup[i][j - 2]));
            }
        }
    }
    return lookup[0][n - 1];
};


const main = () => {
    let nums = [5, 3, 7, 10];
    console.log(countMaximum(nums));

    nums = [8, 15, 3, 7];
    console.log(countMaximum(nums));
};

main();