package org.redquark.techinterview.ctci.stacksandqueues.additional;

import java.util.EmptyStackException;

/**
 * @author Anirudh Sharma
 * <p>
 * Describe how you could use a single array to implement two stacks
 */
public class TwoStacks {

    // Internal array
    private final int[] a;
    // Size of the internal array
    private final int size;
    // Tops of two stacks
    private int top1;
    private int top2;

    TwoStacks(int capacity) {
        this.size = capacity;
        this.a = new int[this.size];
        top1 = -1;
        top2 = size;
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(10);
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                twoStacks.push(1, i);
            } else {
                twoStacks.push(0, i);
            }
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("First stack: " + twoStacks.pop(0));
            System.out.println("Second stack: " + twoStacks.pop(1));
        }
    }

    public void push(int stackIndex, int value) {
        // Check if all the slots are full
        if (top1 + 1 == top2) {
            throw new StackOverflowError();
        }
        if (stackIndex == 0) {
            top1++;
            a[top1] = value;
        } else {
            top2--;
            a[top2] = value;
        }
    }

    public int pop(int stackIndex) {
        if (stackIndex == 0) {
            if (top1 == -1) {
                throw new EmptyStackException();
            } else {
                int top = a[top1];
                top1--;
                return top;
            }
        } else {
            if (top2 == size) {
                throw new EmptyStackException();
            } else {
                int top = a[top2];
                top2++;
                return top;
            }
        }
    }
}
