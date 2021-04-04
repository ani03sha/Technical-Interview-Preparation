package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string 'S'. The task is to find the smallest window length that contains all
 * the characters of the given string at least one time.
 * For eg. A = "aabcbcdbca", then the result would be 4 as of the smallest window
 * will be "dbca".
 * <p>
 * Constraints:
 * 1 ≤ |S| ≤ 10^5
 * String may contain both type of English Alphabets.
 */
public class SmallestDistinctWindow {

    private static String findSubstring(String S) {
        // Array to check if a character is visited
        boolean[] visited = new boolean[256];
        // Count of distinct characters
        int distinctCharacterCount = 0;
        // Loop through the array
        for (char c : S.toCharArray()) {
            if (!visited[c]) {
                visited[c] = true;
                distinctCharacterCount++;
            }
        }
        // Minimum length of the window
        int minimumLength = Integer.MAX_VALUE;
        // Start of the window
        int start = 0;
        // Index where the desired window starts
        int startIndex = -1;
        // Count of distinct characters matched
        int count = 0;
        // Frequency map of characters
        int[] frequencyMap = new int[256];
        // Loop over the string
        for (int i = 0; i < S.length(); i++) {
            // Update the frequency of this character
            frequencyMap[S.charAt(i)]++;
            // If any distinct character is found,
            // update the count
            if (frequencyMap[S.charAt(i)] == 1) {
                count++;
            }
            // If all the characters are matched
            if (count == distinctCharacterCount) {
                // Now, we will minimize the window by
                // discarding a character that is occuring
                // more than once
                while (frequencyMap[S.charAt(start)] > 1) {
                    if (frequencyMap[S.charAt(start)] > 1) {
                        frequencyMap[S.charAt(start)]--;
                    }
                    start++;
                }
                // Update the window size
                int windowSize = i - start + 1;
                if (minimumLength > windowSize) {
                    minimumLength = windowSize;
                    startIndex = start;
                }
            }
        }
        return S.substring(startIndex, startIndex + minimumLength);
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("AABBBCBBAC"));
        System.out.println(findSubstring("aaab"));
    }
}
