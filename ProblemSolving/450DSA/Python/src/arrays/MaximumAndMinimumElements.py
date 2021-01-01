"""
@author Anirudh Sharma

Write a function to return minimum and maximum in an array.
Your program should make the minimum number of comparisons.
"""


def findMaxAndMinNormally(a):
    # Base condition
    if not a:
        return [None, None]
    # Array to store the result
    # 0th element will store the minimum value
    # 1st element will store the maximum value
    minAndMaxPair = [a[0]] * 2
    # Loop through the array
    for i in range(len(a)):
        minAndMaxPair[0] = min(minAndMaxPair[0], a[i])
        minAndMaxPair[1] = max(minAndMaxPair[1], a[i])
    return minAndMaxPair


def findMaxAndMinOptimallyHelper(a, low, high) -> list:
    # Array to store the result
    minAndMaxPair = [None] * 2
    # Base condition
    if not a:
        return minAndMaxPair
    # If there is only one element
    if low == high:
        minAndMaxPair[0], minAndMaxPair[1] = a[0], a[0]
        return minAndMaxPair
    # If there are two elements
    if high == low + 1:
        minAndMaxPair[0] = min(a[low], a[high])
        minAndMaxPair[1] = max(a[low], a[high])
        return minAndMaxPair
    # For length more than 2
    # Mid index
    mid = low + (high - low) // 2
    # Recursively get the minimum and maximum elements of
    # two array halves
    minAndMaxLeft = findMaxAndMinOptimallyHelper(a, low, mid)
    minAndMaxRight = findMaxAndMinOptimallyHelper(a, mid + 1, high)
    # Find minimum and maximum of the two halves
    minAndMaxPair[0] = min(minAndMaxLeft[0], minAndMaxRight[0])
    minAndMaxPair[1] = max(minAndMaxLeft[1], minAndMaxRight[1])
    return minAndMaxPair


def findMaxAndMinOptimally(a):
    return findMaxAndMinOptimallyHelper(a, 0, len(a) - 1)


if __name__ == '__main__':
    minAndMax = findMaxAndMinNormally([1000, 11, 445, 1, 330, 3000])
    print("Min: " + str(minAndMax[0]) + ", Max: " + str(minAndMax[1]))
    minAndMax = findMaxAndMinNormally([9, -2, 12, -21, 342, 67, -63, -32456, 43563, 212, 43546])
    print("Min: " + str(minAndMax[0]) + ", Max: " + str(minAndMax[1]))
    minAndMax = findMaxAndMinNormally([])
    print("Min: " + str(minAndMax[0]) + ", Max: " + str(minAndMax[1]))

    minAndMax = findMaxAndMinOptimally([1000, 11, 445, 1, 330, 3000])
    print("Min: " + str(minAndMax[0]) + ", Max: " + str(minAndMax[1]))
    minAndMax = findMaxAndMinOptimally([9, -2, 12, -21, 342, 67, -63, -32456, 43563, 212, 43546])
    print("Min: " + str(minAndMax[0]) + ", Max: " + str(minAndMax[1]))
    minAndMax = findMaxAndMinOptimally([])
    print("Min: " + str(minAndMax[0]) + ", Max: " + str(minAndMax[1]))
