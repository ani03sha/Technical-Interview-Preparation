package org.redquark.techinterview.dsa.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string in roman no format(s) your task is to convert it to an integer.
 * Various symbols and their values are given below.
 */
public class RomanToInteger {

    private static int romanToInteger(String s) {
        // Map to store romans numerals
        Map<Character, Integer> romanMap = new HashMap<>();
        // Fill the map
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        // Length of the given string
        int n = s.length();
        // Variable to store result
        int decimal = romanMap.get(s.charAt(n - 1));
        // Loop for each character from right to left
        for (int i = n - 2; i >= 0; i--) {
            // Check if the character at right of current character is
            // bigger or smaller
            if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i + 1))) {
                decimal += romanMap.get(s.charAt(i));
            } else {
                decimal -= romanMap.get(s.charAt(i));
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("V"));
        System.out.println(romanToInteger("III"));

    }
}
