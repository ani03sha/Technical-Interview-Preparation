package org.redquark.techinterview.ctci.arraysandstrings;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement and algorithm to determine if a string has all unique characters.
 * What if we cannot use additional data structures?
 */
public class IsUnique {

    /**
     * This method uses a boolean array as data structure
     *
     * @param s - input string to be searched
     * @return true, if all characters are unique, false otherwise
     */
    private static boolean checkUniqueOne(String s) {
        // Array to store the already visited characters
        boolean[] visited = new boolean[256];
        // Loop through the string
        for (char c : s.toCharArray()) {
            // If visited[c] is true, it means we have
            // encountered this character before
            if (visited[c]) {
                return false;
            }
            // Mark the character as visited
            visited[c] = true;
        }
        return true;
    }

    /**
     * This method doesn't use any additional data structure
     *
     * @param s - input string to be searched
     * @return true, if all characters are unique, false otherwise
     */
    private static boolean checkUniqueTwo(String s) {
        // Sort the string
        s = s.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        // Loop until we find same characters consecutively
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcdefa";
        System.out.println(checkUniqueOne(s));
        System.out.println(checkUniqueTwo(s));

        s = "123";
        System.out.println(checkUniqueOne(s));
        System.out.println(checkUniqueTwo(s));

        s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(checkUniqueOne(s));
        System.out.println(checkUniqueTwo(s));
    }
}
