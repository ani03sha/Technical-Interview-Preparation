/**
 * @author Anirudh Sharma
 * 
 * Consider a game where a player can score 3 or 5 or 10 points in a move.
 * Given a total score n, find number of distinct combinations to reach the given score.
 */
const countCombinations = (n) => {
    // Create an array to store the possible score
    const scores = [3, 5, 10];
    // Lookup table to store the intermediate results
    const lookup = new Array(n + 1).fill(0);
    // Base initialization - 0 can be made with one combination
    // where we don't select anything
    lookup[0] = 1;
    // Populate the remaining table
    for (let score of scores) {
        for (let i = score; i <= n; i++) {
            lookup[i] += lookup[i - score];
        }
    }
    return lookup[n];
};

const main = () => {
    console.log(countCombinations(8));
    console.log(countCombinations(20));
    console.log(countCombinations(13));
};

main();