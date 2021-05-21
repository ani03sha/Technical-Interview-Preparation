/**
 * @author Anirudh Sharma
 * 
 * Given an integer N denoting the Length of a line segment.
 * You need to cut the line segment in such a way that the cut
 * length of a line segment each time is either x , y or z.
 * Here x, y, and z are integers.
 * 
 * After performing all the cut operations, your total number of cut segments must be maximum.
 */
const maximizeCuts = (n, x, y, z) => {
    // Base case
    if (n <= 0) {
        return 0;
    }
    // Lookup table to store maximum cuts required
    // to cut a rod of certain length
    const lookup = Array(n + 1).fill(-1);
    // Store the cuts in an array
    const cuts = [x, y, z];
    // Since we don't need any cut for 0 length
    lookup[0] = 0;
    // Populate the table for remaining lengths
    for (let i = 1; i <= n; i++) {
        for (let cut of cuts) {
            if (cut <= i && lookup[i - cut] !== -1) {
                lookup[i] = Math.max(lookup[i], 1 + lookup[i - cut]);
            }
        }
    }
    return Math.max(lookup[n], 0);
};

const main = () => {
    let n = 4;
    let x = 2;
    let y = 1;
    let z = 1;
    console.log(maximizeCuts(n, x, y, z));

    n = 5;
    x = 5;
    y = 3;
    z = 2;
    console.log(maximizeCuts(n, x, y, z));
};

main();