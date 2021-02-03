import sys

"""
* @author Anirudh Sharma

Given an array A of positive integers of size N, where each value represents number of chocolates in a packet.
Each packet can have variable number of chocolates.

There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet
with maximum chocolates and student having packet with minimum chocolates is minimum.

Constraints:
1 <= N <= 10^7
1 <= A[i] <= 10^18
1 <= M <= N
"""


def distribute(A, M):
    # Special case
    if A is None or len(A) < M:
        return 0
    # Minimum difference between max and min chocolates
    minimumDifference = sys.maxsize
    # Sort the array
    A.sort()
    # Loop through the array in the window of size M
    for i in range(0, len(A) - M + 1):
        # Difference between current min and max
        difference = A[i + M - 1] - A[i]
        minimumDifference = min(minimumDifference, difference)
    return minimumDifference


if __name__ == "__main__":
    a = [7, 3, 2, 4, 9, 12, 56]
    m = 3
    print(distribute(a, m))

    a = [3, 4, 1, 9, 56, 7, 9, 12]
    m = 5
    print(distribute(a, m))

    a = [12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50]
    m = 7
    print(distribute(a, m))

        
