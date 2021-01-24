/**
 * @author Anirudh Sharma
 * 
 * Given an integer, the task is to find factorial of the number.
 */
const findFactorial = (n) => {
    // The array to store the digits of factorial
    const factorial = new Array(2568);
    // Initialize the result
    factorial[0] = 1;
    // Number of digits
    let digits = 1;
    // Loop for 2 to n
    for (let i = 2; i <= n; i++) {
        digits = multiply(i, factorial, digits);
    }
    return factorial.slice(0, digits).reverse().join("");
};

const multiply = (value, factorial, digits) => {
    // Carry
    let carry = 0;
    // Multiply i with every element of factorial
    for (let i = 0; i < digits; i++) {
        // Product with current element
        let product = factorial[i] * value + carry;
        factorial[i] = product % 10;
        carry = parseInt(product / 10);
    }
    // Put carry in factorial and increase digits
    while (carry != 0) {
        factorial[digits] = carry % 10;
        carry = parseInt(carry / 10);
        digits++;
    }
    return digits;
};

console.log(findFactorial(10));
console.log(findFactorial(50));
console.log(findFactorial(100));
console.log(findFactorial(500));
console.log(findFactorial(1000));