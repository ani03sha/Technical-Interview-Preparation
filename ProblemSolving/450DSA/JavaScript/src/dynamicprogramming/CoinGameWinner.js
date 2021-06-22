/**
 * @author Anirudh Sharma
 * A and B are playing a game. At the beginning there are n coins. Given two more numbers x and y.
 * In each move a player can pick x or y or 1 coins. A always starts the game.
 * The player who picks the last coin wins the game or the person who is not able to pick any
 * coin loses the game.
 * For a given value of n, find whether A will win the game or not if both are playing optimally.
 */
const findWinner = (x, y, n) => {
    // Lookup table to store the results for different
    // values of n
    const lookup = new Array(n + 1).fill(false);
    // Initial values
    // A cannot pick up any coin
    lookup[0] = false;
    // A can pick up the one and only coin
    lookup[1] = true;
    // Populate the remaining values
    for (let i = 2; i <= n; i++) {
        // If A loses any of i - 1 or i - x or i - y game,
        // then it will definitely win game i
        if (i - 1 >= 0 && !lookup[i - 1]) {
            lookup[i] = true;
        } else if (i - x >= 0 && !lookup[i - x]) {
            lookup[i - x] = true;
        } else if (i - y >= 0 && !lookup[i - y]) {
            lookup[i - y] = true;
        }
    }
    return lookup[n];
};

const main = () => {
    let n = 5;
    let x = 3;
    let y = 4;
    console.log(findWinner(x, y, n));

    n = 2;
    x = 3;
    y = 4;
    console.log(findWinner(x, y, n));
};

main();