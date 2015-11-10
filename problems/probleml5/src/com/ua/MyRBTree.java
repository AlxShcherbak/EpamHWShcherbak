package com.ua;

import com.sun.istack.internal.Nullable;

/**
 * Created by AlxEx on 03.11.2015.
 */
public class MyRBTree<K extends Comparable, V> implements MyMap<K, V> {
    private final boolean RED = true;
    private final boolean BLACK = false;

    Entry<K, V> rootEntry;
    int size;


    public MyRBTree() {
    }

    public <T extends K, E extends V> V put(T key, E value) {
        V returnValue = null;
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (isEmpty()) {
            rootEntry = newEntry;
        } else {
            Entry<K, V> parentEntry = rootEntry;
            boolean insertion = false;
            while (insertion) {
                if (parentEntry.key.compareTo(newEntry.key) > 0) {
                    if (parentEntry.hasLeft()) {
                        parentEntry = parentEntry.left;
                    } else {
                        newEntry.parent = parentEntry;
                        size++;
                        insertion = true;
                    }
                } else if (parentEntry.key.compareTo(newEntry.key) < 0) {
                    if (parentEntry.hasRight()) {
                        parentEntry = parentEntry.right;
                    } else {
                        newEntry.parent = parentEntry;
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
        insCases(newEntry);
        return returnValue;
    }

    /**
     * Текущий узел N в корне дерева. В этом случае, он перекрашивается в чёрный цвет, чтобы оставить верным Свойство 2
     * (Корень — чёрный). Так как это действие добавляет один чёрный узел в каждый путь, Свойство 5 (Все пути от любого
     * данного узла до листовых узлов содержат одинаковое число чёрных узлов) не нарушается.
     *
     * @param entry
     */
    private void insCases(Entry<K, V> entry) {
        if (entry.parent == null) {             // insert case 1
            entry.color = BLACK;
        } else if (!entry.parent.color) {    // case 2
            return;
        } else {
            Entry<K, V> uncle = uncle(entry);
            if (uncle != null && uncle.color && entry.parent.color) { // case 3
                entry.parent.color = BLACK;
                uncle.color = BLACK;

                Entry<K, V> grdParent = grdParent(entry);
                grdParent.color = RED;
                insCases(grdParent);
            } else {
                Entry<K, V> grdParent = grdParent(entry);
                if (entry == entry.parent.right && entry.parent == grdParent.left) {    // case 4
                    rotateLeft(entry);
                    entry = entry.left;
                } else if (entry == entry.parent.left && entry.parent == grdParent.right) {
                    rotateRight(entry);
                    entry = entry.right;
                }

                entry.parent.color = BLACK;      // case 5
                grdParent = grdParent(entry);
                grdParent.color = RED;
                if (entry == entry.parent.left && entry.parent == grdParent.left) {
                    rotateRight(grdParent);
                } else {
                    rotateLeft(grdParent);
                }
            }
        }
    }

    private void rotateLeft(Entry<K, V> entry) {
        Entry<K, V> grdParent = grdParent(entry);
        Entry<K, V> sevedParent = grdParent.left,
                sevedLeft = entry.left;
        grdParent.left = entry;
        entry.left = sevedParent;
        sevedParent.right = sevedLeft;
    }

    private void rotateRight(Entry<K, V> entry) {
        Entry<K, V> grdParent = grdParent(entry);
        Entry<K, V> sevedParent = grdParent.right,
                sevedRight = entry.right;
        grdParent.right = entry;
        entry.right = sevedParent;
        sevedParent.left = sevedRight;
    }

    @Nullable
    public V get(K key) {
        Entry<K, V> entryBuffer = getEntryByKey(key);
        if (entryBuffer != null) {
            return entryBuffer.value;
        } else return null;
    }

    @Nullable
    private Entry<K, V> getEntryByKey(K key) {
        Entry<K, V> entryBuffer = rootEntry;
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

    private void replace(Entry<K, V> toPos, Entry<K, V> that) {
        if (toPos == null || that == null) {
            return;
        }
        Entry par = toPos.parent,
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

    @Nullable
    public V remove(K key) {
        Entry<K, V> entryBuffer = getEntryByKey(key);
        V retValue = entryBuffer.value;
        if (entryBuffer == null) {
            return null;
        } else {
            if ((entryBuffer.left != null && entryBuffer.right == null) ||
                    (entryBuffer.left == null && entryBuffer.right != null)) {
                Entry<K, V> child = entryBuffer.left != null ? entryBuffer.left : entryBuffer.right;
                replace(entryBuffer, child);
                if (!entryBuffer.color) {
                    if (child.color) {
                        child.color = BLACK;
                    } else {
                        deleteCases(entryBuffer);
                    }
                }
            }
        }
        if (entryBuffer.parent.left == entryBuffer) {
            entryBuffer.parent.left = null;
        } else entryBuffer.parent.right = null;
        return retValue;
    }

    private void deleteCases(Entry<K, V> entry) {
        if (entry.parent != null) {         // del case 1
            Entry<K, V> sibl = sibling(entry);
            if (sibl.color) {               // del case 2
                entry.parent.color = RED;
                sibl.color = BLACK;
                if (entry == entry.parent.left) {
                    rotateLeft(entry.parent);
                } else rotateRight(entry.parent);
            }
            sibl = sibling(entry);          // del case 3
            if (!entry.parent.color && !sibl.color && !sibl.left.color && !sibl.right.color) {
                sibl.color = RED;
                deleteCases(entry.parent);
            } else {                        // del case 4
                if (entry.parent.color && !sibl.color && !sibl.left.color && !sibl.right.color) {
                    sibl.color = RED;
                    entry.parent.color = BLACK;
                } else {                    // del case 5
                    if (!sibl.color) {
                        if (entry == entry.parent.left && !sibl.right.color && sibl.left.color) {
                            sibl.color = RED;
                            sibl.left.color = BLACK;
                            rotateRight(sibl);
                        } else if (entry == entry.parent.right && !sibl.left.color && sibl.right.color) {
                            sibl.color = RED;
                            sibl.right.color = BLACK;
                            rotateLeft(sibl);
                        }
                    }
                    sibl = sibling(entry);     // del case 6
                    sibl.color = entry.parent.color;
                    entry.parent.color = BLACK;
                    if (entry == entry.parent.left) {
                        sibl.right.color = BLACK;
                        rotateLeft(entry.parent);
                    } else {
                        sibl.left.color = BLACK;
                        rotateRight(entry.parent);
                    }
                }
            }
        }
    }

    public boolean consistKey(K key) {
        if (getEntryByKey(key) != null) {
            return true;
        } else return false;
    }

    public boolean consistValue(V value) {
        return false;
    }

    public boolean isEmpty() {
        return rootEntry == null;
    }

    @Nullable
    private Entry<K, V> grdParent(Entry<K, V> entry) {
        if (entry.parent != null && entry.parent.parent != null) {
            return entry.parent.parent;
        }
        return null;
    }

    @Nullable
    private Entry<K, V> sibling(Entry<K, V> entry) {
        if (entry == entry.parent.left) {
            return entry.parent.right;
        } else return entry.parent.left;
    }

    @Nullable
    private Entry<K, V> uncle(Entry<K, V> entry) {
        Entry grdParent = grdParent(entry);
        if (grdParent != null) {
            if (entry.parent == grdParent.left) {
                return grdParent.right;
            } else return grdParent.left;
        }
        return null;
    }


    private class Entry<K extends Comparable, V> {
        Entry<K, V> parent;
        Entry<K, V> left;
        Entry<K, V> right;

        K key;
        V value;
        boolean color;   // true - RED, false - black

        Entry() {
        }

        <T extends K, E extends V> Entry(T key, E value) {
            parent = null;
            left = null;
            right = null;

            this.key = key;
            this.value = value;
            this.color = true;
        }

        <T extends K, E extends V> Entry(Entry parent, T key, E value) {
            this.parent = parent;
            this.left = null;
            this.right = null;

            this.key = key;
            this.value = value;
            this.color = true;
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
    }
}
