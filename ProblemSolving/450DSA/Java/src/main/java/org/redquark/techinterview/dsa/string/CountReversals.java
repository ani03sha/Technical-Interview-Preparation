package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string S consisting only of opening and closing curly brackets '{' and '}'
 * find out the minimum number of reversals required to make a balanced expression.
 * <p>
 * If it cannot be balanced, then print -1.
 */
public class CountReversals {

    private static int count(String s) {
        // Length of the string
        int n = s.length();
        // If the length is odd then we cannot make
        // balanced expression
        if (n % 2 == 1) {
            return -1;
        }
        // Count of left and right braces
        int leftBraceCount = 0;
        int rightBraceCount = 0;
        // Loop through the string
        for (int i = 0; i < n; i++) {
            // Current character
            char c = s.charAt(i);
            if (c == '{') {
                leftBraceCount++;
            } else {
                if (leftBraceCount == 0) {
                    rightBraceCount++;
                } else {
                    leftBraceCount--;
                }
            }
        }
        return (int) (Math.ceil(leftBraceCount / 2.0) + Math.ceil(rightBraceCount / 2.0));
    }

    public static void main(String[] args) {
        String s = "}{{}}{{{";
        System.out.println(count(s));

        s = "{{}}}}";
        System.out.println(count(s));

        s = "{{}{{{}{{}}{{";
        System.out.println(count(s));

        s = "{{{{}}}}";
        System.out.println(count(s));
    }
}
