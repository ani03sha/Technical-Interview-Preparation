/**
 * @author Anirudh Sharma
 * 
 * Given an array of integers. Find the Inversion Count in the array.
 * 
 * Inversion Count: For an array, inversion count indicates how far (or close) the array
 * is from being sorted. If array is already sorted then the inversion count is 0.
 * 
 * If an array is sorted in the reverse order then the inversion count is the maximum.
 * 
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 */
const inversionCount = (a) => {
    const auxiliary = [];
    return mergeSortAndCount(a, auxiliary, 0, a.length - 1);
};

const mergeSortAndCount = (a, auxiliary, low, high) => {
    // Count of inversions
    let count = 0;
    // Middle of the array
    let middle;
    // For valid indices
    if (low < high) {
        // Middle index
        middle = low + parseInt((high - low) / 2);
        // Left sub array count
        count += mergeSortAndCount(a, auxiliary, low, middle);
        // Right sub array count
        count += mergeSortAndCount(a, auxiliary, middle + 1, high);
        // Merge count
        count += merge(a, auxiliary, low, middle + 1, high);
    }
    return count;
};

const merge = (a, auxiliary, low, middle, high) => {
    // Index for left subarray
    let i = low;
    // Index for right subarray
    let j = middle;
    // Index for the auxiliary array
    let k = low;
    // Inversion count
    let count = 0;
    // Loop until there are elements in the left
    // and right subarrays
    while (i <= middle - 1 && j <= high) {
        if (a[i] <= a[j]) {
            auxiliary[k++] = a[i++];
        } else {
            auxiliary[k++] = a[j++];
            count += (middle - i);
        }
    }
    // Remaining elements of left subarray are copied
    while (i <= middle - 1) {
        auxiliary[k++] = a[i++];
    }
    // Remaining elements of right subarray are copied
    while (j <= high) {
        auxiliary[k++] = a[j++];
    }
    // Copy the auxiliary array into the main array
    for (let l = low; l <= high; l++) {
        a[l] = auxiliary[l];
    }
    return count;
};


console.log(inversionCount([2, 4, 1, 3, 5]));
console.log(inversionCount([2, 3, 4, 5, 6]));
console.log(inversionCount([10, 10, 10]));
console.log(inversionCount([4, 3, 2, 1]));