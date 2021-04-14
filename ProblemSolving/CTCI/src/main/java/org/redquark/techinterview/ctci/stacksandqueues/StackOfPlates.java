package org.redquark.techinterview.ctci.stacksandqueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * <p>
 * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks
 * and should create a new stack once the previous one exceeds capacity.
 * <p>
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop () should
 * return the same values as it would if there were just a single stack).
 * <p>
 * FOLLOW UP
 * Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
 */
public class StackOfPlates {

    // Internal list of stacks
    private final List<Stack> stacks;
    // Capacity of each stack
    private final int capacity;

    public StackOfPlates(int capacity) {
        this.stacks = new ArrayList<>();
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(10);
        System.out.println("Is stack empty: " + (stackOfPlates.isEmpty() ? "Yes" : "No"));
        for (int i = 1; i <= 37; i++) {
            stackOfPlates.push(i);
        }
        System.out.println("Is stack empty: " + (stackOfPlates.isEmpty() ? "Yes" : "No"));
        System.out.println("Popped: " + stackOfPlates.pop());
        System.out.println("Popped from stack 2: " + stackOfPlates.popAt(1));
    }

    public void push(int value) {
        // Get the last stack
        Stack lastStack = getLastStack();
        // If the last stack is not null and has space left
        if (lastStack != null && !lastStack.isFull()) {
            lastStack.push(value);
        } else {
            // Create a new stack with capacity
            lastStack = new Stack(capacity);
            lastStack.push(value);
            stacks.add(lastStack);
        }
    }

    public int pop() {
        // Get the last stack
        Stack lastStack = getLastStack();
        if (lastStack == null) {
            throw new EmptyStackException();
        }
        // Get the value at top
        int value = lastStack.pop();
        if (lastStack.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        // Get the stack at the given index
        Stack stack = stacks.get(index);
        // Item to be removed
        int removedItem;
        if (removeTop) {
            removedItem = stack.pop();
        } else {
            removedItem = stack.removeBottom();
        }
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int value = leftShift(index + 1, false);
            stack.push(value);
        }
        return removedItem;
    }

    private Stack getLastStack() {
        if (!stacks.isEmpty()) {
            return stacks.get(stacks.size() - 1);
        }
        return null;
    }

    private boolean isEmpty() {
        Stack lastStack = getLastStack();
        return lastStack == null || lastStack.isEmpty();
    }

    static class Stack {
        // Capacity of each stack
        private final int capacity;
        // Size of the stack
        private int size = 0;
        // Top and bottom nodes
        private Node top;
        private Node bottom;

        Stack(int capacity) {
            this.capacity = capacity;
        }

        public boolean isFull() {
            return this.capacity == this.size;
        }

        public void join(Node above, Node below) {
            if (below != null) {
                below.above = above;
            }
            if (above != null) {
                above.below = below;
            }
        }

        public void push(int value) {
            if (this.size >= this.capacity) {
                return;
            }
            this.size++;
            Node node = new Node(value);
            if (this.size == 1) {
                bottom = node;
            }
            join(node, top);
            top = node;
        }

        public int pop() {
            if (top == null) {
                throw new EmptyStackException();
            }
            Node node = top;
            top = top.below;
            this.size--;
            return node.value;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if (bottom != null) bottom.below = null;
            size--;
            return b.value;
        }
    }
}
