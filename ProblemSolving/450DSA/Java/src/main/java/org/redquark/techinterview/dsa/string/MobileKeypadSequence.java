package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a sentence in the form of a string, convert it into its equivalent mobile
 * numeric keypad sequence.
 */
public class MobileKeypadSequence {

    private static String convert(String input) {
        // Array to store all the possible combinations
        String[] inputMap = {
                "2", "22", "222",
                "3", "33", "333",
                "4", "44", "444",
                "5", "55", "555",
                "6", "66", "666",
                "7", "77", "777", "7777",
                "8", "88", "888",
                "9", "99", "999", "9999"
        };
        // String to store output
        StringBuilder output = new StringBuilder();
        // Loop through every character of the string
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                output.append("0");
            } else {
                output.append(inputMap[c - 'A']);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "ANIRUDH";
        System.out.println(convert(input));

        input = "RED QUARK";
        System.out.println(convert(input));
    }
}
