/**
 * @author Anirudh Sharma
 *
 *         Given an array arr[] and a number K where K is smaller than size of
 *         array, the task is to find the Kth smallest element in the given
 *         array. It is given that all array elements are distinct.
 */
const findKthSmallest = (nums, k) => {
    return findKthSmallestHelper(nums, k, 0, nums.length - 1);
};

const findKthSmallestHelper = (nums, k, left, right) => {
    // Base case i.e. there is single element
    if (left == right) {
        return nums[left];
    }
    // Find the pivot index
    const pivotIndex = partitionSmallest(nums, left, right);
    // Number of elements in the left of the array
    const countLeft = pivotIndex - left + 1;
    // Check for various cases
    // If the number of elements in left is equal to k
    // then pivot is the required element
    if (countLeft == k) {
        return nums[pivotIndex];
    }
    // If number of elements in left is greater than k
    // then we need to move pivot to the left
    else if (countLeft > k) {
        return findKthSmallestHelper(nums, k, left, pivotIndex - 1);
    }
    // If the number of elements in left is less than k
    // then we need to move pivot to the right
    else {
        return findKthSmallestHelper(nums, k - pivotIndex + left - 1, pivotIndex + 1, right);
    }
};

const partitionSmallest = (nums, left, right) => {
    // Choosing right most element as the pivot
    const pivot = nums[right];
    // Index to determine the position of last element
    // that should occur before pivot
    let i = left - 1;
    // Loop through the array (until right - 1)
    for (let j = left; j < right; j++) {
        // If current element is less than or equal to the pivot
        // then swap
        if (nums[j] <= pivot) {
            i++;
            swap(nums, i, j);
        }
    }
    // Swap again
    swap(nums, i + 1, right);
    return i + 1;
};

const findKthLargest = (nums, k) => {
    return findKthLargestHelper(nums, k - 1, 0, nums.length - 1);
};

const findKthLargestHelper = (nums, k, left, right) => {
    // Base case i.e. there is single element
    if (k < left || k > right) {
        return -1;
    }
    // Find the pivot index
    let pivotIndex = partitionLargest(nums, left, right);
    // Check for various cases
    // If the number of elements in left is equal to k
    // then pivot is the required element
    if (pivotIndex == k) {
        return nums[pivotIndex];
    }
    // If number of elements in left is greater than k
    // then we need to move pivot to the left
    else if (pivotIndex > k) {
        return findKthLargestHelper(nums, k, left, pivotIndex - 1);
    }
    // If the number of elements in left is less than k
    // then we need to move pivot to the right
    else {
        return findKthLargestHelper(nums, k, pivotIndex + 1, right);
    }
};

const partitionLargest = (nums, left, right) => {
    // Choosing right most element as the pivot
    const pivot = nums[right];
    // Index to determine the position of last element
    // that should occur before pivot
    let i = left;
    // Loop through the array (until right - 1)
    for (let j = left; j < right; j++) {
        // If current element is less than or equal to the pivot
        // then swap
        if (nums[j] > pivot) {
            swap(nums, j, i++);
        }
    }
    // Swap again
    swap(nums, i, right);
    return i;
};

const swap = (nums, i, j) => {
    const temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
};


console.log(findKthSmallest([7, 10, 4, 3, 20, 15], 3));
console.log(findKthSmallest([7, 10, 4, 20, 15], 3));
console.log(findKthLargest([7, 10, 4, 3, 20, 15], 3));
console.log(findKthLargest([7, 10, 4, 20, 15], 1));