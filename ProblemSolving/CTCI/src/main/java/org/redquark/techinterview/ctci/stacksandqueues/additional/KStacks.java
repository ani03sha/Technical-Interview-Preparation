package org.redquark.techinterview.ctci.stacksandqueues.additional;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement k stacks using single array
 */
public class KStacks {

    // Internal array to store stack data
    private final int[] data;
    // Array to store indices of top of all stacks
    private final int[] tops;
    // Array to store next entry of items in all stacks
    private final int[] next;
    // Starting index of free slots
    private int freeSlotIndex;

    public KStacks(int k, int capacity) {
        this.data = new int[capacity];
        this.tops = new int[k];
        this.next = new int[capacity];
        // Initialize all tops as -1
        Arrays.fill(tops, -1);
        // First free slot is 0
        this.freeSlotIndex = 0;
        // Next entries
        for (int i = 0; i < capacity - 1; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1;
    }

    public static void main(String[] args) {
        KStacks kStacks = new KStacks(3, 10);
        for (int i = 0; i < 10; i++) {
            kStacks.push(i % 3, i + 1);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(kStacks.pop(i % 3));
        }
    }

    public void push(int stackIndex, int value) {
        // Stack overflow check
        if (isFull()) {
            throw new StackOverflowError();
        }
        // Get the index of the first free slot
        int index = freeSlotIndex;
        // Update the value in the data;
        data[index] = value;
        // Update the next free slot index
        freeSlotIndex = next[index];
        // Update the next entry of the top
        next[index] = tops[stackIndex];
        // Update the top of the given stack
        tops[stackIndex] = index;
    }

    public int pop(int stackIndex) {
        // Check for empty stack
        if (isEmpty(stackIndex)) {
            throw new EmptyStackException();
        }
        // Get the index of the top of given stack
        int index = tops[stackIndex];
        // Get the value stored at the top of the specified stack
        int value = data[index];
        // Update the top of the specified stack
        tops[stackIndex] = next[index];
        // Set previous top to the free slots
        next[index] = freeSlotIndex;
        // And current index will now free
        freeSlotIndex = index;
        return value;
    }

    private boolean isFull() {
        return freeSlotIndex == -1;
    }

    private boolean isEmpty(int stackIndex) {
        return tops[stackIndex] == -1;
    }
}
