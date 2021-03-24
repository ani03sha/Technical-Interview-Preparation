"""
@author Anirudh Sharma

Given a text t[0..n-1] and a pattern p[0..m-1], write a function search(char p[], char t[])
that prints all occurrences of p[] in t[]. You may assume that n > m.
"""


def search(pattern, text):
    # Maximum number of characters in the input
    d = 256
    # A prime number to manipulate the hash
    q = 257
    # List to store the indices where pattern starts
    indices = []
    # Lengths of the text and pattern
    patternLength, textLength = len(pattern), len(text)
    # Hash values of pattern and text
    patternHash, textHash = 0, 0
    # To determine higher order position
    h = 1
    for _ in range(patternLength - 1):
        h = (h * d) % q
    # Find hash of the pattern and first window of
    # length patternLength in the text
    for i in range(patternLength):
        patternHash = (patternHash * d + ord(pattern[i])) % q
        textHash = (textHash * d + ord(text[i])) % q
    # Perform sliding window matching on text
    for i in range(textLength - patternLength + 1):
        # If the hashes match, then only we will match the
        # characters of both the strings
        if patternHash == textHash:
            # Check for characters one by one
            for j in range(patternLength):
                if text[i + j] != pattern[j]:
                    break
                else:
                    j += 1
            if j == patternLength:
                indices.append(i)
        # Calculate the hash for the next window
        if i < textLength - patternLength:
            textHash = (
                d * (textHash - ord(text[i]) * h) + ord(text[i + patternLength])) % q
            # For negative value of textHash, convert it to positive
            if textHash < 0:
                textHash += q
    return indices


if __name__ == "__main__":
    text = "ABCCDDAEFG"
    pattern = "CDD"
    print(search(pattern, text))

    text = "12348765765"
    pattern = "765"
    print(search(pattern, text))

    text = "balloonsandcupcakes"
    pattern = "cupcakes"
    print(search(pattern, text))
