/**
 * @author Anirudh Sharma
 * 
 * Given a boolean expression S of length N with following symbols.
 * Symbols
 * 'T' ---> true
 * 'F' ---> false
 * and following operators filled between symbols
 * Operators
 * &   ---> boolean AND
 * |   ---> boolean OR
 * ^   ---> boolean XOR
 * 
 * Count the number of ways we can parenthesize the expression so that the value of expression
 * evaluates to true.
 */
const countWays = (s) => {
    // Special case
    if (s === undefined || s.length === 0) {
        return 0;
    }
    // Total number of symbols
    const n = parseInt(s.length / 2) + 1;
    // Divide the string into characters of
    // symbols and operators
    const symbols = new Array(n);
    const operators = new Array(n);
    // Populate these arrays from the input string
    let index = 0;
    for (let i = 0; i < s.length - 1; i = i + 2) {
        symbols[index] = s.charAt(i);
        operators[index] = s.charAt(i + 1);
        index++;
    }
    symbols[index] = s.charAt(s.length - 1);
    // Lookup table for making true
    const trueLookup = Array.from(Array(n), () => Array(n).fill(0));
    // Lookup table for making false
    const falseLookup = Array.from(Array(n), () => Array(n).fill(0));
    // Populate the table diagonally
    for (let gap = 0; gap < n; gap++) {
        for (let i = 0, j = gap; j < n; i++, j++) {
            // For the zero gap
            if (gap === 0) {
                if (symbols[i] === 'T') {
                    trueLookup[i][j] = 1;
                } else {
                    falseLookup[i][j] = 1;
                }
            }
            // For gap greater than one
            else {
                for (let k = i; k < j; k++) {
                    let operator = operators[k];
                    // Get different counts for left and
                    // right expressions for both true and false
                    let leftTrueCount = trueLookup[i][k];
                    let rightTrueCount = trueLookup[k + 1][j];
                    let leftFalseCount = falseLookup[i][k];
                    let rightFalseCount = falseLookup[k + 1][j];
                    // Solve for different operators
                    // For logical AND operator
                    if (operator === '&') {
                        trueLookup[i][j] += leftTrueCount * rightTrueCount;
                        falseLookup[i][j] += leftTrueCount * rightFalseCount
                            + leftFalseCount * rightTrueCount
                            + leftFalseCount * rightFalseCount;
                    }
                    // For logical OR operator
                    else if (operator === '|') {
                        trueLookup[i][j] += leftTrueCount * rightTrueCount + leftFalseCount * rightTrueCount + leftTrueCount * rightFalseCount;
                        falseLookup[i][j] += leftFalseCount * rightFalseCount;
                    }
                    // For logical XOR operator
                    else {
                        trueLookup[i][j] += leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount;
                        falseLookup[i][j] += leftFalseCount * rightFalseCount + leftTrueCount * rightTrueCount;
                    }
                }
            }
        }
    }
    return trueLookup[0][n - 1];
};

const main = () => {
    let S = "T|T&F^T";
    console.log(countWays(S));

    S = "T^F|F";
    console.log(countWays(S));
};

main();