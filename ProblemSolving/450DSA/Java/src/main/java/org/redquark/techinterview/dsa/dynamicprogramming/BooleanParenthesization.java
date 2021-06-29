package org.redquark.techinterview.dsa.dynamicprogramming;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a boolean expression S of length N with following symbols.
 * Symbols
 * 'T' ---> true
 * 'F' ---> false
 * and following operators filled between symbols
 * Operators
 * &   ---> boolean AND
 * |   ---> boolean OR
 * ^   ---> boolean XOR
 * <p>
 * Count the number of ways we can parenthesize the expression so that the value of expression
 * evaluates to true.
 */
public class BooleanParenthesization {

    private static int countWays(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // Total number of symbols
        int n = s.length() / 2 + 1;
        // Divide the string into characters of
        // symbols and operators
        char[] symbols = new char[n];
        char[] operators = new char[n - 1];
        // Populate these arrays from the input string
        int index = 0;
        for (int i = 0; i < s.length() - 1; i = i + 2) {
            symbols[index] = s.charAt(i);
            operators[index] = s.charAt(i + 1);
            index++;
        }
        symbols[index] = s.charAt(s.length() - 1);
        // Lookup table for making true
        int[][] trueLookup = new int[n][n];
        // Lookup table for making false
        int[][] falseLookup = new int[n][n];
        // Populate the table diagonally
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                // For the zero gap
                if (gap == 0) {
                    if (symbols[i] == 'T') {
                        trueLookup[i][j] = 1;
                    } else {
                        falseLookup[i][j] = 1;
                    }
                }
                // For gap greater than one
                else {
                    for (int k = i; k < j; k++) {
                        char operator = operators[k];
                        // Get different counts for left and
                        // right expressions for both true and false
                        int leftTrueCount = trueLookup[i][k];
                        int rightTrueCount = trueLookup[k + 1][j];
                        int leftFalseCount = falseLookup[i][k];
                        int rightFalseCount = falseLookup[k + 1][j];
                        // Solve for different operators
                        // For logical AND operator
                        if (operator == '&') {
                            trueLookup[i][j] += leftTrueCount * rightTrueCount;
                            falseLookup[i][j] += leftTrueCount * rightFalseCount
                                    + leftFalseCount * rightTrueCount
                                    + leftFalseCount * rightFalseCount;
                        }
                        // For logical OR operator
                        else if (operator == '|') {
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
    }

    public static void main(String[] args) {
        String S = "T|T&F^T";
        System.out.println(countWays(S));

        S = "T^F|F";
        System.out.println(countWays(S));
    }
}
