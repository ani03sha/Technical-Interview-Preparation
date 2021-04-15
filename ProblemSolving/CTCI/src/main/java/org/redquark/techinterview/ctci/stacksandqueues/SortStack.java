package org.redquark.techinterview.ctci.stacksandqueues;

import java.util.Random;
import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Sort a stack such that the smallest items are on the top.
 * <p>
 * You can use an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array).
 * <p>
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class SortStack {

    private static void sort(Stack<Integer> input) {
        // Buffer stack
        Stack<Integer> buffer = new Stack<>();
        // Push elements from input stack to the buffer stack
        // as long as input is not empty and the top of buffer
        // is greater than the top element obtained before
        while (!input.isEmpty()) {
            // Pop the element from the input stack
            int top = input.pop();
            while (!buffer.isEmpty() && top < buffer.peek()) {
                input.push(buffer.pop());
            }
            buffer.push(top);
        }
        // Copy the elements back to the input stack
        while (!buffer.isEmpty()) {
            input.push(buffer.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            input.push(random.nextInt(10) + 1);
        }
        System.out.println("Stack before sorting: " + input);
        sort(input);
        System.out.println("Stack after sorting: " + input);
    }
}
