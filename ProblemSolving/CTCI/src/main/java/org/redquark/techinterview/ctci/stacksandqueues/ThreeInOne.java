package org.redquark.techinterview.ctci.stacksandqueues;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Anirudh Sharma
 * <p>
 * Describe how you could use a single array to implement three stacks
 */
public class ThreeInOne {

    private final int[] a;
    private final int stackCapacity;
    private final int[] stacks;

    public ThreeInOne(int stackSize) {
        this.stackCapacity = stackSize;
        this.stacks = new int[3];
        this.a = new int[3 * stackSize];
    }

    public static void main(String[] args) {
        ThreeInOne threeInOne = new ThreeInOne(5);
        for (int i = 0; i < 15; i++) {
            threeInOne.push(i % 3, i + 1);
        }
        System.out.println(Arrays.toString(threeInOne.a));
        try {
            threeInOne.push(0, 15);
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 15; i++) {
            System.out.print(threeInOne.pop(i % 3) + " ");
        }
        try {
            threeInOne.pop(1);
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
    }

    public void push(int stackIndex, int value) {
        if (isFull(stackIndex)) {
            throw new StackOverflowError();
        }
        // Update the pointer of the stack corresponding to
        // the stack index. It will store the top of the stack
        stacks[stackIndex]++;
        a[indexOfTop(stackIndex)] = value;
    }

    public int pop(int stackIndex) {
        if (isEmpty(stackIndex)) {
            throw new EmptyStackException();
        }
        // Get the top of the corresponding stack
        int topIndex = indexOfTop(stackIndex);
        int top = a[topIndex];
        // Reset the top
        a[topIndex] = 0;
        // Reduce the size of corresponding stack
        stacks[stackIndex]--;
        return top;
    }

    public int peek(int stackIndex) {
        if (isEmpty(stackIndex)) {
            throw new EmptyStackException();
        }
        return a[indexOfTop(stackIndex)];
    }

    public boolean isEmpty(int stackIndex) {
        return stacks[stackIndex] == 0;
    }

    public boolean isFull(int stackIndex) {
        return stacks[stackIndex] == stackCapacity;
    }

    public int indexOfTop(int stackIndex) {
        // Since this is a fixed length stack, the elements
        // in the stack will start from 0, stackCapacity, stackCapacity * 2
        int offset = stackIndex * stackCapacity;
        // Get size of the current stack
        int size = stacks[stackIndex];
        return offset + size - 1;
    }
}
