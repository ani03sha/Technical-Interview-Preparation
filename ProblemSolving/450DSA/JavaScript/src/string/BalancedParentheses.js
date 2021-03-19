/**
 * @author Anirudh Sharma
 * 
 * Given an expression string x. Examine whether the pairs and the orders of "{","}","(",")","[","]"
 * are correct in exp.
 * 
 * For example, the function should return 'true' for exp = "[()]{}{[()()]()}" and 'false' for exp = "[(])".
 * 
 * Constraints:
 * 1 ≤ |x| ≤ 32000
 * 
 * Note: The drive code prints "balanced" if function return true, otherwise it prints "not balanced".
 */
const isValidParentheses = (s) => {
    // Special case
    if (!s) {
        return 0;
    }
    // Stack to store left symbols
    const openParentheses = [];
    // Loop for each character of the string
    for (let i = 0; i < s.length; i++) {
        // If left symbol is encountered
        if (s[i] === '(' || s[i] === '{' || s[i] === '[') {
            openParentheses.push(s[i]);
        }
        // If right symbol is encountered
        else if (s[i] === ')' && openParentheses.length !== 0 && openParentheses[openParentheses.length - 1] === '(') {
            openParentheses.pop();
        } else if (s[i] === '}' && openParentheses.length !== 0 && openParentheses[openParentheses.length - 1] === '{') {
            openParentheses.pop();
        } else if (s[i] === ']' && openParentheses.length !== 0 && openParentheses[openParentheses.length - 1] === '[') {
            openParentheses.pop();
        }
        // If none of the valid symbols is encountered
        else {
            return false;
        }
    }
    return openParentheses.length === 0;
};

const main = () => {
    console.log(isValidParentheses("{([])}"));
    console.log(isValidParentheses("()"));
    console.log(isValidParentheses("([]"));
}

main();