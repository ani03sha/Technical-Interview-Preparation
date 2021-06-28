/**
 * @author Anirudh Sharma
 * 
 * Given the mobile numeric keypad. You can only press buttons that are up, left, right, or down to
 * the current button.
 * You are not allowed to press bottom row corner buttons (i.e. * and # ).
 * Given a number N, the task is to find out the number of possible numbers of the given length.
 */
const getCount = (N) => {
    // Array to store the allowed keys which can
    // be pressed before a certain key
    const allowedKeys = [
        [0, 8],
        [1, 2, 4],
        [1, 2, 3, 5],
        [2, 3, 6],
        [1, 4, 5, 7],
        [2, 4, 5, 6, 8],
        [3, 5, 6, 9],
        [4, 7, 8],
        [5, 7, 8, 9, 0],
        [6, 8, 9]
    ];
    // Lookup table to store the total number of
    // combinations where i represents the total
    // number of pressed keys and j represents the
    // actual keys present
    const lookup = Array.from(Array(N + 1), () => Array(10).fill(0));
    // Populate the table
    for (let i = 1; i <= N; i++) {
        for (let j = 0; j < 10; j++) {
            if (i === 1) {
                lookup[i][j] = 1;
            } else {
                // Loop for all the allowed previous keys
                for (let previous of allowedKeys[j]) {
                    lookup[i][j] += lookup[i - 1][previous];
                }
            }
        }
    }
    // Total sum
    let sum = 0;
    for (let value of lookup[N]) {
        sum += value;
    }
    return sum;
};

const main = () => {
    console.log(getCount(1));
    console.log(getCount(2));
    console.log(getCount(3));
    console.log(getCount(4));
    console.log(getCount(5));
    console.log(getCount(16));
};

main();