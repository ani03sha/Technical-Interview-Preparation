/**
 * @author Anirudh Sharma
 * 
 * Given an array of positive integers. We need to make the given array a ‘Palindrome’.
 * The only allowed operation is"merging" (of two adjacent elements).
 * Merging two adjacent elements means replacing them with their sum.
 * 
 * The task is to find the minimum number of merge operations required to make the
 * given array a ‘Palindrome’.
 */
const minimumMergeOperations = (nums) => {
    // Special cases
    if (nums === undefined || nums.length < 2) {
        return 0;
    }
    // Count of merge operations
    let mergeOperations = 0;
    // Left and right pointers
    let left = 0;
    let right = nums.length - 1;
    // Loop until both pointers meet
    while (left <= right) {
        // If both elements are equal then
        // we don't have to do anything
        if (nums[left] === nums[right]) {
            left++;
            right--;
        }
        // If left element is smaller than right
        else if (nums[left] < nums[right]) {
            nums[left + 1] += nums[left];
            left++;
            mergeOperations++;
        }
        // If right element is is smaller than left
        else if (nums[left] > nums[right]) {
            nums[right - 1] += nums[right];
            right--;
            mergeOperations++;
        }
    }
    return mergeOperations;
};


let arr = [15, 4, 15];
console.log(minimumMergeOperations(arr));

arr = [1, 4, 5, 1];
console.log(minimumMergeOperations(arr));

arr = [11, 14, 15, 99];
console.log(minimumMergeOperations(arr));