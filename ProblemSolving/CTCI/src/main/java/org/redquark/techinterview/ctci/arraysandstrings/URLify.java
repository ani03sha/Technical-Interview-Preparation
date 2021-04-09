package org.redquark.techinterview.ctci.arraysandstrings;

/**
 * @author Anirudh Sharma
 * <p>
 * Write a method to replace all spaces in a string with '%20'.
 * <p>
 * Assume that the space has sufficient space at the end to hold
 * additional characters, and that we are given the true length
 * of the string
 */
public class URLify {

    private static String makeUrlify(char[] s) {
        // Count of spaces
        int spaceCount = 0;
        // Actual number of characters
        int actualLength = s.length;
        // Loop through the string
        for (char c : s) {
            // Increment the count of spaces
            // This will also include the spaces at the end
            if (c == ' ') {
                spaceCount++;
            }
        }
        // Loop through the characters array from the end
        // until a non space character is found
        while (s[actualLength - 1] == ' ') {
            spaceCount--;
            actualLength--;
        }
        // Last index of the modified string will be
        int index = actualLength + spaceCount * 2;
        // If the actual length is less than the char array
        // then we will remove the extra spaces from the end
        if (actualLength < s.length) {
            s[actualLength] = '\0';
        }
        // Now loop through the array backwards
        for (int i = actualLength - 1; i >= 0; i--) {
            // If space is found replace it with %20
            if (s[i] == ' ') {
                s[index - 1] = '0';
                s[index - 2] = '2';
                s[index - 3] = '%';
                index -= 3;
            }
            // If a normal character is found
            else {
                s[index - 1] = s[i];
                index--;
            }
        }
        return new String(s);
    }

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        System.out.println(makeUrlify(s.toCharArray()));

        s = "ab cd ef gh      ";
        System.out.println(makeUrlify(s.toCharArray()));
    }
}
