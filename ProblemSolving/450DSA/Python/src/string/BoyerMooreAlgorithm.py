"""
@author Anirudh Sharma

Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].
"""


def badCharacterHeuristics(pattern, patternLength, badCharacters):
    # Fill actual value of last occurrence of a character
    for i in range(patternLength):
        badCharacters[ord(pattern[i])] = i


def search(pattern, text):
    # List to store the indices of match
    matchedIndices = []
    # Lengths of pattern and text
    patternLength, textLength = len(pattern), len(text)
    # Array for storing the indices of bad characters
    badCharacters = [-1] * 256
    # Fill the badCharacters array using preprocessing
    # bad character heuristics function
    badCharacterHeuristics(pattern, patternLength, badCharacters)
    # Shift of the pattern w.r.t. text
    shift = 0
    # Loop through the text string
    while shift <= textLength - patternLength:
        # Pointer to move from right of the pattern
        right = patternLength - 1
        # Move from left to right as long as the
        # characters of pattern are matching with
        # the characters of text
        while right >= 0 and pattern[right] == text[shift + right]:
            right -= 1
        # If the pattern is present at the current shift,
        # then right will become - 1
        if right < 0:
            matchedIndices.append(shift)
            # Shift the pattern so that next character in text
            # aligns with the last occurrence of it in the pattern
            shift += patternLength - \
                badCharacters[ord(text[shift + patternLength])] if shift + patternLength < textLength else 1
        else:
            # Shift the pattern so that the bad character
            # in text aligns with the last occurrence of
            # it in pattern. The max function is used to
            # make sure that we get a positive shift.
            # We may get a negative shift if the last
            # occurrence  of bad character in pattern
            # is on the right side of the current
            # character
            shift += max(1, right - badCharacters[ord(text[shift + right])])
    return matchedIndices


if __name__ == "__main__":
    text = "ABAAABCD"
    pattern = "ABC"
    print(search(pattern, text))

    text = "ABCDABCD"
    pattern = "ABCD"
    print(search(pattern, text))
