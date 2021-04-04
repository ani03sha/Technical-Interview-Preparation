import sys

"""
@author Anirudh Sharma

Given a string 'S'. The task is to find the smallest window length that contains all
the characters of the given string at least one time.
For eg. A = "aabcbcdbca", then the result would be 4 as of the smallest window
will be "dbca".

Constraints:
1 ≤ |S| ≤ 10^5
String may contain both type of English Alphabets.
"""


def findSubstring(S):
    # Array to check if a character is visited
    visited = [False] * 256
    # Count of distinct characters
    distinctCharacterCount = 0
    # Loop through the array
    for c in S:
        if not visited[ord(c)]:
            visited[ord(c)] = True
            distinctCharacterCount += 1
    # Minimum length of the window
    minimumLength = sys.maxsize
    # Start of the window
    start = 0
    # Index where the desired window starts
    startIndex = -1
    # Count of distinct characters matched
    count = 0
    # Frequency map of characters
    frequencyMap = [0] * 256
    # Loop over the string
    for i in range(len(S)):
        # Update the frequency of this character
        frequencyMap[ord(S[i])] += 1
        # If any distinct character is found,
        # update the count
        if frequencyMap[ord(S[i])] == 1:
            count += 1
        # If all the characters are matched
        if count == distinctCharacterCount:
            # Now, we will minimize the window by
            # discarding a character that is occuring
            # more than once
            while frequencyMap[ord(S[start])] > 1:
                if frequencyMap[ord(S[start])] > 1:
                    frequencyMap[ord(S[start])] -= 1
                start += 1
            # Update the window size
            windowSize = i - start + 1
            if minimumLength > windowSize:
                minimumLength = windowSize
                startIndex = start
    return S[startIndex: startIndex + minimumLength]


if __name__ == "__main__":
    print(findSubstring("AABBBCBBAC"))
    print(findSubstring("aaab"))
