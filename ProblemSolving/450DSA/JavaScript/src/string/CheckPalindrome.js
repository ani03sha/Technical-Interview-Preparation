/**
 * Given a string S, check if it is palindrome or not.
 */
const isPalindrome = (s) => {
    let left = 0;
    let right = s.length - 1;
    while (left <= right) {
        if (s[left] !== s[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
};

const main = () => {
    let s = "abba";
    console.log(isPalindrome(s));

    s = "abc";
    console.log(isPalindrome(s));
}

main();