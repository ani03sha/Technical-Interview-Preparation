package org.redquark.techinterview.dsa.bitmanipulation;

/**
 * @author Anirudh Sharma
 * <p>
 * Given a number N having only one ‘1’ and all other ’0’s in its binary representation,
 * find position of the only set bit.
 * <p>
 * If there are 0 or more than 1 set bit the answer should be -1.
 * <p>
 * Position of  set bit '1' should be counted starting with 1 from LSB side in binary
 * representation of the number.
 */
public class FindPositionOfSetBit {

    private static int findPosition(int n) {
        return (n & (n - 1)) == 0 ? (int) (Math.log(n) / Math.log(2) + 1) : -1;
    }

    public static void main(String[] args) {
        System.out.println(findPosition(2));
        System.out.println(findPosition(8));
        System.out.println(findPosition(5));
    }
}
