"""
@author Anirudh Sharma

Given a string S. The task is to print all permutations of a given string.

Constraints:
1 ≤ T ≤ 10
1 ≤ size of string ≤ 5
"""


def findPermutationsHelper(s, prefix, permutations):
    # Length of the string
    n = len(s)
    # Special case
    if n == 0:
        permutations.append(prefix)
        return
    for i in range(n):
        findPermutationsHelper(s[0:i] + s[i+1:n], prefix + s[i], permutations)


def findPermutations(s):
    # list to store the result
    permutations = []
    # Recursive call
    findPermutationsHelper(s, "", permutations)
    return permutations


if __name__ == "__main__":
    print(findPermutations("ABC"))
    print(findPermutations("ABSG"))