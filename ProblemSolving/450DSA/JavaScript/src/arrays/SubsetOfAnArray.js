/**
 * @author Anirudh Sharma
 * 
 * Given two arrays: arr1[0..m-1] of size m and arr2[0..n-1] of size n.
 * Task is to check whether arr2[] is a subset of arr1[] or not.
 */
const isSubset = (arr1, arr2) => {
    // Lengths of the two arrays
    const m = arr1.length;
    const n = arr2.length;
    // Base condition
    if (m < n) {
        return false;
    }
    // Sort both arrays
    arr1.sort((x, y) => x - y);
    arr2.sort((x, y) => x - y);
    // Indices to traverse arr1 and arr2
    let i = 0;
    let j = 0;
    // Loop for both arrays until elements left
    while (i < m && j < n) {
        // If the current element of arr1 is less
        // than the current element of arr2, it means
        // we need to search further in arr1
        if (arr1[i] < arr2[j]) {
            i++;
        }
        // If both current elements are equal,
        // we will move forward in both arrays
        else if (arr1[i] === arr2[j]) {
            i++;
            j++;
        }
        // If the current element in arr1 is greater
        // than the current element in arr2, it means
        // the current element in arr2 is not present
        // in arr1, so we will return false
        else {
            return false;
        }
    }
    // After traversing the whole arrays, i cannot be
    // less than the number of elements in arr2.
    return i >= n;
};

let a = [11, 1, 13, 21, 3, 7];
let b = [11, 3, 7, 1];
console.log(isSubset(a, b));

a = [1, 2, 3, 4, 5, 6];
b = [1, 2, 4];
console.log(isSubset(a, b));

a = [10, 5, 2, 23, 19];
b = [19, 5, 3];
console.log(isSubset(a, b));