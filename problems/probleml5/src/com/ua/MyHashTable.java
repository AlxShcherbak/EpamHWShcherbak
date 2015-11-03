package com.ua;

import com.sun.istack.internal.Nullable;

/**
 * Created by AlxEx on 03.11.2015.
 */
public class MyHashTable<K, V> {
    private final double DEFAULT_LOAD_FACTOR = 0.75;
    private final int DEFAULT_CAPACITY = 16;
    private int size = 0;
    private double loadFactor = DEFAULT_LOAD_FACTOR;

    private Entry<K, V>[] hashTable;

    public MyHashTable() {
        hashTable = new Entry[DEFAULT_CAPACITY];
    }

    public MyHashTable(int capacity) {
        hashTable = new Entry[capacity];
    }

    public MyHashTable(int capacity, double loadFactor) {
        hashTable = new Entry[capacity];
        this.loadFactor = loadFactor;
    }

    private void ensureCapacity(int newCapacity) {
        if (hashTable.length * loadFactor < newCapacity) {
            Entry<K, V>[] oldTable = hashTable;
            this.hashTable = new Entry[hashTable.length * 2];
            for (Entry entry : oldTable) {
                putEntry(entry);
            }
        }
    }

    private int getPosition(int hash) {
        ensureCapacity(size + 1);
        return hash % hashTable.length;
    }

    public V put(K key, V value) {
        ensureCapacity(size + 1);
        size++;
        return putEntry(new Entry<>(key, value));
    }

    @Nullable
    private V putEntry(Entry<K, V> entry) {
        int position = getPosition(entry.hash);
        V returnValue = null;
        if (hashTable[position] == null) {
            hashTable[position] = entry;
        } else {
            if (containsKey(entry.key)) {
                Entry<K, V> someEntry = hashTable[entry.hash];
                while (someEntry.hasNext()) {
                    if (someEntry.key == entry.key) {
                        returnValue = someEntry.value;
                        someEntry.value = entry.value;
                    }
                    someEntry = someEntry.next;
                }
                if (someEntry.key == entry.key) {
                    returnValue = someEntry.value;
                    someEntry.value = entry.value;
                }
            } else {
                Entry<K, V> someEntry = hashTable[entry.hash];
                hashTable[position] = entry;
                entry.next = someEntry;
            }
        }
        return returnValue;
    }

    public boolean containsKey(Object key) {
        int position = getPosition(hash(key.hashCode()));
        Entry entry = hashTable[position];
        if (entry != null) {
            while (entry.hasNext()) {
                if (entry.key.equals(key)) {
                    return true;
                }
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (Entry entry : hashTable) {
            while (entry.hasNext()) {
                if (entry.value.equals(value)) {
                    return true;
                }
                entry = entry.next;
            }
            if (entry.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public V remove(Object key) {
        int position = getPosition(hash(key.hashCode()));
        Entry entry = hashTable[position];
        V returnValue = null;
        if (entry != null) {
            if (entry.key.equals(key)) {
                returnValue = (V) entry.value;
                hashTable[position] = entry.next;
            }
            while (entry.hasNext()) {
                if (entry.next.key.equals(key)) {
                    returnValue = (V) entry.next.value;
                    entry.next = entry.next.next;
                }
            }
        }
        return returnValue;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        hashTable = new Entry[DEFAULT_CAPACITY];
    }

    int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * @param <K> - key
     * @param <V> - value
     */
    private class Entry<K, V> {
        final int hash;
        K key;
        V value;
        Entry next;

        Entry(K key, V value) {
            this.hash = hash(key.hashCode());
            this.key = key;
            this.value = value;
        }

        boolean hasNext() {
            return next != null;
        }

        int hash(int h) {
            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }
    }
}
