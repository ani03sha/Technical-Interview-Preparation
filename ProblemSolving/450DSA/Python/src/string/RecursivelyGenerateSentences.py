"""
@author Anirudh Sharma

Given a list of word lists, print all sentences possible taking one word from a list at a time via recursion
"""


def generateSentencesHelper(words, i, j, sentences):
    # Add current word to the sentences list
    sentences[i] = words[i][j]
    # If this is the last word of the current output
    # sequence, then print it
    if i == len(words) - 1:
        for k in range(len(words)):
            print(sentences[k], end=" ")
        print()
        return
    # Recur for next row
    for k in range(len(words[0])):
        if words[i + 1][k] != "":
            generateSentencesHelper(words, i + 1, k, sentences)


def generateSentences(words):
    # List to store the result
    sentences = [""] * len(words)
    # Consider all words for first row as starting
    # point and generate all sentences
    for i in range(len(words[0])):
        if words[0][i] != "":
            generateSentencesHelper(words, 0, i, sentences)


if __name__ == "__main__":
    words = [["you", "we", ""],
             ["have", "are", ""],
             ["sleep", "eat", "drink"]
             ]
    generateSentences(words)
