/**
 * @author Anirudh Sharma
 * 
 * Given a two integers say a and b, find the quotient after dividing a by b without
 * using multiplication, division and mod operator.
 */
const divide = (A, B) => {
    if (A === -2147483648 && B === -1) {
        return 2147483647;
    }
    let quotient = 0, sign = 1
    if (A < 0) {
        A = -A;
        sign = -sign;
    }
    if (B < 0) {
        B = -B;
        sign = -sign;
    }
    if (A === B) {
        return sign;
    }
    for (let i = 0, val = B; A >= B; i = 0, val = B) {
        while (val > 0 && val <= A) {
            val = B << ++i;
        }
        A -= B << i - 1;
        quotient += 1 << i - 1;
    }
    return sign < 0 ? -quotient : quotient;
};

const main = () => {
    console.log(divide(10, 3));
    console.log(divide(-43, 8));
};

main();