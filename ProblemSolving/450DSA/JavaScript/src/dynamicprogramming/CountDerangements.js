/**
 * @author Anirudh Sharma
 * 
 * A Derangement is a permutation of n elements, such that no element appears in its original position.
 * For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}.
 * 
 * Given a number n, find the total number of Derangements of a set of n elements.
 */
const count = (n) => {
    // Lookup table to store derangements for
    // a particular value of n
    const lookup = new Array(n + 1).fill(0);
    // Base initialization
    lookup[1] = 0;
    lookup[2] = 1;
    // Populate for remaining places
    for (let i = 3; i <= n; i++) {
        lookup[i] = (i - 1) * (lookup[i - 1] + lookup[i - 2]);
    }
    return lookup[n];
};

const main = () => {
    console.log(count(3));
    console.log(count(4));
};

main();