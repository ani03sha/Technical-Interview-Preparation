/**
 * @author Anirudh Sharma
 * 
 * Given an array of positive and negative numbers.
 * Find if there is a subarray (of size at-least one) with 0 sum.
 */
const doesZeroSumExist = (A) => {
    // Set to store the cumulative sum
    const cumulativeSum = new Set();
    // Cumulative sum
    let sum = 0;
    // Loop through all the elements in the array
    for (let i = 0; i < A.length; i++) {
        sum += A[i];
        if (A[i] === 0 || sum === 0 || cumulativeSum.has(sum)) {
            return true;
        }
        cumulativeSum.add(sum);
    }
    return false;
};


let a = [4, 2, -3, 1, 6];
console.log(doesZeroSumExist(a));

a = [4, 2, 0, 1, 6];
console.log(doesZeroSumExist(a));