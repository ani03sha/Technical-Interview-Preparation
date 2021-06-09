/**
 * @author Anirudh Sharma
 * 
 * Given N integers and K, find the minimum number of elements that should be removed,
 * such that Amax-Amin<=K. After the removal of elements, Amax and Amin is considered
 * among the remaining elements.
 */
const minimumElementsRemoved = (nums, k) => {
    // Special cases
    if (nums === undefined || nums.length === 0) {
        return 0;
    }
    // Length of the array
    const n = nums.length;
    // Lookup table
    const lookup = new Array(n);
    // Fill with default values
    lookup.fill(-1);
    // Base initialization
    lookup[0] = 0;
    // In worst case, all the elements need to be removed
    // except one element
    let removedElements = n - 1;
    // Populate the lookup table
    for (let i = 1; i < n; i++) {
        lookup[i] = i;
        let j = lookup[i - 1];
        while (j !== i && nums[i] - nums[j] > k) {
            j++;
        }
        lookup[i] = Math.min(lookup[i], j);
        removedElements = Math.min(removedElements, n - (i - j + 1));
    }
    return removedElements;
};

const main = () => {
    let nums = [1, 3, 4, 9, 10, 11, 12, 17, 20];
    let k = 4;
    console.log(minimumElementsRemoved(nums, k));
};

main();