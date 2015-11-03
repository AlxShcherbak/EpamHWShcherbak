package com.ua;

/**
 * Created by AlxEx on 03.11.2015.
 */
public class MyRBTree<V extends Comparable> {
    int size;
    Entry<V> entry;

    public MyRBTree() {
    }

    public <T extends V> void add(T value) {
        return;
    }


    private class Entry<V extends Comparable> {
        Entry left;
        Entry right;

        boolean colorRed;
        V value;

        Entry() {
        }

        <T extends V> Entry(T value) {
            this.value = value;
        }

        boolean hasLeft() {
            return left != null;
        }

        boolean hasRight() {
            return right != null;
        }
    }

    private class Nil extends Entry {
        boolean colorRed = false;
    }
}
