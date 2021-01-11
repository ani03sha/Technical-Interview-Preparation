/**
 * @author Anirudh Sharma
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 */
const findDuplicate = (nums) => {
    // Slow and fast pointers
    let slow = nums[0];
    let fast = nums[0];
    // Move slow pointer one state ahead
    slow = nums[slow];
    // Move fast pointer two states ahead
    fast = nums[nums[fast]];
    // Loop until the two pointers meet
    while (slow != fast) {
        // Move the slow pointer one step ahead and fast pointer two states ahead
        slow = nums[slow];
        fast = nums[nums[fast]];
    }
    // Move slow pointer to the start of the array
    slow = nums[0];
    // Loop until the two pointers meet
    while (slow != fast) {
        // Move both pointers one step at a time
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
};


console.log(findDuplicate([1, 3, 4, 2, 2]));
console.log(findDuplicate([3, 1, 3, 4, 2]));
console.log(findDuplicate([1, 1]));
console.log(findDuplicate([1, 1, 2]));