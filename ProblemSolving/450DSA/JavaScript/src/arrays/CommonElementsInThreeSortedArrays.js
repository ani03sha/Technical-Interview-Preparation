/**
 * @author Anirudh Sharma
 * 
 * Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * Note: can you take care of the duplicates without using any additional Data Structure?
 * 
 * Constraints:
 * 1 <= n1, n2, n3 <= 10^5
 * The array elements can be both positive or negative integers.
 */
const commonElements = (A, B, C) => {
    // List to store the common elements
    const commons = [];
    // Indices to traverse through the three arrays
    let i = 0;
    let j = 0;
    let k = 0;
    // Loop until there are elements in every array
    while (i < A.length && j < B.length && k < C.length) {
        // If the current element in all the three arrays is equal
        // then we will add it to the result
        if (A[i] == B[j] && B[j] == C[k]) {
            // To avoid duplicates
            if (!commons.includes(A[i])) {
                commons.push(A[i]);
            }
            i++;
            j++;
            k++;
        }
        // If current element in A is less than the current element
        // in B, the we will move A ahead as the array is sorted
        // so the next common element will be ahead of the current
        // element, if exists
        else if (A[i] < B[j]) {
            i++;
        }
        // If current element in B is less than the current element
        // in C, the we will move B ahead as the array is sorted
        // so the next common element will be ahead of the current
        // element, if exists
        else if (B[j] < C[k]) {
            j++;
        }
        // We will move C ahead
        else {
            k++;
        }
    }
    return commons;
};

let a = [1, 5, 10, 20, 40, 80];
let b = [6, 7, 20, 80, 100];
let c = [3, 4, 15, 20, 30, 70, 80, 120];
console.log(commonElements(a, b, c));

a = [3, 3, 3];
b = [3, 3, 3];
c = [3, 3, 3];
console.log(commonElements(a, b, c));