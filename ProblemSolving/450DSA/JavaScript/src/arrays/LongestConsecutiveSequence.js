/**
 * @author Anirudh Sharma
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive
 * elements sequence.
 * 
 * Constraints:
 * 0 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * Follow up: Could you implement the O(n) solution?
 */
const longestConsecutive = (nums) => {
    // Special cases
    if (nums === undefined || nums.length < 1) {
        return 0;
    }
    // Variable to store the longest consecutive sequence
    let count = 0;
    // Set to store the elements of the array
    const uniqueElements = new Set();
    // Add all elements in the array to the set
    nums.forEach(item => uniqueElements.add(item));
    // Loop again to find the sequences
    for (let i = 0; i < nums.length; i++) {
        // Check if the previous number i.e., one smaller
        // is present in the set. If yes, then the current
        // element is a part of a sequence else it is the first
        // element in the sequence
        if (!uniqueElements.has(nums[i] - 1)) {
            // Get the current element
            let n = nums[i];
            // Check if next elements are in the set
            while (uniqueElements.has(n)) {
                n++;
            }
            // Update the maximum length
            count = Math.max(count, n - nums[i]);
        }
    }
    return count;
};

let arr = [100, 4, 200, 1, 3, 2];
console.log(longestConsecutive(arr));

arr = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1];
console.log(longestConsecutive(arr));

arr = [2, 6, 1, 9, 4, 5, 3];
console.log(longestConsecutive(arr));

arr = [1, 9, 3, 10, 4, 20, 2];
console.log(longestConsecutive(arr));