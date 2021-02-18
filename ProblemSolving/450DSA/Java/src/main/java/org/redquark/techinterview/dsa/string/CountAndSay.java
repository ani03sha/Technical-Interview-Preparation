package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
 * which is then converted into a different digit string.
 * <p>
 * To determine how you "say" a digit string, split it into the minimal number of groups
 * so that each group is a contiguous section all of the same character.
 * <p>
 * Then for each group, say the number of characters, then say the character.
 * <p>
 * To convert the saying into a digit string, replace the counts with a number
 * and concatenate every saying.
 * <p>
 * Constraints:
 * 1 <= n <= 30
 */
public class CountAndSay {

    private static String countAndSay(int n) {
        // Base case
        if (n <= 0) {
            return null;
        }
        // Initialize the result
        String result = "1";
        // Counter for the n
        int i = 1;
        // Loop until we reach n
        while (i < n) {
            // StringBuilder to store intermediate results
            StringBuilder sb = new StringBuilder();
            // Variable to count the number of occurrences of
            // the digit
            int count = 1;
            // Loop through the previous version of the string
            for (int j = 1; j < result.length(); j++) {
                // Check if contiguous characters are same
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                }
                // If the characters are not same, we will append
                // the string
                else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    // Reset the count to 1
                    count = 1;
                }
            }
            // For the last character
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(4));
    }
}
