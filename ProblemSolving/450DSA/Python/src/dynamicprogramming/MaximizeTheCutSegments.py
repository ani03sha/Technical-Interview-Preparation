"""
@author Anirudh Sharma

Given an integer N denoting the Length of a line segment.
You need to cut the line segment in such a way that the cut
length of a line segment each time is either x , y or z.
Here x, y, and z are integers.

After performing all the cut operations, your total number of cut segments must be maximum.
"""


def maximizeCuts(n, x, y, z):
    # Base case
    if (n <= 0):
        return 0
    # Lookup table to store maximum cuts required
    # to cut a rod of certain length
    lookup = [-1] * (n + 1)
    # Store the cuts in an array
    cuts = [x, y, z]
    # Since we don't need any cut for 0 length
    lookup[0] = 0
    # Populate the table for remaining lengths
    for i in range(1, n + 1):
        for cut in cuts:
            if cut <= i and lookup[i - cut] != -1:
                lookup[i] = max(lookup[i], 1 + lookup[i - cut])
    return max(lookup[n], 0)


if __name__ == "__main__":
    n = 4
    x = 2
    y = 1
    z = 1
    print(maximizeCuts(n, x, y, z))

    n = 5
    x = 5
    y = 3
    z = 2
    print(maximizeCuts(n, x, y, z))
