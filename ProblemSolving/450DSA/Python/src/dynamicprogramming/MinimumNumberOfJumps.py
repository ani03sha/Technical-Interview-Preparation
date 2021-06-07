"""
@author Anirudh Sharma

Given an array of non-negative integers nums, you are initially positioned at the first
index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Constraints:

1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
"""


def jump(a):
    # Current position
    currentPosition = 0
    # Destination reached from an index
    destination = 0
    # Number of jumps required
    jumps = 0
    # Loop for the elements of the array
    for i in range(0, len(a) - 1):
        # Destination index will be maximum of the current position
        # and the index that can be reached after jumping
        destination = max(destination, i + a[i])
        # If we need to take jump
        if currentPosition == i:
            currentPosition = destination
            jumps += 1
    return jumps


if __name__ == "__main__":
    a = [2, 3, 1, 1, 4]
    print(jump(a))

    a = [2, 3, 0, 1, 4]
    print(jump(a))
