/**
 * @author Anirudh Sharma
 * 
 * Given two numbers x and y, and a range [l, r] where 1 <= l, r <= 32.
 * The task is consider set bits of y in range [l, r] and set these bits in x also.
 */
const copy = (x, y, l, r) => {
    // Base case
    if (l < 1 || r > 32) {
        return -1;
    }
    // Get the length of the mask
    let maskLength = (1 << (r - l + 1)) - 1;
    // Get the mask by shifting to the requested position
    // and "and" it with y
    let mask = ((maskLength) << (l - 1)) & y;
    x |= mask;
    return x;
};

const main = () => {
    let x = 10;
    let y = 13;
    let l = 2;
    let r = 3;
    console.log(copy(x, y, l, r));
};

main();