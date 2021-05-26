/**
 * @author Anirudh Sharma
 * 
 * Given 3 strings A, B and C, the task is to find the longest common sub-sequence in all three given sequences.
 */
const lcsOfThreeStrings = (A, B, C) => {
    // Lengths of the strings
    const a = A.length;
    const b = B.length;
    const c = C.length;
    // Create a lookup table
    const lookup = new Array(a + 1);
    for (let i = 0; i <= a; i++) {
        lookup[i] = new Array(b + 1);
        for (let j = 0; j <= b; j++) {
            lookup[i][j] = new Array(c + 1);
            for (let k = 0; k <= c; k++) {
                lookup[i][j][k] = 0;
            }
        }
    }
    for (let i = 1; i <= a; i++) {
        for (let j = 1; j <= b; j++) {
            for (let k = 1; k <= c; k++) {
                if (A.charAt(i - 1) === B.charAt(j - 1)
                    && B.charAt(j - 1) === C.charAt(k - 1)) {
                    lookup[i][j][k] = 1 + lookup[i - 1][j - 1][k - 1];
                } else {
                    lookup[i][j][k] = Math.max(lookup[i - 1][j][k],
                                Math.max(lookup[i][j - 1][k], lookup[i][j][k - 1]));
                }
            }
        }
    }
    return lookup[a][b][c];
};

const main = () => {
    let A = "geeks";
    let B = "geeksfor";
    let C = "geeksforgeeks";
    console.log(lcsOfThreeStrings(A, B, C));

    A = "abcd";
    B = "efgh";
    C = "ijkl";
    console.log(lcsOfThreeStrings(A, B, C));
};

main();