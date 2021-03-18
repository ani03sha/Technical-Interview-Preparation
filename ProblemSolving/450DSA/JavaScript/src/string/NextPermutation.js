/**
 * @author Anirudh Sharma
 * 
 * Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater
 * permutation of list of numbers.
 * 
 * If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted
 * in an ascending order. You are given an list of numbers arr[ ] of size N.
 * 
 * Constraints:
 * 1 ≤ N ≤ 10000
 */
const nextPermutation = (nums) => {
    // Length of the array
    const n = nums.length;
    // Index of the first element which is smaller
    // than the element to its right
    let index = -1;
    // Loop from right to left
    for (let i = n - 1; i > 0; i--) {
        if (nums[i] > nums[i - 1]) {
            index = i - 1;
            break;
        }
    }
    // Base condition
    if (index === -1) {
        reverse(nums, 0, n - 1);
        return nums;
    }
    let j = n - 1;
    // Again swap from right to left to find first element
    // that is greater than the above find element
    for (let i = n - 1; i >= index + 1; i--) {
        if (nums[i] > nums[index]) {
            j = i;
            break;
        }
    }
    // Swap the elements
    swap(nums, index, j);
    // Reverse the array
    reverse(nums, index + 1, n - 1);
    return nums;
};

const reverse = (nums, i, j) => {
    while (i < j) {
        swap(nums, i, j);
        i++;
        j--;
    }
};

const swap = (nums, i, j) => {
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
};

const main = () => {
    const nums = [1, 2, 3, 6, 5, 4];
    console.log(nextPermutation(nums));
};

main();