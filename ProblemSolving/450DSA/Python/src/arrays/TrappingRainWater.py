"""
@author Anirudh Sharma

Given n non-negative integers representing an elevation map where the width of each bar
is 1, compute how much water it can trap after raining.

Constraints:

n == height.length
0 <= n <= 3 * 10^4
0 <= height[i] <= 10^5
"""


def trap(height):
    # Special cases
    if height is None or len(height) < 2:
        return 0
    # Total water that can be trapped
    totalWater = 0
    # Variables to store left max and right max
    leftMax = 0
    rightMax = 0
    # Left and right pointers
    left = 0
    right = len(height) - 1
    # Loop until two pointers meet
    while left <= right:
        # If left wall is smaller than the right wall
        if height[left] < height[right]:
            if height[left] > leftMax:
                leftMax = height[left]
            else:
                totalWater += leftMax - height[left]
            left += 1
        # If right wall is smaller than the left wall
        else:
            if height[right] > rightMax:
                rightMax = height[right]
            else:
                totalWater += rightMax - height[right]
            right -= 1
    return totalWater


if __name__ == "__main__":
    print(trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
    print(trap([4, 2, 0, 3, 2, 5]))
