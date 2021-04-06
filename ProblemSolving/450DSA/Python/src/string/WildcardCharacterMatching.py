"""
@author Anirudh Sharma

Given two strings where first string may contain wild card characters and second string
is a normal string.

Write a function that returns true if the two strings match.
The following are allowed wild card characters in first string.

- * --> Matches with 0 or more instances of any character or set of characters.
- ? --> Matches with any one character.
"""


def match(first, second):
    # Base case - if we reach to the end of
    # both strings, we are done
    if len(first) == 0 and len(second) == 0:
        return True
    # Make sure the characters after '*' are present
    # in the second string
    if len(first) > 1 and first[0] == '*' and len(second) == 0:
        return False
    # If the first string contains '?',
    # or current characters of both strings match
    if (len(first) > 1 and first[0] == '?') or len(first) != 0 and len(second) != 0 and first[0] == second[0]:
        return match(first[1:], second[1:])
    # If there is *, then there are two possibilities
    # a) We consider current character of second string
    # b) We ignore current character of second string.
    if len(first) > 0 and first[0] == '*':
        return match(first[1:], second) or match(first, second[1:])
    return False


if __name__ == "__main__":
    print(match("*pqrs", "pqrst"))
    print(match("abc*bcd", "abcdhghgbcd"))
    print(match("abc*c?d", "abcd"))
    print(match("*c*d", "abcd"))
    print(match("*?c*d", "abcd"))
