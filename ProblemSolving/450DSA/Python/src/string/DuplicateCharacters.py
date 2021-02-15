"""
@author Anirudh Sharma

Write an efficient program to print all the duplicates and their counts in the input string.
"""


def printDuplicateCharacters(s):
    # Dictionary to store the count of characters
    characterCount = {}
    # Traverse through the entire string
    for c in s:
        characterCount[c] = characterCount.setdefault(c, 0) + 1
    # Loop through the map
    for key in characterCount:
        if characterCount[key] > 1:
            print("Character: " + key + " Count: " + str(characterCount[key]))


if __name__ == "__main__":
    s = "test string"
    printDuplicateCharacters(s)

    s = "thisstringcontainsmanyduplicatecharacters"
    printDuplicateCharacters(s)