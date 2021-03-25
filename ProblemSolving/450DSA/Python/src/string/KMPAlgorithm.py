"""
@author Anirudh Sharma

Given a text t[0..n-1] and a pattern p[0..m-1], write a function search(char p[], char t[])
that prints all occurrences of p[] in t[]. You may assume that n > m.
"""


def findLPS(pattern):
    lps = [0] * len(pattern)
    # Index for checking the pattern
    index = 0
    for i in range(1, len(pattern)):
        if pattern[i] == pattern[index]:
            lps[i] = index + 1
            index += 1
            i += 1
        else:
            if index != 0:
                index = lps[index - 1]
            else:
                lps[i] = 0
                i += 1
    return lps


def search(pattern, text):
    # Prepare the pi table of prefix-suffix table
    lps = findLPS(pattern)
    # Indices to move through text and pattern respectively
    textIndex, patternIndex = 0, 0
    # Loop until we reach to the end
    while textIndex < len(text) and patternIndex < len(pattern):
        # If the characters match
        if text[textIndex] == pattern[patternIndex]:
            textIndex += 1
            patternIndex += 1
        else:
            if patternIndex != 0:
                patternIndex = lps[patternIndex - 1]
            else:
                textIndex += 1
    return patternIndex == len(pattern)


if __name__ == "__main__":
    print("Does pattern exist? " + str(search("abcdabcy", "abcxabcdabcdabcy")))
