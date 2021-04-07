"""
@author Anirudh Sharma

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the
order of characters.

No two characters may map to the same character, but a character may map to itself.

Constraints:

1 <= s.length <= 510^4
t.length == s.length
s and t consist of any valid ascii character.
"""


def isIsomorphic(s, t):
    # Lengths of the strings
    m, n = len(s), len(t)
    # If lengths are not equal, return false
    if m != n:
        return False
    # Mapping of characters of s and t.
    stMapping = {}
    # Boolean array to store characters which are
    # already mapped
    visited = [False] * 256
    # Loop through the strings
    for i in range(m):
        # Current characters of both strings
        a, b = s[i], t[i]
        # If we have already seen a
        if a in stMapping:
            # Return false if a is mapped to different
            # character
            if stMapping[a] != b:
                return False
        # If we are seeing a for the first time
        else:
            # Return false if b is already mapped
            if (visited[ord(b)]):
                return False
            # Otherwise do the mapping
            stMapping[a] = b
            visited[ord(b)] = True
    return True


if __name__ == "__main__":
    s = "egg"
    t = "add"
    print(isIsomorphic(s, t))

    s = "foo"
    t = "bar"
    print(isIsomorphic(s, t))

    s = "paper"
    t = "title"
    print(isIsomorphic(s, t))
