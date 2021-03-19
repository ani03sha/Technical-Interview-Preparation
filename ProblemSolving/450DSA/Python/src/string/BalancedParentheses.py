"""
@author Anirudh Sharma

Given an expression string x. Examine whether the pairs and the orders of "{","}","(",")","[","]"
are correct in exp.

For example, the function should return 'true' for exp = "[()]{}{[()()]()}" and 'false' for exp = "[(])".

Constraints:
1 ≤ |x| ≤ 32000

Note: The drive code prints "balanced" if function return true, otherwise it prints "not balanced".
"""


def isValidParentheses(s):
    # Stack for left symbols
    openParentheses = []
    # Loop for each character of the string
    for c in s:
        # If left symbol is encountered
        if c in ['(', '{', '[']:
            openParentheses.append(c)
        # If right symbol is encountered
        elif c == ')' and len(openParentheses) != 0 and openParentheses[-1] == '(':
            openParentheses.pop()
        elif c == '}' and len(openParentheses) != 0 and openParentheses[-1] == '{':
            openParentheses.pop()
        elif c == ']' and len(openParentheses) != 0 and openParentheses[-1] == '[':
            openParentheses.pop()
        # If none of the valid symbols is encountered
        else:
            return False
    return openParentheses == []


if __name__ == "__main__":
    print(isValidParentheses("{([])}"))
    print(isValidParentheses("()"))
    print(isValidParentheses("([]"))
