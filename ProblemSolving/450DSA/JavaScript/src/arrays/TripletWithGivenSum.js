/**
 * @author Anirudh Sharma
 * 
 * Given an array arr of size N and an integer K.
 * Find if there's a triplet in the array which sums up to the given integer K.
 * 
 * Constraints:
 * 1 ≤ N ≤ 10^3
 * 1 ≤ A[i] ≤ 10
 */
const doesTripletExist = (nums, K) => {
    // Base condition
    if (nums === null || nums.length < 3) {
        return false;
    }
    // Sort the array
    nums.sort((a, b) => a - b);
    // Loop through the array
    for (let i = 0; i < nums.length; i++) {
        // Left and right pointers
        let j = i + 1;
        let k = nums.length - 1;
        // Loop until two pointers meet
        while (j < k) {
            // Sum of the triplet
            let sum = nums[i] + nums[j] + nums[k];
            // Check for the sum
            if (sum === K) {
                return true;
            }
            // If the sum is less than K then we are too left
            // and need to move right
            else if (sum < K) {
                j++;
            }
            // If the sum is less than K then we are too right
            // and need to move left
            else {
                k--;
            }
        }
    }
    return false;
};


let arr = [1, 4, 45, 6, 10, 8];
let target = 13;
console.log(doesTripletExist(arr, target));

arr = [1, 2, 4, 3, 6];
target = 10;
console.log(doesTripletExist(arr, target));