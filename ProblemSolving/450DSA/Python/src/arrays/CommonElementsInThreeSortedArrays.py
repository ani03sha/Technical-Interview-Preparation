"""
@author Anirudh Sharma

Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Constraints:
1 <= n1, n2, n3 <= 10^5
The array elements can be both positive or negative integers.
"""


def commonElements(A, B, C):
    # List to store the common elements
    commons = []
    # Indices to traverse through three arrays
    i = 0
    j = 0
    k = 0
    # Loop until there are elements in every array
    while i < len(A) and j < len(B) and k < len(C):
        # If the current element in all the three arrays is equal
        # then we will add it to the result
        if A[i] == B[j] and B[j] == C[k]:
            # To avoid duplicates
            if A[i] not in commons:
                commons.append(A[i])
            i += 1
            j += 1
            k += 1
        # If current element in A is less than the current element
        # in B, the we will move A ahead as the array is sorted
        # so the next common element will be ahead of the current
        # element, if exists
        elif A[i] < B[j]:
            i += 1
        # If current element in B is less than the current element
        # in C, the we will move B ahead as the array is sorted
        # so the next common element will be ahead of the current
        # element, if exists
        elif B[j] < C[k]:
            j += 1
        # We will move C ahead
        else:
            k += 1
    return commons


if __name__ == "__main__":
    A = [1, 5, 10, 20, 40, 80]
    B = [6, 7, 20, 80, 100]
    C = [3, 4, 15, 20, 30, 70, 80, 120]
    print(commonElements(A, B, C))

    A = [3, 3, 3]
    B = [3, 3, 3]
    C = [3, 3, 3]
    print(commonElements(A, B, C))
