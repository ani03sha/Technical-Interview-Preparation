/**
 * @author Anirudh Sharma
 * <p>
 * Given two arrays A and B of size N and M respectively. The task is to find union between these two arrays.
 * Union of the two arrays can be defined as the set containing distinct elements from both the arrays.
 * If there are repetitions, then only one occurrence of element should be printed in union.
 */
const findUnion = (a, b) => {
    // Array to store union of two arrays
    const union = [];
    // Lengths of two arrays
    const m = a.length;
    const n = b.length;
    // Counters for both arrays
    let i = 0;
    let j = 0;
    // Loop until elements left in either array
    while (i < m && j < n) {
        // If a has smaller element then put it in the list
        if (a[i] < b[j]) {
            union.push(a[i]);
            i++;
            // Handle for duplicate elements
            while (i < m && a[i] === a[i - 1]) {
                i++;
            }
        }
        // If b has smaller element then put it in the list
        else if (a[i] > b[j]) {
            union.push(b[j]);
            j++;
            // Handle for duplicate elements
            while (j < n && b[j] === b[j - 1]) {
                j++;
            }
        }
        // If both elements are same, then put either of them
        else {
            union.push(a[i]);
            i++;
            j++;
            // Handle for duplicate elements
            while (i < m && a[i] === a[i - 1]) {
                i++;
            }
        }
    }
    // Add all remaining elements from a
    while (i < m) {
        union.push(a[i]);
        i++;
        // Handle for duplicate elements
        while (i < m && a[i] === a[i - 1]) {
            i++;
        }
    }
    // Add all remaining elements from b
    while (j < n) {
        union.push(b[j]);
        j++;
        // Handle for duplicate elements
        while (j < n && b[j] === b[j - 1]) {
            j++;
        }
    }
    return union;
};

const findIntersection = (a, b) => {
    // Array to store the intersection of two arrays
    const intersection = []
    // Length of two arrays
    const m = a.length;
    const n = b.length;
    // Indices for two arrays
    let i = 0;
    let j = 0;
    // Loop until there is element left in either array
    while (i < m && j < n) {
        if (a[i] < b[j]) {
            i++;
            // Handle duplicate elements
            while (i < m && a[i] === a[i - 1]) {
                i++;
            }
        } else if (a[i] > b[j]) {
            j++;
            // Handle duplicate elements
            while (j < n && b[j] === b[j - 1]) {
                j++;
            }
        } else {
            intersection.push(a[i]);
            i++;
            j++;
            while (i < m && a[i] === a[i - 1]) {
                i++;
            }
        }
    }
    return intersection;
};


let A = [1, 2, 3, 4, 5];
let B = [1, 2, 3];
console.log(`Union: ${findUnion(A, B)}`);
console.log(`Intersection: ${findIntersection(A, B)}`);

A = [1, 2, 3, 4, 5];
B = [6, 7, 8];
console.log(`Union: ${findUnion(A, B)}`);
console.log(`Intersection: ${findIntersection(A, B)}`);

A = [1, 1, 1, 1, 1, 1];
B = [2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6];
console.log(`Union: ${findUnion(A, B)}`);
console.log(`Intersection: ${findIntersection(A, B)}`);

A = [1, 3, 5, 7, 9];
B = [2, 4, 6, 8];
console.log(`Union: ${findUnion(A, B)}`);
console.log(`Intersection: ${findIntersection(A, B)}`);

A = [1, 2, 3, 4, 5, 5, 6];
B = [1, 2, 3, 4, 5, 5, 6, 6, 7];
console.log(`Union: ${findUnion(A, B)}`);
console.log(`Intersection: ${findIntersection(A, B)}`);

A = [];
B = [];
console.log(`Union: ${findUnion(A, B)}`);
console.log(`Intersection: ${findIntersection(A, B)}`);
