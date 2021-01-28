"""
@author Anirudh Sharma

Given an array arr of size N and an integer K.
Find if there's a triplet in the array which sums up to the given integer K.

Constraints:
1 ≤ N ≤ 10^3
1 ≤ A[i] ≤ 10
"""


def doesTripletExist(nums, K):
    # Base condition
    if nums is None or len(nums) < 3:
        return False
    # Sort the array
    nums.sort()
    # Loop through the array
    for i in range(len(nums)):
        # Left and right pointers
        j, k = i + 1, len(nums) - 1
        # Loop until two pointers meet
        while j < k:
            # Sum of the triplet
            tripletSum = nums[i] + nums[j] + nums[k]
            # Check for the sum
            if tripletSum == K:
                return True
            # If the sum is less than K then we are too left
            # and need to move right
            elif tripletSum < K:
                j += 1
            # If the sum is less than K then we are too right
            # and need to move left
            else:
                k -= 1
    return False


if __name__ == "__main__":
    nums = [1, 4, 45, 6, 10, 8]
    k = 13
    print(doesTripletExist(nums, k))

    nums = [1, 2, 4, 3, 6]
    k = 10
    print(doesTripletExist(nums, k))
