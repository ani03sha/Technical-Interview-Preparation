package org.redquark.techinterview.dsa.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a string s containing only digits, return all possible valid IP addresses that
 * can be obtained from s. You can return them in any order.
 * <p>
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255,
 * separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and
 * "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1"
 * are invalid IP addresses.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 3000
 * s consists of digits only
 */
public class RestoreIPAddresses {

    private static List<String> restoreIpAddresses(String s) {
        // List to store all the IP addresses
        List<String> ipAddresses = new ArrayList<>();
        // Array to store four parts of the IP address
        int[] ipAddressParts = new int[4];
        // Call the helper function to get the IP addresses
        getIPAddresses(s, ipAddresses, 0, ipAddressParts, 0);
        return ipAddresses;
    }

    private static void getIPAddresses(String s, List<String> ipAddresses, int currentIndex, int[] ipAddressParts, int segment) {
        // Base case when the current index is at the end of
        // the string and we have found all four segments
        if (segment == 4 && currentIndex == s.length()) {
            ipAddresses.add(ipAddressParts[0] + "." + ipAddressParts[1] + "." + ipAddressParts[2] + "." + ipAddressParts[3]);
            return;
        }
        // If either of the above conditions is met but not both
        else if (segment == 4 || currentIndex == s.length()) {
            return;
        }
        // Loop through the string to find the segments
        for (int i = 1; i <= 3 && currentIndex + i <= s.length(); i++) {
            // Get the current segment of string
            int value = Integer.parseInt(s.substring(currentIndex, currentIndex + i));
            // Check for the validity of value
            if (value > 255 || i >= 2 && s.charAt(currentIndex) == '0') {
                break;
            }
            // If valid, add it to the segment
            ipAddressParts[segment] = value;
            // Recurse for the next part of the string
            getIPAddresses(s, ipAddresses, currentIndex + i, ipAddressParts, segment + 1);
            ipAddressParts[segment] = -1;
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));

        s = "0000";
        System.out.println(restoreIpAddresses(s));

        s = "1111";
        System.out.println(restoreIpAddresses(s));

        s = "010010";
        System.out.println(restoreIpAddresses(s));

        s = "101023";
        System.out.println(restoreIpAddresses(s));
    }
}
