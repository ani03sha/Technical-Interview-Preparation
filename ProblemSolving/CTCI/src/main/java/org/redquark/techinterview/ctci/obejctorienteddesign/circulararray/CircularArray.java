package org.redquark.techinterview.ctci.obejctorienteddesign.circulararray;

import java.util.Iterator;

/**
 * @author Anirudh Sharma
 * <p>
 * Implement a CircularArray class that supports an array-like data structure which can be efficiently rotated.
 * <p>
 * If possible, the class should use a generic type (also called a template), and should support iteration via
 * the standard for (Obj o : circularArray) notation
 */
public class CircularArray<T> implements Iterable<T> {

    // Internal array to store elements of the circular array
    private final T[] items;

    // Head pointer, that will denote the start index of the
    // circular array
    private int head = 0;

    @SuppressWarnings("unchecked")
    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    public int length() {
        return items.length;
    }

    public T get(int index) {
        if (index < 0 || index >= items.length) {
            throw new IndexOutOfBoundsException();
        }
        return items[convert(index)];
    }

    public void set(int index, T value) {
        items[convert(index)] = value;
    }

    public void rotate(int shift) {
        head = convert(shift);
    }

    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            // Current represents the offset from rotated
            // head and not from the actual head
            private int current = -1;

            @Override
            public boolean hasNext() {
                return current < items.length - 1;
            }

            @Override
            public T next() {
                current++;
                return items[convert(current)];
            }
        };
    }
}
