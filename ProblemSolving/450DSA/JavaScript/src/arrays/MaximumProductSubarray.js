/**
 * @author Anirudh Sharma
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 */
const maxProduct = (nums) => {
    // Special cases
    if (nums === undefined || nums.length === 0) {
        return -1;
    }
    // Overall maximum product
    let globalMaxima = nums[0];
    // Maximum product until a given index
    let localMaxima = nums[0];
    // Minimum product until a given index
    let localMinima = nums[0];
    // Loop for the remaining elements in the array
    for (let i = 1; i < nums.length; i++) {
        // Save localMaxima for localMinima calculation
        let temp = localMaxima;
        localMaxima = Math.max(nums[i], Math.max(localMaxima * nums[i], localMinima * nums[i]));
        localMinima = Math.min(nums[i], Math.min(temp * nums[i], localMinima * nums[i]));
        globalMaxima = Math.max(localMaxima, globalMaxima);
    }
    return globalMaxima;
};


console.log(maxProduct([2, 3, -2, 4]));
console.log(maxProduct([-2, 0, -1]));
console.log(maxProduct([6, -3, -10, 0, 2]));
console.log(maxProduct([2, 3, 4, 5, -1, 0]));