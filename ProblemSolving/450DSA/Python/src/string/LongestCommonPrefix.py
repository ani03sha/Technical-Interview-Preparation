"""
@author Anirudh Sharma

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
"""


def longestCommonPrefix(strings):
    # Longest common prefix string
    lcp = ""
    # Base condition
    if strings is None or len(strings) == 0:
        return lcp
    # Find the minimum length string from the array
    minimumLength = len(strings[0])
    for i in range(1, len(strings)):
        minimumLength = min(minimumLength, len(strings[i]))
    # Loop until the minimum length
    for i in range(0, minimumLength):
        # Get the current character from the first string
        current = strings[0][i]
        # Check if this character is found in all other strings or not
        for j in range(0, len(strings)):
            if strings[j][i] != current:
                return lcp
        lcp += current
    return lcp


if __name__ == "__main__":
    strings = ["flower", "flow", "flight"]
    print(longestCommonPrefix(strings))

    strings = ["dog", "racecar", "car"]
    print(longestCommonPrefix(strings))
