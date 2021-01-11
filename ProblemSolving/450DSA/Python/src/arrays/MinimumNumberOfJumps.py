"""
@author Anirudh Sharma
 
Given an array of integers where each element represents the max number of steps that can
be made forward from that element.
 
Find the minimum number of jumps to reach the end of the array (starting from the first element).
 
If an element is 0, then you cannot move through that element.
"""


def minJumps(a):
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
    print(minJumps([1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]))
    print(minJumps([1, 4, 3, 2, 6, 7]))
    print(minJumps([2, 3, 1, 1, 2, 4, 2, 0, 1, 1]))
