package org.redquark.techinterview.ctci.stacksandqueues;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueViaStacks {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        for (int i = 1; i <= 20; i++) {
            myQueue.add(i);
        }
        System.out.println("Oldest element in the queue: " + myQueue.peek());
        System.out.println("Removed oldest element from the queue: " + myQueue.pop());
        System.out.println("New oldest element in the queue: " + myQueue.peek());
    }

    static class MyQueue<T> {
        // Stack with the oldest elements, we will poll from here
        private final Stack<T> oldest;
        // Stack with the newest elements, we will add here
        private final Stack<T> newest;

        MyQueue() {
            this.oldest = new Stack<>();
            this.newest = new Stack<>();
        }

        public void add(T element) {
            newest.push(element);
        }

        public T pop() {
            shift();
            return oldest.pop();
        }

        public T peek() {
            shift();
            return oldest.peek();
        }

        private void shift() {
            // Shift elements from newest to oldest,
            // this way the latest element in top of newest
            // will be at the bottom of the oldest.
            // And the oldest element will be at the top of
            // oldest
            if (oldest.isEmpty()) {
                while (!newest.isEmpty()) {
                    oldest.push(newest.pop());
                }
            }
        }
    }
}
