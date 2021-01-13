/**
 * @author Anirudh Sharma
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional
 * elements from nums2.
 */
const merge = (nums1, nums2) => {
    // Variable to define the length of the final
    // sorted array
    let index = nums1.length - 1;
    // Length of the individual arrays
    let m = nums1.length - nums2.length;
    let n = nums2.length;
    // Decrement m and n by one to get the last index of
    // the respective arrays
    --m;
    --n;
    // Loop until there are elements in any one array
    while (m >= 0 && n >= 0) {
        // If nums1 has greater current element
        if (nums1[m] > nums2[n]) {
            nums1[index] = nums1[m];
            m--;
        } else {
            nums1[index] = nums2[n];
            n--;
        }
        index--;
    }
    // Check for nums2 in case some elements are left
    while (n >= 0) {
        nums1[index] = nums2[n];
        n--;
        index--;
    }
    return nums1;
};

let numbers1 = [1, 2, 3, 0, 0, 0]
let numbers2 = [2, 5, 6]
console.log(merge(numbers1, numbers2))

numbers1 = [1]
numbers2 = []
console.log(merge(numbers1, numbers2))

numbers1 = [0, 0]
numbers2 = [1]
console.log(merge(numbers1, numbers2))

numbers1 = [1, 3, 5, 7, 0, 0, 0, 0, 0]
numbers2 = [0, 2, 6, 8, 9]
console.log(merge(numbers1, numbers2))