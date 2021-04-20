/**
 * @author Anirudh Sharma
 * 
 * Given two strings s and t. Find the minimum number of operations that need to be performed
 * on s to convert it to t.
 * The possible operations are:
 * - Insert
 * - Remove
 * - Replace
 * 
 * Constraints:
 * 1 <= Length of both strings <= 100
 * Both the strings are in lowercase.
 */
const editDistance = (s, t) => {
    // Lengths for the strings
    const a = s.length;
    const b = t.length;
    // Lookup table for the memoization
    const lookup = [];
    for (var i = 0; i < a + 1; i++) {
        lookup[i] = [];
        for (var j = 0; j < b + 1; j++) {
            lookup[i][j] = -1;
        }
    }
    return editDistanceHelper(s, t, a, b, lookup);
};

const editDistanceHelper = (s, t, a, b, lookup) => {
    // If s is empty, then we need to insert
    // all the characters from t.
    if (a === 0) {
        return b;
    }
    // If t is empty, then we need to remove
    // all the characters from s.
    if (b === 0) {
        return a;
    }
    // If the entry is already in the lookup
    if (lookup[a][b] !== -1) {
        return lookup[a][b];
    }
    // Check if the last characters of both strings are
    // same, then we will recur for the remaining strings
    if (s.charAt(a - 1) === t.charAt(b - 1)) {
        return lookup[a][b] = editDistanceHelper(s, t, a - 1, b - 1);
    }
    // If the characters are different, then we will
    // check for all the combinations of both the
    // strings
    return lookup[a][b] = 1 + Math.min(editDistanceHelper(s, t, a, b - 1, lookup), 
                                Math.min(editDistanceHelper(s, t, a - 1, b, lookup),
                                    editDistanceHelper(s, t, a - 1, b - 1, lookup)));
};

const main = () => {
    let s = "abcdefmnopqr";
    let t = "ghijklstuvwx";
    console.log(editDistance(s, t));
};

main();