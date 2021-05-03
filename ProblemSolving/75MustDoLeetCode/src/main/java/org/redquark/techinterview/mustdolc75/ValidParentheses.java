package org.redquark.techinterview.mustdolc75;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> leftParentheses = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                leftParentheses.add(c);
            } else if (c == ')' && !leftParentheses.isEmpty() && leftParentheses.peek() == '(') {
                leftParentheses.pop();
            } else if (c == '}' && !leftParentheses.isEmpty() && leftParentheses.peek() == '{') {
                leftParentheses.pop();
            } else if (c == ']' && !leftParentheses.isEmpty() && leftParentheses.peek() == '[') {
                leftParentheses.pop();
            } else {
                return false;
            }
        }
        return leftParentheses.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
    }
}
