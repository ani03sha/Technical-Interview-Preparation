/**
 * @author Anirudh Sharma
 * 
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input
 * array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 */
const reverse = (s) => {
    // Left and right pointers
    let left = 0;
    let right = s.length - 1;
    // Loop until the two pointers meet
    while (left <= right) {
        // Swap the left and right characters
        let c = s[left];
        s[left] = s[right];
        s[right] = c;
        // Update the pointers
        left++;
        right--;
    }
    return s.join("");
};

const main = () => {
    let s = ["h", "e", "l", "l", "o"];
    console.log(reverse(s));

    s = ["H", "a", "n", "n", "a", "h"];
    console.log(reverse(s));
};

main();