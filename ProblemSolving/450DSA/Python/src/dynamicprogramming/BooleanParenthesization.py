"""
@author Anirudh Sharma

Given a boolean expression S of length N with following symbols.
Symbols
'T' ---> true
'F' ---> false
and following operators filled between symbols
Operators
&   ---> boolean AND
|   ---> boolean OR
^   ---> boolean XOR

Count the number of ways we can parenthesize the expression so that the value of expression
evaluates to true.
"""


def countWays(s):
    # Special case
    if s is None or len(s) == 0:
        return 0
    # Total number of symbols
    n = len(s) // 2 + 1
    # Divide the string into characters of
    # symbols and operators
    symbols = [''] * n
    operators = [''] * (n - 1)
    # Populate these arrays from the input string
    index = 0
    for i in range(0, len(s) - 1, 2):
        symbols[index] = s[i]
        operators[index] = s[i + 1]
        index += 1
    symbols[index] = s[len(s) - 1]
    # Lookup table for making true
    trueLookup = [[0 for y in range(n)] for x in range(n)]
    # Lookup table for making false
    falseLookup = [[0 for y in range(n)] for x in range(n)]
    # Populate the table diagonally
    for gap in range(n):
        i = 0
        for j in range(gap, n):
            # For the zero gap
            if gap == 0:
                if symbols[i] == 'T':
                    trueLookup[i][j] = 1
                else:
                    falseLookup[i][j] = 1
            # For gap greater than one
            else:
                for k in range(i, j):
                    operator = operators[k]
                    # Get different counts for left and
                    # right expressions for both true and false
                    leftTrueCount = trueLookup[i][k]
                    rightTrueCount = trueLookup[k + 1][j]
                    leftFalseCount = falseLookup[i][k]
                    rightFalseCount = falseLookup[k + 1][j]
                    # Solve for different operators
                    # For logical AND operator
                    if operator == '&':
                        trueLookup[i][j] += leftTrueCount * rightTrueCount
                        falseLookup[i][j] += leftTrueCount * rightFalseCount + \
                            leftFalseCount * rightTrueCount + leftFalseCount * rightFalseCount
                    # For logical OR operator
                    elif operator == '|':
                        trueLookup[i][j] += leftTrueCount * rightTrueCount + \
                            leftFalseCount * rightTrueCount + leftTrueCount * rightFalseCount
                        falseLookup[i][j] += leftFalseCount * rightFalseCount
                    # For logical XOR operator
                    else:
                        trueLookup[i][j] += leftTrueCount * \
                            rightFalseCount + leftFalseCount * rightTrueCount
                        falseLookup[i][j] += leftFalseCount * \
                            rightFalseCount + leftTrueCount * rightTrueCount
            i += 1
    return trueLookup[0][n - 1]


if __name__ == "__main__":
    s = "T|T&F^T"
    print(countWays(s))

    s = "T^F|F"
    print(countWays(s))
