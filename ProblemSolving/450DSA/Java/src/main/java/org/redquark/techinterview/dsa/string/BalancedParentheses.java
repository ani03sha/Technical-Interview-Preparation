package org.redquark.techinterview.dsa.string;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an expression string x. Examine whether the pairs and the orders of "{","}","(",")","[","]"
 * are correct in exp.
 * <p>
 * For example, the function should return 'true' for exp = "[()]{}{[()()]()}" and 'false' for exp = "[(])".
 * <p>
 * Constraints:
 * 1 ≤ |x| ≤ 32000
 * <p>
 * Note: The drive code prints "balanced" if function return true, otherwise it prints "not balanced".
 */
public class BalancedParentheses {

    private static boolean isValidParentheses(String s) {
        // Special case
        if (s == null || s.isEmpty()) {
            return true;
        }
        // Stack to store the opening parentheses
        Stack<Character> openParentheses = new Stack<>();
        // Loop through the the entire string
        for (char c : s.toCharArray()) {
            // Check for the left parenthesis
            if (c == '(' || c == '{' || c == '[') {
                openParentheses.add(c);
            }
            // Check for the right parenthesis
            else if (c == ')' && !openParentheses.isEmpty() && openParentheses.peek() == '(') {
                openParentheses.pop();
            } else if (c == '}' && !openParentheses.isEmpty() && openParentheses.peek() == '{') {
                openParentheses.pop();
            } else if (c == ']' && !openParentheses.isEmpty() && openParentheses.peek() == '[') {
                openParentheses.pop();
            } else {
                return false;
            }
        }
        return openParentheses.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses("{([])}"));
        System.out.println(isValidParentheses("()"));
        System.out.println(isValidParentheses("([]"));
    }
}
