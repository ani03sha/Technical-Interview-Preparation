/**
 * @author Anirudh Sharma
 * 
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which
 * is the amount of gold in tons. Initially the miner is at first column but can be at any row.
 * 
 * He can move only (right->,right up /,right down\) that is from a given cell, the miner can
 * move to the cell diagonally up towards the right or right or diagonally down towards the right.
 * 
 * Find out maximum amount of gold he can collect.
 */
const calculateMaxGold = (mine) => {
    // Special case
    if (mine === null || mine.length === 0) {
        return 0;
    }
    // Rows and columns of the mine
    const m = mine.length;
    const n = mine[0].length;
    // Lookup table to store the maximum gold until a cell
    const lookup = Array.from(Array(m), () => Array(n).fill(0));
    // Start populating the table from the right or last column
    // Populate for remaining cells
    for (let i = 0; i < m; i++) {
        for (let j = n - 1; j >= 0; j--) {
            // If we go to the right
            let right = j === n - 1 ? 0 : lookup[i][j + 1];
            // Going right up
            let rightUp = (i === 0 || j === n - 1) ? 0 : lookup[i - 1][j + 1];
            // Going right down
            let rightDown = (i === m - 1 || j === n - 1) ? 0 : lookup[i + 1][j + 1];
            // Select the max of above three and add it to the
            // gold in the current cell
            lookup[i][j] = mine[i][j] + Math.max(right, Math.max(rightUp, rightDown));
        }
    }
    // Now the maximum amount of gold collected will be the maximum
    // value in the first column
    let maxGoldCollected = 0;
    for (let i = 0; i < m; i++) {
        maxGoldCollected = Math.max(maxGoldCollected, lookup[i][0]);
    }
    return maxGoldCollected;
};

const main = () => {
    let mine = [
        [1, 3, 1, 5],
        [2, 2, 4, 1],
        [5, 0, 2, 3],
        [0, 6, 1, 2]
    ];
    console.log(calculateMaxGold(mine));
};

main();