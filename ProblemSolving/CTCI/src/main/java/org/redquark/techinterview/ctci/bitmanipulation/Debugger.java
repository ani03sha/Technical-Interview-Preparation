package org.redquark.techinterview.ctci.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Explain what the following code does: ((n & (n -1)) == 0) .
 */
public class Debugger {

    private static boolean debug(int n) {
        // n & (n - 1) == 0 checks if n is a powe of two or not
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(debug(64));
        System.out.println(debug(1048576));
        System.out.println(debug(24));
        System.out.println(debug(23367780));
    }
}
