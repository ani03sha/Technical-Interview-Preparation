"""
@author Anirudh Sharma

Given a string s, and a dictionary of n words wordDictionary,
find out if A can be segmented into a space-separated sequence of dictionary words.

1 <= N <= 12
1 <= s <= 1000, where s = length of string A
The length of each word is less than 15.
"""


def wordBreakHelper(s, wordDictionary, lookup):
    # Special case
    if s is None or len(s) == 0:
        return True
    # If the subproblem is already solved
    if s in lookup:
        return lookup[s]
    # Loop for every word in the dictionary
    for word in wordDictionary:
        # Check if the string starts with the
        # current word
        if s.startswith(word):
            # Get the remaining string
            suffix = s[len(word):]
            if wordBreakHelper(suffix, wordDictionary, lookup):
                lookup[s] = True
                return True
    lookup[s] = False
    return False


def wordBreak(s, wordDictionary):
    # Lookup for memoization
    lookup = {}
    return wordBreakHelper(s, wordDictionary, lookup)


if __name__ == "__main__":
    s = "ilike"
    wordDictionary = ["i", "like", "sam", "sung", "samsung", "mobile",
                      "ice", "cream", "icecream", "man", "go", "mango"]
    print(wordBreak(s, wordDictionary))

    s = "ilikesamsung"
    wordDictionary = ["i", "like", "sam", "sung", "samsung", "mobile",
                      "ice", "cream", "icecream", "man", "go", "mango"]
    print(wordBreak(s, wordDictionary))
