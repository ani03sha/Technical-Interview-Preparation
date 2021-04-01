import sys

"""
@author Anirudh Sharma

Given a sequence of strings, the task is to find out the second most repeated (or frequent)
string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Constraints:
1<=N<=10^3
"""


def secondMostFrequent(strings):
    # Dictionary to store the frequency of
    # each word in the array
    frequencyMap = {}
    for s in strings:
        if s in frequencyMap:
            frequencyMap[s] += 1
        else:
            frequencyMap[s] = 1
    # Max and second map
    maxValue, secondMaxValue = -sys.maxsize, -sys.maxsize
    # Loop through the map to find the second map value
    for v in frequencyMap.values():
        if maxValue < v:
            secondMaxValue = maxValue
            maxValue = v
        elif v > secondMaxValue and v != maxValue:
            secondMaxValue = v
    # Again iterate through the map to get the key
    # corresponding to the the second max value
    for k, v in frequencyMap.items():
        if v == secondMaxValue:
            return k
    return None


if __name__ == "__main__":
    strings = ["aaa", "bbb", "ccc", "bbb", "aaa", "aaa"]
    print(secondMostFrequent(strings))

    strings = ["geek", "for", "geek", "for", "geek", "aaa"]
    print(secondMostFrequent(strings))
