"""
@author Anirudh Sharma

Given an array of strings, return all groups of strings that are anagrams.
The groups must be created in order of their appearance in the original array.

Constraints:
1<=N<=100
"""


def groupAnagrams(words):
    # Sort each word on the list
    wordList = [''.join(sorted(word)) for word in words]
    # Construct a dictionary where the key is each sorted word,
    # and value is a list of indices where it is present
    anagrams = {}
    for i, e in enumerate(wordList):
        anagrams.setdefault(e, []).append(i)
    # List to store result
    result = []
    # Traverse the dictionary and read indices for each sorted key.
    # The anagrams are present in the actual list at those indices
    for index in anagrams.values():
        result.append([words[i] for i in index])
    return result


if __name__ == "__main__":
    words = ["CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
             "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
             "SUED", "LEAN", "SCAR", "DESIGN"]
    print(groupAnagrams(words))

    words = ["CAT", "ACT", "DOG", "TAC", "GOD"]
    print(groupAnagrams(words))
