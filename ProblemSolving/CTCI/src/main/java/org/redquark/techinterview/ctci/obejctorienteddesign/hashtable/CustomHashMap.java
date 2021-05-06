package org.redquark.techinterview.ctci.obejctorienteddesign.hashtable;

import java.util.ArrayList;

/**
 * @author Anirudh Sharma
 * <p>
 * Design and implement a hash table which uses chaining (linked lists) to handle collisions.
 */
public class CustomHashMap<K, V> {

    // list of Entry objects to store data
    private final ArrayList<Entry<K, V>> items;

    // Size of the map
    private int size;

    public CustomHashMap() {
        this(16);
    }

    public CustomHashMap(int capacity) {
        items = new ArrayList<>();
        items.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            items.add(null);
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        // Get the appropriate entry for the key
        Entry<K, V> node = getNodeForKey(key);
        // If node is not null, it means there already something
        // present in that bucket
        if (node != null) {
            // Update the value to the new value
            node.value = value;
            return;
        }
        // If the node is null, then create a new Entry object
        node = new Entry<>(key, value);
        // Now we will be finding an appropriate index for
        // this bucket and store it there
        int index = getIndexForKey(key);
        // Check if there is something already there
        if (items.get(index) != null) {
            // Put the new node in the front of the linked list
            node.next = items.get(index);
            node.next.previous = node;
        }
        items.set(index, node);
        size++;
    }

    public V get(K key) {
        // Get the node using key
        Entry<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    public void remove(K key) {
        // Get the node for the given key
        Entry<K, V> node = getNodeForKey(key);
        if (node == null) {
            throw new IndexOutOfBoundsException();
        }
        // If the node is part of a linked list at a bucket
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            // Remove the head - first node of the linked list
            int index = getIndexForKey(key);
            items.set(index, node.next);
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }
        size--;
    }

    private Entry<K, V> getNodeForKey(K key) {
        // Get the index or bucket location for this key
        int index = getIndexForKey(key);
        // Get the node stored at the "index" from the items list
        Entry<K, V> node = items.get(index);
        // If there is already some value(s) at the node
        while (node != null) {
            if (node.key == key) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode()) % items.size();
    }
}
