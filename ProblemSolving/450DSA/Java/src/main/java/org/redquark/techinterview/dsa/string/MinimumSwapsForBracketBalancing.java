package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets.
 * <p>
 * A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2
 * are balanced strings.
 * <p>
 * We can make an unbalanced string balanced by swapping adjacent characters.
 * <p>
 * Calculate the minimum number of swaps necessary to make a string balanced.
 * <p>
 * Note - Strings S1 and S2 can be empty.
 */
public class MinimumSwapsForBracketBalancing {

    private static int minimumNumberOfSwaps(String S) {
        // Number of swaps required
        int swaps = 0;
        // Special case
        if (S == null || S.isEmpty()) {
            return swaps;
        }
        // Variable to track open brackets
        int openBrackets = 0;
        // Loop through the string
        for (char c : S.toCharArray()) {
            // If we encounter the left bracket,
            // we will increment the count
            if (c == '[') {
                openBrackets++;
            }
            // If we encounter the right bracket,
            // then any of the two conditions can
            // happen
            else {
                // If there are open brackets to the
                // left of the current bracket,
                // close the last encountered open
                // bracket
                if (openBrackets != 0) {
                    openBrackets--;
                }
                // If not, we will have to perform
                // swap
                else {
                    swaps++;
                    // Reset the count of open brackets
                    openBrackets = 1;
                }
            }
        }
        // We will need n/2 inversions for extra open brackets
        // to make the string balanced
        return swaps + openBrackets / 2;
    }

    public static void main(String[] args) {
        String S = "[]][][";
        System.out.println(minimumNumberOfSwaps(S));

        S = "[[][]]";
        System.out.println(minimumNumberOfSwaps(S));

        S = "][][][";
        System.out.println(minimumNumberOfSwaps(S));
    }
}
