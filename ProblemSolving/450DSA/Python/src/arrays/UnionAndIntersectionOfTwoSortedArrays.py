"""
@author Anirudh Sharma

Given two arrays A and B of size N and M respectively. The task is to find union between these two arrays.
Union of the two arrays can be defined as the set containing distinct elements from both the arrays.
If there are repetitions, then only one occurrence of element should be printed in union.
"""


def findUnion(a, b):
    # List to store union of two arrays
    union = []
    # Lengths of two arrays
    m = len(a)
    n = len(b)
    # Counter for both arrays
    i = 0
    j = 0
    # Loop until elements are remaining in either array
    while i < m and j < n:
        # If a has smaller element, put it in the list
        if a[i] < b[j]:
            union.append(a[i])
            i += 1
            # Handle for duplicates
            while i < m and a[i] == a[i - 1]:
                i += 1
        # If b has smaller element, put it in the list
        elif a[i] > b[j]:
            union.append(b[j])
            j += 1
            # Handle duplicates
            while j < n and b[j] == b[j - 1]:
                j += 1
        # If both elements are equal, put either one in the list
        else:
            union.append(a[i])
            i += 1
            j += 1
            # Handle duplicates
            while i < m and a[i] == a[i - 1]:
                i += 1
            while j < n and b[j] == b[j - 1]:
                j += 1
    # Add all remaining elements from a
    while i < m:
        union.append(a[i])
        i += 1
        # Handle duplicates
        while i < m and a[i] == a[i - 1]:
            i += 1
    # Add all remaining elements from b
    while j < n:
        union.append(b[j])
        j += 1
        # Handle duplicates
        while j < n and b[j] == b[j - 1]:
            j += 1
    return union


def findIntersection(a, b):
    # List to store the result
    intersection = []
    # Lengths of arrays
    m = len(a)
    n = len(b)
    # Counters for both arrays
    i = 0
    j = 0
    # Loop until elements are left in either of the array
    while i < m and j < n:
        if a[i] < b[j]:
            i += 1
            # Handle duplicates
            while i < m and a[i] == a[i - 1]:
                i += 1
        elif a[i] > b[j]:
            j += 1
            while j < n and b[j] == b[j - 1]:
                j += 1
        else:
            intersection.append(a[i])
            i += 1
            j += 1
            # Handle duplicates
            while i < m and a[i] == a[i - 1]:
                i += 1
            while j < n and b[j] == b[j - 1]:
                j += 1
    return intersection


if __name__ == "__main__":
    A = [1, 2, 3, 4, 5]
    B = [1, 2, 3]
    print('Union: ', findUnion(A, B))
    print('Intersection: ', findIntersection(A, B))

    A = [1, 2, 3, 4, 5]
    B = [6, 7, 8]
    print('Union: ', findUnion(A, B))
    print('Intersection: ', findIntersection(A, B))

    A = [1, 1, 1, 1, 1, 1]
    B = [2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6]
    print('Union: ', findUnion(A, B))
    print('Intersection: ', findIntersection(A, B))

    A = [1, 3, 5, 7, 9]
    B = [2, 4, 6, 8]
    print('Union: ', findUnion(A, B))
    print('Intersection: ', findIntersection(A, B))

    A = [1, 2, 3, 4, 5, 5, 6]
    B = [1, 2, 3, 4, 5, 5, 6, 6, 7]
    print('Union: ', findUnion(A, B))
    print('Intersection: ', findIntersection(A, B))

    A = []
    B = []
    print('Union: ', findUnion(A, B))
    print('Intersection: ', findIntersection(A, B))
