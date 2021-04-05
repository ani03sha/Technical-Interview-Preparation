package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given two strings S and P. Find the smallest window in the S consisting of all the characters of P.
 * <p>
 * Constraints:
 * 1 ≤ |S|, |P| ≤ 10^5
 */
public class SmallestWindowContainingAllCharactersOfAnotherString {

    private static String smallestWindow(String S, String P) {
        // Lengths of both the strings
        int sLength = S.length();
        int pLength = P.length();
        // Special case
        if (sLength < pLength) {
            return "";
        }
        // Frequency maps for characters of both the strings
        int[] pFrequencyMap = new int[256];
        int[] sFrequencyMap = new int[256];
        // Populate P's frequency map
        for (char c : P.toCharArray()) {
            pFrequencyMap[c]++;
        }
        // Start of the window
        int start = 0;
        // Index where the desired window starts
        int startIndex = -1;
        // Minimum length of the window
        int minimumLength = Integer.MAX_VALUE;
        // Count of distinct characters matched
        int count = 0;
        // Loop through S
        for (int i = 0; i < sLength; i++) {
            // Populate S' frequency map
            sFrequencyMap[S.charAt(i)]++;
            // If S' character and P's characters match
            if (sFrequencyMap[S.charAt(i)] <= pFrequencyMap[S.charAt(i)]) {
                count++;
            }
            // If all characters are matched
            if (count == pLength) {
                // Try to minimize the window
                while (sFrequencyMap[S.charAt(start)] > pFrequencyMap[S.charAt(start)]
                        || pFrequencyMap[S.charAt(start)] == 0) {
                    if (sFrequencyMap[S.charAt(start)] > pFrequencyMap[S.charAt(start)]) {
                        sFrequencyMap[S.charAt(start)]--;
                    }
                    start++;
                }
                // Update window size
                int windowLength = i - start + 1;
                if (minimumLength > windowLength) {
                    minimumLength = windowLength;
                    startIndex = start;
                }
            }
        }
        // If no window found
        if (startIndex == -1) {
            return "";
        }
        return S.substring(startIndex, startIndex + minimumLength);
    }

    public static void main(String[] args) {
        String S = "timetopractice";
        String P = "toc";
        System.out.println(smallestWindow(S, P));

        S = "zoomlazapzo";
        P = "oza";
        System.out.println(smallestWindow(S, P));
    }
}
