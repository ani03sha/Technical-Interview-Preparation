/**
 * @author Anirudh Sharma
 * 
 * Given an integer n, calculate the square of a number without using *, / and pow().
 */
const findSquare = (n) => {
    // Special case
    if (n === 0) {
        return 0;
    }
    // For negative numbers
    if (n < 0) {
        n = -n;
    }
    // Get floor(n/2) using right shift
    let x = n >> 1;
    // Check for even and odd
    if (n % 2 === 0) {
        return (findSquare(x) << 2);
    } else {
        return (findSquare(x) << 2) + (x << 2) + 1;
    }
};

const main = () => {
    console.log(findSquare(5));
    console.log(findSquare(38));
    console.log(findSquare(-63));
};

main();