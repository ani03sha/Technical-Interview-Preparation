/**
 * @author Anirudh Sharma
 *
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
 *
 * Try to solve this problem in single pass with O(1) space
 */
const sort012 = (nums) => {
    // Start and end pointers
    let start = 0;
    let end = nums.length - 1;
    // Index to point current element
    let currentIndex = 0;
    // Loop through until the pointers meet
    while (currentIndex <= end && start < end) {
        // Check if the current element is 0
        if (nums[currentIndex] == 0) {
            // Put whatever at the start at the current index
            nums[currentIndex] = nums[start];
            nums[start] = 0;
            start++;
            currentIndex++;
        }
        // Check if the current element is 2
        else if (nums[currentIndex] == 2) {
            nums[currentIndex] = nums[end];
            nums[end] = 2;
            end--;
        }
        // If the current element is 1
        else {
            currentIndex++;
        }
    }
    return nums;
};


console.log(sort012([2, 0, 2, 1, 1, 0]));
console.log(sort012([2, 0, 1]));
console.log(sort012([1]));
console.log(sort012([0]));