package org.redquark.techinterview.ctci.obejctorienteddesign.hashtable;

/**
 * @author Anirudh Sharma
 * <p>
 * This class represents each bucket in the hash map
 */
public class Entry<K, V> {

    public K key;
    public V value;
    public Entry<K, V> next;
    public Entry<K, V> previous;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
