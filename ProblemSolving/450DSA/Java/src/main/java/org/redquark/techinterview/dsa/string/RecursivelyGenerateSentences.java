package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a list of word lists, print all sentences possible taking one word from a list at a time via recursion
 */
public class RecursivelyGenerateSentences {

    private static void generateSentences(String[][] words) {
        // List to store the result
        String[] sentences = new String[words.length];
        // Consider all words for first row as starting
        // point and generate all sentences
        for (int i = 0; i < words[0].length; i++) {
            if (!words[0][i].equals("")) {
                generateSentencesHelper(words, 0, i, sentences);
            }
        }
    }

    private static void generateSentencesHelper(String[][] words, int i, int j, String[] sentences) {
        // Add current word to the sentences list
        sentences[i] = words[i][j];
        // If this is the last word of the current output
        // sequence, then print it
        if (i == words.length - 1) {
            for (int k = 0; k < words.length; k++) {
                System.out.print(sentences[k] + " ");
            }
            System.out.println();
            return;
        }
        // Recur for next row
        for (int k = 0; k < words[0].length; k++) {
            if (!words[i + 1][k].equals("")) {
                generateSentencesHelper(words, i + 1, k, sentences);
            }
        }
    }

    public static void main(String[] args) {
        String[][] words = {{"you", "we", ""},
                {"have", "are", ""},
                {"sleep", "eat", "drink"}};
        generateSentences(words);
    }
}
