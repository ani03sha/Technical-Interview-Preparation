/**
 * @author Anirudh Sharma
 * 
 * Write a function to return minimum and maximum in an array.
 * Your program should make the minimum number of comparisons.
 */
const findMinAndMaxNormally = (a) => {
    // Base condition
    if (a === undefined || a.length === 0) {
        return [undefined, undefined];
    }
    // Array to store the minimum and maximum elements
    const minAndMaxPair = new Array(2);
    // 0th element will store the minimum value
    minAndMaxPair[0] = a[0];
    // 1st element will store the maximum value
    minAndMaxPair[1] = a[0];
    // Loop for the remaining elements in the array
    for (let i = 1; i < a.length; i++) {
        minAndMaxPair[0] = Math.min(minAndMaxPair[0], a[i]);
        minAndMaxPair[1] = Math.max(minAndMaxPair[1], a[i]);
    }
    return minAndMaxPair;
};

const findMinAndMaxOptimally = (a) => {
    return findMinAndMaxOptimallyHelper(a, 0, a.length - 1);
};

const findMinAndMaxOptimallyHelper = (a, low, high) => {
    if (a === undefined || a.length === 0) {
        return [undefined, undefined];
    }
    // Array to store result
    const minAndMaxPair = new Array(2);
    // If the length is 1
    if (low === high) {
        minAndMaxPair[0] = a[0];
        minAndMaxPair[1] = a[0];
        return minAndMaxPair;
    }
    // If the length is 2
    if (high === low + 1) {
        minAndMaxPair[0] = Math.min(a[low], a[high]);
        minAndMaxPair[1] = Math.max(a[low], a[high]);
        return minAndMaxPair;
    }
    // If the length is greater than 2
    // Mid index
    const mid = low + Math.floor((high - low) / 2);
    // Recursively get the minimum and maximum elements of
    // two array halves
    const minAndMaxLeft = findMinAndMaxOptimallyHelper(a, low, mid);
    const minAndMaxRight = findMinAndMaxOptimallyHelper(a, mid, high);
    // Find the minimum and maximum from minimum and maximum
    // of both the halves
    minAndMaxPair[0] = Math.min(minAndMaxLeft[0], minAndMaxRight[0]);
    minAndMaxPair[1] = Math.max(minAndMaxLeft[1], minAndMaxRight[1]);
    return minAndMaxPair;
};

let minAndMax = findMinAndMaxNormally([1000, 11, 445, 1, 330, 3000])
console.log(`Min: ${minAndMax[0]}, Max: ${minAndMax[1]}`);
minAndMax = findMinAndMaxNormally([9, -2, 12, -21, 342, 67, -63, -32456, 43563, 212, 43546]);
console.log(`Min: ${minAndMax[0]}, Max: ${minAndMax[1]}`);
minAndMax = findMinAndMaxNormally([]);
console.log(`Min: ${minAndMax[0]}, Max: ${minAndMax[1]}`);

minAndMax = findMinAndMaxOptimally([1000, 11, 445, 1, 330, 3000])
console.log(`Min: ${minAndMax[0]}, Max: ${minAndMax[1]}`);
minAndMax = findMinAndMaxOptimally([9, -2, 12, -21, 342, 67, -63, -32456, 43563, 212, 43546]);
console.log(`Min: ${minAndMax[0]}, Max: ${minAndMax[1]}`);
minAndMax = findMinAndMaxOptimally([]);
console.log(`Min: ${minAndMax[0]}, Max: ${minAndMax[1]}`);