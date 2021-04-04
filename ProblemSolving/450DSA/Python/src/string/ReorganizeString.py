import heapq

"""
@author Anirudh Sharma

Given a string S, check if the letters can be rearranged so that two characters that are adjacent
to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Note:
S will consist of lowercase letters and have length in range [1, 500].
"""


def reorganizeString(S):
    # Dictionary to store frequency of each character
    frequencyMap = {}
    # Populate the dictionary
    for c in S:
        if c in frequencyMap:
            frequencyMap[c] += 1
        else:
            frequencyMap[c] = 1
    # Heap (min heap actually)
    minHeap = []
    # Push all keys of frequency map in the heap
    for key in frequencyMap:
        heapq.heappush(minHeap, (-frequencyMap[key], key))
    # To store final result
    result = ""
    # Pop first element and add it to the result
    previous = heapq.heappop(minHeap)
    result += previous[1]
    # To avoid characters being next to eachother, pop from heap,
    # and don't re-aad that char to the heap until the next iteration
    while minHeap:
        # Current key
        current = heapq.heappop(minHeap)
        result += current[1]
        # Re-add previous if it still has frequency left
        if previous[0] < -1:
            heapq.heappush(minHeap, (previous[0] + 1, previous[1]))
        previous = current
    return "" if len(S) != len(result) else result


if __name__ == "__main__":
    print(reorganizeString("aab"))
    print(reorganizeString("aaab"))
