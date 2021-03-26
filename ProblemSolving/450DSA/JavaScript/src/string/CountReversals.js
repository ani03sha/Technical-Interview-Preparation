/**
 * @author Anirudh Sharma
 * 
 * Given a string S consisting only of opening and closing curly brackets '{' and '}'
 * find out the minimum number of reversals required to make a balanced expression.
 * 
 * If it cannot be balanced, then print -1.
 */
const count = (s) => {
    // Length of the string
    const n = s.length;
    // If the length is odd then we cannot make
    // balanced expression
    if (n % 2 === 1) {
        return -1;
    }
    // Count of left and right braces
    let leftBraceCount = 0;
    let rightBraceCount = 0;
    // Loop through the string
    for (let i = 0; i < n; i++) {
        // Current character
        let c = s.charAt(i);
        if (c === '{') {
            leftBraceCount++;
        } else {
            if (leftBraceCount === 0) {
                rightBraceCount++;
            } else {
                leftBraceCount--;
            }
        }
    }
    return (Math.ceil(leftBraceCount / 2.0) + Math.ceil(rightBraceCount / 2.0));
};

const main = () => {
    let s = "}{{}}{{{";
    console.log(count(s));

    s = "{{}}}}";
    console.log(count(s));

    s = "{{}{{{}{{}}{{";
    console.log(count(s));

    s = "{{{{}}}}";
    console.log(count(s));
};

main();