import sys

"""
@author Anirudh Sharma

Given two strings S and P. Find the smallest window in the S consisting of all the characters of P.

Constraints:
1 ≤ |S|, |P| ≤ 10^5
"""


def smallestWindow(S, P):
    # Lengths of both the strings
    pLength, sLength = len(P), len(S)
    # Special case
    if sLength < pLength:
        return ""
    # Frequency maps for characters of both the strings
    pFrequencyMap, sFrequencyMap = [0] * 256, [0] * 256
    # Populate P's frequency map
    for i in range(0, pLength):
        pFrequencyMap[ord(P[i])] += 1
    # Start of the window
    start = 0
    # Index where the desired window starts
    startIndex = -1
    # Minimum length of the window
    minimumLength = sys.maxsize
    # Count of distinct characters matched
    count = 0
    # Loop through S
    for i in range(sLength):
        # Populate S' frequency map
        sFrequencyMap[ord(S[i])] += 1
        # If S' character and P's characters match
        if sFrequencyMap[ord(S[i])] <= pFrequencyMap[ord(S[i])]:
            count += 1
        # If all characters are matched
        if count == pLength:
            # Try to minimize the window
            while sFrequencyMap[ord(S[start])] > pFrequencyMap[ord(S[start])] or pFrequencyMap[ord(S[start])] == 0:
                if sFrequencyMap[ord(S[start])] > pFrequencyMap[ord(S[start])]:
                    sFrequencyMap[ord(S[start])] -= 1
                start += 1
            # Update window size
            windowLength = i - start + 1
            if minimumLength > windowLength:
                minimumLength = windowLength
                startIndex = start
    # If no window found
    if startIndex == - 1:
        return ""
    return S[startIndex: startIndex + minimumLength]


if __name__ == "__main__":
    S = "timetopractice"
    P = "toc"
    print(smallestWindow(S, P))

    S = "zoomlazapzo"
    P = "oza"
    print(smallestWindow(S, P))
