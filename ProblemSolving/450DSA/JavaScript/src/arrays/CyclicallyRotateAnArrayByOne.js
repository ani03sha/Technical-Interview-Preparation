/**
 * @author Anirudh Sharma
 *
 * Given an array, cyclically rotate an array by one.
 */
const rotateArray = (a) => {
    // Base condition
    if (a === undefined || a.length <= 1) {
        return a;
    }
    // Save the last element of the array for future
    const lastElement = a[a.length - 1];
    // Index pointing at the end of the array
    let i = a.length - 2;
    while (i >= 0) {
        // Copy the current element to its right element
        a[i + 1] = a[i];
        i--;
    }
    // Put the last element at first position (0th index)
    a[0] = lastElement;
    return a;
};

console.log(rotateArray([1, 2, 3, 4, 5]));
console.log(rotateArray([1, 2]));
console.log(rotateArray([1]));
console.log(rotateArray([]));
