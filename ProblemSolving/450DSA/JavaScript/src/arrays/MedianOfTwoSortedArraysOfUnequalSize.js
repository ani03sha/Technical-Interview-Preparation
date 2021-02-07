/**
 * @author Anirudh Sharma
 * 
 * Given two sorted arrays a and b of size m and n respectively,
 * return the median of the two sorted arrays.
 * 
 * Follow up: The overall run time complexity should be O(log (m+n)).
 */
const findMedianSortedArrays = (a, b) => {
    // We will be assuming that a is the smaller array of the two
    if (a.length > b.length) {
        return findMedianSortedArrays(b, a);
    }
    // Lengths of both the arrays
    const m = a.length;
    const n = b.length;
    // Start and end indices for binary search
    let start = 0;
    let end = m;
    // Loop until the pointers meet
    while (start <= end) {
        // Partitions for a and b arrays
        let partitionA = start + parseInt((end - start) / 2);
        let partitionB = parseInt((m + n + 1) / 2) - partitionA;
        // Calculate the ledt and right boundary elements
        let leftMaxA = partitionA == 0 ? Number.MIN_VALUE : a[partitionA - 1];
        let rightMinA = partitionA == m ? Number.MAX_VALUE : a[partitionA];
        let leftMaxB = partitionB == 0 ? Number.MIN_VALUE : b[partitionB - 1];
        let rightMinB = partitionB == n ? Number.MAX_VALUE : b[partitionB];
        // Check if we have found the elements
        if (leftMaxA <= rightMinB && leftMaxB <= rightMinA) {
            // Check if the length is even
            if ((m + n) % 2 == 0) {
                return (Math.max(leftMaxA, leftMaxB) + Math.min(rightMinA, rightMinB)) / 2.0;
            } else {
                return Math.max(leftMaxA, leftMaxB);
            }
        }
        // If we are too far on the right of a
        else if (leftMaxA > rightMinB) {
            end = partitionA - 1;
        }
        // If we are too far on the right of a
        else {
            start = partitionA + 1;
        }
    }
    throw "Arrays are not sorted!";
};


let A = [1, 3];
let B = [2];
console.log(findMedianSortedArrays(A, B));

A = [1, 2];
B = [3, 4];
console.log(findMedianSortedArrays(A, B));

A = [0, 0];
B = [0, 0];
console.log(findMedianSortedArrays(A, B));

A = [];
B = [1];
console.log(findMedianSortedArrays(A, B));

A = [2];
B = [];
console.log(findMedianSortedArrays(A, B));