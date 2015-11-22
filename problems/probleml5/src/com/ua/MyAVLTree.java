package com.ua;

import com.sun.istack.internal.Nullable;

/**
 * Created by AlxEx on 03.11.2015.
 */
public class MyAVLTree<K extends Comparable, V> implements MyMap<K, V> {
    private Node<K, V> rootEntry;
    private int size = 0;

    @Override
    public <T extends K, E extends V> V put(T key, E value) {
        V returnValue = null;
        Node<K, V> newEntry = new Node<>(key, value);
        if (isEmpty()) {
            rootEntry = newEntry;
            size++;
        } else {
            Node<K, V> parentEntry = rootEntry;
            boolean insertion = false;
            while (!insertion) {
                if (parentEntry.key.compareTo(newEntry.key) > 0) {
                    if (parentEntry.hasLeft()) {
                        parentEntry = parentEntry.left;
                    } else {
                        newEntry.parent = parentEntry;
                        parentEntry.left = newEntry;
                        size++;
                        insertion = true;
                    }
                } else if (parentEntry.key.compareTo(newEntry.key) < 0) {
                    if (parentEntry.hasRight()) {
                        parentEntry = parentEntry.right;
                    } else {
                        newEntry.parent = parentEntry;
                        parentEntry.right = newEntry;
                        size++;
                        insertion = true;
                    }
                } else {
                    returnValue = parentEntry.value;
                    parentEntry.value = value;
                    insertion = true;
                }

            }
        }
        insCase1(newEntry);
        return returnValue;
    }

    private void insCase1(Node<K, V> entry) {
        if (entry.parent == null || entry.parent.calcHeightBalance() == 0) {
            return;
        } else insCase2(entry);
    }

    private void insCase2(Node<K, V> entry) {
        Node<K, V> sibl = sibling(entry),
                grdPar = grdParent(entry);
        if (sibl == null) {
            if (grdPar != null && grdPar.left == entry.parent && entry.parent.right == entry) {
                rotateLeft(entry);
                entry = entry.left;
            }
            if (grdPar != null && grdPar.right == entry.parent && entry.parent.left == entry) {
                rotateRight(entry);
                entry = entry.right;
            }
            entry.calcHeight();
        }
        insCase3(entry);
    }

    private void insCase3(Node<K, V> entry) {
        Node<K, V> grdPar = grdParent(entry);
        if (grdPar != null) {
            if (grdPar.calcHeightBalance() >= 2) {
                rotateLeft(entry.parent);
            } else if (grdPar.calcHeightBalance() <= -2) {
                rotateRight(entry.parent);
            }
            insCase3(entry.parent);
        }
    }


    @Override
    public V get(K key) {

        Node<K, V> entryBuffer = getEntryByKey(key);
        if (entryBuffer != null) {
            return entryBuffer.value;
        } else return null;
    }

    @Override
    public V remove(K key) {
        Node<K, V> removedEntry = getEntryByKey(key);
        if (removedEntry == null) {
            return null;
        } else if (removedEntry.left == null && removedEntry.right != null) {
            if (removedEntry.parent == null) {
                rootEntry = removedEntry.right;
            } else replace(removedEntry, removedEntry.right);
        } else if (removedEntry.right == null && removedEntry.left != null) {
            if (removedEntry.parent == null) {
                removedEntry = removedEntry.left;
            } else replace(removedEntry, removedEntry.left);
        }
        return null;
    }

    @Override
    public boolean consistKey(K key) {
        if (getEntryByKey(key) != null) {
            return true;
        } else return false;
    }

    @Nullable
    private Node<K, V> getEntryByKey(K key) {
        Node<K, V> entryBuffer = rootEntry;
        boolean iterate = true;
        while (iterate) {
            if (entryBuffer == null) {
                return null;
            }
            if (entryBuffer.key.compareTo(key) == 0) {
                return entryBuffer;
            } else if (entryBuffer.key.compareTo(key) > 0) {
                entryBuffer = entryBuffer.left;
            } else {
                entryBuffer = entryBuffer.right;
            }
        }
        return null;
    }

    @Override
    public boolean consistValue(V value) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    private void rotateLeft(Node<K, V> entry) {
        Node<K, V> grdParent = grdParent(entry);
        Node<K, V> sevedParent = entry.parent,
                sevedLeft = entry.left;
        if (grdParent != null) {
            if (grdParent.left == entry.parent) {
                grdParent.left = entry;
            } else {
                grdParent.right = entry;
            }
            entry.parent = grdParent;
        } else {
            rootEntry = entry;
            entry.parent = null;
        }
        entry.left = sevedParent;
        sevedParent.right = sevedLeft;
        sevedParent.parent = entry;
    }

    private void rotateRight(Node<K, V> entry) {
        Node<K, V> grdParent = grdParent(entry);
        Node<K, V> sevedParent = entry.parent,
                sevedRight = entry.right;
        if (grdParent != null) {
            if (grdParent.left == entry.parent) {
                grdParent.left = entry;
            } else {
                grdParent.right = entry;
            }
            entry.parent = grdParent;
        } else {
            rootEntry = entry;
            entry.parent = null;
        }
        entry.right = sevedParent;
        entry.parent = grdParent;
        sevedParent.left = sevedRight;
        sevedParent.parent = entry;
    }

    @Nullable
    private Node<K, V> grdParent(Node<K, V> entry) {
        if (entry.parent != null && entry.parent.parent != null) {
            return entry.parent.parent;
        }
        return null;
    }

    @Nullable
    private Node<K, V> sibling(Node<K, V> entry) {
        if (entry.parent != null) {
            if (entry == entry.parent.left) {
                return entry.parent.right;
            } else return entry.parent.left;
        } else return null;
    }

    private void replace(Node<K, V> toPos, Node<K, V> that) {
        if (toPos == null || that == null) {
            return;
        }
        Node par = toPos.parent,
                left = toPos.left,
                right = toPos.right;
        if (par == null) {
            rootEntry = that;
        }
        toPos.parent = that.parent;
        toPos.left = that.left;
        toPos.right = that.right;

        that.right = right;
        that.left = left;
        that.parent = par;
    }

    class Node<K extends Comparable, V> {
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;

        K key;
        V value;
        int height = 1;

        Node() {
        }

        int calcHeightBalance() {
            height = 1;
            int leftHeight = 0,
                    rightHeight = 0;
            if (left != null) {
                leftHeight = left.calcHeight();
            }
            if (right != null) {
                rightHeight = right.calcHeight();
            }
            height += (rightHeight >= leftHeight) ? rightHeight : leftHeight;
            return rightHeight - leftHeight;
        }

        int calcHeight() {
            height = 1;
            int leftHeight = 0,
                    rightHeight = 0;
            if (left != null) {
                leftHeight = left.calcHeight();
            }
            if (right != null) {
                rightHeight = right.calcHeight();
            }
            height += (rightHeight >= leftHeight) ? rightHeight : leftHeight;
            return height;
        }

        <T extends K, E extends V> Node(T key, E value) {
            parent = null;
            left = null;
            right = null;

            this.key = key;
            this.value = value;
        }

        <T extends K, E extends V> Node(Node parent, T key, E value) {
            this.parent = parent;
            this.left = null;
            this.right = null;

            this.key = key;
            this.value = value;
        }

        boolean hasLeft() {
            return left != null;
        }

        boolean hasRight() {
            return right != null;
        }

        void remove() {
            if (hasLeft()) {
                if (this == parent.right) {
                    parent.right = this.left;
                }
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "height=" + height +
                    ", key=" + key +
                    '}';
        }
    }
}
