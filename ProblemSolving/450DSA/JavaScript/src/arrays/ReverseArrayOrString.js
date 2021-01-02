/**
 * @author Anirudh Sharma
 * 
 * Given an array (or string), the task is to reverse the array/string.
 */
const reverseArray = (a) => {
    // Base condition
    if (a === undefined || a.length === 0) {
        return a;
    }
    // Left pointer (moves forward)
    let left = 0;
    // Right pointer (moves backward)
    let right = a.length - 1;
    // Loop until both pointers meet
    while (left <= right) {
        // Swap left and right elements
        const temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        left++;
        right--;
    }
    return a;
};

const reverseString = (s) => {
    // Base condition
    if (s === undefined || s.length === 0) {
        return s;
    }
    // Array of characters in the string
    const characters = s.split("");
    // Left pointer (moves forward)
    let left = 0;
    // Right pointers (moves backward)
    let right = s.length - 1;
    // Loop until both pointers meet
    while (left <= right) {
        // Swap left and right characters
        const temp = characters[left];
        characters[left] = characters[right];
        characters[right] = temp;
        // Update the pointers
        left++;
        right--;
    }
    return characters.join("");
};

console.log(reverseArray([1, 2, 3]));
console.log(reverseArray([4, 5, 1, 2]));
console.log(reverseString("Anirudh"));
console.log(reverseString("Problem Solving"));