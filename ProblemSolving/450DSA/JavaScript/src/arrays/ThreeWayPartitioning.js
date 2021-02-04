/**
 * Given an array of size N and a range [a, b]. The task is to partition the array around the range
 * such that array is divided into three parts.
 * 1) All elements smaller than a come first.
 * 2) All elements in range a to b come next.
 * 3) All elements greater than b appear in the end.
 * 
 * The individual elements of three sets can appear in any order. You are required to return the
 * modified array.
 */
const threeWayPartition = (nums, a, b) => {
    // Left and right pointers
    let left = 0;
    let right = nums.length - 1;
    // Loop for elements in the array
    for (let i = 0; i <= right;) {
        // If the current element is less
        // than a
        if (nums[i] < a) {
            swap(nums, i, left);
            i++;
            left++;
        }
        // If the current element is greater
        // than b
        else if (nums[i] > b) {
            swap(nums, i, right);
            right--;
        }
        // If the current element is in the
        // range a,b
        else {
            i++;
        }
    }
    return nums;
};

const swap = (nums, i, j) => {
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
};


let numsArray = [1, 2, 3, 3, 4];
let A = 1;
let B = 2;
console.log(threeWayPartition(numsArray, A, B));

numsArray = [1, 2, 3];
A = 1;
B = 3;
console.log(threeWayPartition(numsArray, A, B));

numsArray = [87, 78, 16, 94];
A = 36;
B = 72;
console.log(threeWayPartition(numsArray, A, B));