/**
 * @author Anirudh Sharma
 * 
 * Given an array of size n, find all elements in array that appear more than n/k times.
 */
const findElements = (nums, k) => {
    // Special cases
    if (nums === undefined || nums.length < 1) {
        return [];
    }
    // Length of the array
    const n = nums.length;
    // List to store the result
    const result = [];
    if (k < 2) {
        nums.forEach(item => result.push(item));
        return result;
    }
    // Create an array of size k - 1 of type Element.
    // The number of elements in the output cannot be
    // more than k - 1
    const elements = new Array(k - 1);
    // Fill the array and set count of every element 0
    for (let i = 0; i < k - 1; i++) {
        elements[i] = new Element(0, 0);
        elements[i].count = 0;
    }
    // Process all elements in the given array
    nums.forEach(num => {
        // If current element num is already
        // present in the array then increment
        // its count
        let j;
        for (j = 0; j < k - 1; j++) {
            if (num === elements[j].value) {
                elements[j].count += 1;
                break;
            }
        }
        // If the current element is not present in the
        // elements array
        if (j == k - 1) {
            // If there is position available in elements
            // then place nums[i] there and set its count
            // to 1.
            let l;
            for (l = 0; l < k - 1; l++) {
                if (elements[l].count == 0) {
                    elements[l].value = num;
                    elements[l].count = 1;
                    break;
                }
            }
            // If all the positions are filled,
            // then decrement the count of every
            // element by 1
            if (l == k - 1) {
                for (l = 0; l < k - 1; l++) {
                    elements[l].count -= 1;
                }
            }
        }
    });
    // Check in elements for items which have count
    // more than n/k
    for (let i = 0; i < k - 1; i++) {
        // Actual count of elements
        let actualCount = 0;
        nums.forEach(item => {
            if (item == elements[i].value) {
                actualCount++;
            }
        });
        if (actualCount > parseInt(n / k)) {
            result.push(elements[i].value);
        }
    }
    return result;
};

function Element(value, count) {
    this.value = value;
    this.count = count;
}


let arr = [4, 5, 6, 7, 8, 4, 4];
let K = 3;
console.log(findElements(arr, K));

arr = [4, 2, 2, 7];
K = 3;
console.log(findElements(arr, K));

arr = [2, 7, 2];
K = 2;
console.log(findElements(arr, K));

arr = [2, 3, 3, 2];
K = 3;
console.log(findElements(arr, K));