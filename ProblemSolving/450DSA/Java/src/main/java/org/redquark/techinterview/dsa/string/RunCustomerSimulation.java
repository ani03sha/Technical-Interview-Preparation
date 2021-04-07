package org.redquark.techinterview.dsa.string;

/**
 * @author Anirudh Sharma
 * <p>
 * Write a function "runCustomerSimulation" that takes following two inputs
 * a) An integer 'n': total number of computers in a cafe and a string:
 * b) A sequence of uppercase letters ‘seq’: Letters in the sequence occur in pairs.
 * The first occurrence indicates the arrival of a customer;
 * the second indicates the departure of that same customer.
 * <p>
 * A customer will be serviced if there is an unoccupied computer.
 * No letter will occur more than two times.
 * <p>
 * Customers who leave without using a computer always depart before customers who are
 * currently using the computers. There are at most 20 computers per cafe.
 * <p>
 * For each set of input the function should output a number telling how many customers,
 * if any walked away without using a computer.
 * <p>
 * Return 0 if all the customers were able to use a computer.
 */
public class RunCustomerSimulation {

    private static int runSimulation(int n, char[] sequence) {
        // Array to represents the states of a customer
        // customerStates[i] = 0 => customer i is not in cafe
        // customerStates[i] = 1 > customer i is in but with no computer
        // customerStates[i] = 2 => customer i is in cafe with computer
        int[] customerStates = new int[26];
        // Number of customers who won't get a computer
        int customerCount = 0;
        // Track of occupied computers
        int occupiedComputerCount = 0;
        // Loop through the sequence
        for (char c : sequence) {
            // Index of the current character
            int index = c - 'A';
            // If the customer is first time in the cafe
            if (customerStates[index] == 0) {
                // Change its state
                customerStates[index] = 1;
                // If the computer can be occupied
                if (occupiedComputerCount < n) {
                    // Give the computer to the customer
                    customerStates[index] = 2;
                    occupiedComputerCount++;
                } else {
                    // Since the computer can't be assigned
                    customerCount++;
                }
            }
            // If the customer is already in the cafe
            else {
                if (customerStates[index] == 2) {
                    occupiedComputerCount--;
                }
                customerStates[index] = 0;
            }
        }
        return customerCount;
    }

    public static void main(String[] args) {
        System.out.println(runSimulation(2, "ABBAJJKZKZ".toCharArray()));
        System.out.println(runSimulation(3, "GACCBDDBAGEE".toCharArray()));
        System.out.println(runSimulation(3, "GACCBGDDBAEE".toCharArray()));
        System.out.println(runSimulation(1, "ABCBCA".toCharArray()));
        System.out.println(runSimulation(1, "ABCBCADEED".toCharArray()));
    }
}
