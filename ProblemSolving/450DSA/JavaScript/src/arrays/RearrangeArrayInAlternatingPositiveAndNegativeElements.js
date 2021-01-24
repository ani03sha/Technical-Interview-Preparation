/**
 * @author Anirudh Sharma
 * 
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such that
 * every positive number is followed by negative and vice-versa maintaining the order of appearance.
 * 
 * Number of positive and negative numbers need not be equal. If there are more positive numbers
 * they appear at the end of the array. If there are more negative numbers, they too appear in the
 * end of the array.
 * 
 * The space complexity should be O(1)
 */
const rearrange = (a) => {
    // Special cases
    if (a === undefined || a.length <= 1) {
        return a;
    }
    // Loop for all the elements in the array
    for (let i = 0; i < a.length; i++) {
        // Check if the elements is at its correct
        // position or not.
        // Negative element should be at even index
        // and positive element should be at odd index
        if (isAtCorrectPosition(a, i)) {
            // Get the index of next element of opposite sign
            let nextOppositeElementIndex = getNextElementOfOppositeSign(a, i);
            if (nextOppositeElementIndex != -1) {
                rightRotateSubarray(a, i, nextOppositeElementIndex);
            } else {
                break;
            }
        }
    }
    return a;
};

const rightRotateSubarray = (a, left,right) => {
    const lastElementOfSubarray = a[right];
    for (let i = right; i > left; i--) {
        a[i] = a[i - 1];
    }
    a[left] = lastElementOfSubarray;
};

const getNextElementOfOppositeSign = (a, index) => {
    for (let i = index + 1; i < a.length; i++) {
        if (a[i] * a[index] < 0) {
            return i;
        }
    }
    return -1;
};

const isAtCorrectPosition = (a, index) => {
    if (index % 2 === 0) {
        return a[index] > 0;
    } else {
        return a[index] < 0;
    }
};

let arr = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8];
console.log(rearrange(arr));

arr = [-1, 3, 2, 4, 5, -6, 7, -9];
console.log(rearrange(arr));