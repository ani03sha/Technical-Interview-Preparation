package org.redquark.techinterview.ctci.stacksandqueues;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Design a stack which, in addition to push and pop, has a function min which returns the minimum element?
 * <p>
 * Push, pop and min should all operate in 0(1) time.
 */
public class StackMin {

    // Internal stack to keep track of actual data
    // and the minimum element
    private final Stack<Node> internalStack;

    public StackMin() {
        this.internalStack = new Stack<>();
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.push(4);
        System.out.println("Pushed: " + stackMin.peek());
        stackMin.push(5);
        System.out.println("Pushed: " + stackMin.peek());
        stackMin.push(-3);
        System.out.println("Pushed: " + stackMin.peek());
        System.out.println("Min value: " + stackMin.getMin());
        stackMin.push(-2);
        System.out.println("Popped: " + stackMin.pop());
        System.out.println("Min value: " + stackMin.getMin());
        System.out.println("Popped: " + stackMin.pop());
        System.out.println("Popped: " + stackMin.pop());
        System.out.println("Min value: " + stackMin.getMin());
        System.out.println("Popped: " + stackMin.pop());
        try {
            System.out.println("Min value: " + stackMin.getMin());
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
        stackMin.push(1);
        System.out.println("Pushed: " + stackMin.peek());
        System.out.println("Min value: " + stackMin.getMin());
    }

    public void push(int value) {
        if (internalStack.isEmpty()) {
            internalStack.push(new Node(value, value));
        } else {
            internalStack.push(new Node(value, Math.min(internalStack.peek().minimum, value)));
        }
    }

    public int pop() {
        return internalStack.pop().data;
    }

    public int peek() {
        return internalStack.peek().data;
    }

    public int getMin() {
        return internalStack.peek().minimum;
    }

    static class Node {
        // Actual data to be stored in the node
        int data;
        // Minimum value among all nodes
        int minimum;

        Node(int data, int minimum) {
            this.data = data;
            this.minimum = minimum;
        }
    }
}
