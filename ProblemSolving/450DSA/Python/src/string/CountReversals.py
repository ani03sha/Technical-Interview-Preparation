import math
"""
@author Anirudh Sharma

Given a string S consisting only of opening and closing curly brackets '{' and '}'
find out the minimum number of reversals required to make a balanced expression.

If it cannot be balanced, then print -1.
"""


def count(s):
    # Length of the string
    n = len(s)
    # If the length is odd then we cannot make
    # balanced expression
    if n % 2 == 1:
        return -1
    # Count of left and right braces
    leftBraceCount, rightBraceCount = 0, 0
    # Loop through the string
    for i in range(n):
        # Get current character
        c = s[i]
        if c == '{':
            leftBraceCount += 1
        else:
            if leftBraceCount == 0:
                rightBraceCount += 1
            else:
                leftBraceCount -= 1
    return math.ceil(leftBraceCount // 2) + math.ceil(rightBraceCount // 2)


if __name__ == "__main__":
    s = "}{{}}{{{"
    print(count(s))

    s = "{{}}}}"
    print(count(s))

    s = "{{}{{{}{{}}{{"
    print(count(s))

    s = "{{{{}}}}"
    print(count(s))
