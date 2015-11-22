package com.ua;

import com.sun.istack.internal.Nullable;

/**
 * Created by AlxEx on 03.11.2015.
 */
public class MyRBTree<K extends Comparable, V> implements MyMap<K, V> {
    private final boolean RED = true;
    private final boolean BLACK = false;

    private final Entry NIL = new Entry();
    Entry<K, V> rootEntry;
    int size;


    public MyRBTree() {
    }

    public <T extends K, E extends V> V put(T key, E value) {
        V returnValue = null;
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (isEmpty()) {
            rootEntry = newEntry;
            size++;
        } else {
            Entry<K, V> parentEntry = rootEntry;
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

    /**
     * The current node N is at the root of the tree. In this case, it is repainted black to satisfy property 2
     * (the root is black). Since this adds one black node to every path at once, property 5 (all paths from any given
     * node to its leaf nodes contain the same number of black nodes) is not violated.
     *
     * @param entry
     */
    private void insCase1(Entry<K, V> entry) {
        if (entry.parent == NIL) {             // insert case 1
            entry.color = BLACK;
        } else insCase2(entry);
    }

    /**
     * The current node's parent P is black, so property 4 (both children of every red node are black) is not
     * invalidated. In this case, the tree is still valid. Property 5 (all paths from any given node to its leaf nodes
     * contain the same number of black nodes) is not threatened, because the current node N has two black leaf children,
     * but because N is red, the paths through each of its children have the same number of black nodes as the path
     * through the leaf it replaced, which was black, and so this property remains satisfied.
     *
     * @param entry
     */
    private void insCase2(Entry<K, V> entry) {
        if (!entry.parent.color) {    // case 2
            return;
        } else insCase3(entry);
    }

    /**
     * If both the parent P and the uncle U are red, then both of them can be repainted black and the grandparent G
     * becomes red (to maintain property 5 (all paths from any given node to its leaf nodes contain the same number of
     * black nodes)).
     *
     * @param entry
     */
    private void insCase3(Entry<K, V> entry) {
        Entry<K, V> uncle = uncle(entry);
        if (uncle != null && uncle.color && entry.parent.color) { // case 3
            entry.parent.color = BLACK;
            uncle.color = BLACK;

            Entry<K, V> grdParent = grdParent(entry);
            grdParent.color = RED;
            insCase1(grdParent);
            if (sibling(entry) == NIL) {
                if (entry == entry.parent.left) {
                    rotateRight(entry);
                    entry.color = BLACK;
                    entry.right.color = RED;
                }
            }
        } else insCase4(entry);
    }

    /**
     * The parent P is red but the uncle U is black; also, the current node N is the right child of P, and P in turn is
     * the left child of its parent G. In this case, a left rotation on P that switches the roles of the current node N
     * and its parent P can be performed; then, the former parent node P is dealt with using case 5 (relabeling N and P)
     * because property 4 (both children of every red node are black) is still violated.
     *
     * @param entry
     */
    private void insCase4(Entry<K, V> entry) {
        Entry<K, V> grdParent = grdParent(entry);
        if (entry == entry.parent.right && entry.parent == grdParent.left) {    // case 4
            rotateLeft(entry);
            entry = entry.left;
        } else if (entry == entry.parent.left && entry.parent == grdParent.right) {
            rotateRight(entry);
            entry = entry.right;
        }
        insCase5(entry);
    }

    /**
     * The parent P is red but the uncle U is black, the current node N is the left child of P, and P is the left child
     * of its parent G. In this case, a right rotation on G is performed; the result is a tree where the former parent
     * P is now the parent of both the current node N and the former grandparent G.
     *
     * @param entry
     */
    private void insCase5(Entry<K, V> entry) {
        Entry<K, V> grdParent = grdParent(entry);
        entry.parent.color = BLACK;      // case 5
        grdParent.color = RED;
        if (entry == entry.parent.left && entry.parent == grdParent.left) {
            rotateRight(entry.parent);
        } else {
            rotateLeft(entry.parent);
        }
    }

    private void insCases(Entry<K, V> entry) {
        if (entry.parent == NIL) {             // insert case 1
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
                    rotateLeft(entry.parent);
                    //entry = entry.left;
                } else if (entry == entry.parent.left && entry.parent == grdParent.right) {
                    rotateRight(entry.parent);
                    //entry = entry.right;
                }

                entry.parent.color = BLACK;      // case 5
                grdParent = grdParent(entry.parent);
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
        Entry<K, V> sevedParent = entry.parent,
                sevedLeft = entry.left;
        if (grdParent != NIL) {
            if (grdParent.left == entry.parent) {
                grdParent.left = entry;
            } else {
                grdParent.right = entry;
            }
            entry.parent = grdParent;
        } else {
            rootEntry = entry;
            entry.parent = NIL;
        }
        entry.left = sevedParent;
        sevedParent.right = sevedLeft;
        sevedParent.parent = entry;
    }

    private void rotateRight(Entry<K, V> entry) {
        Entry<K, V> grdParent = grdParent(entry);
        Entry<K, V> sevedParent = entry.parent,
                sevedRight = entry.right;
        if (grdParent != NIL) {
            if (grdParent.left == entry.parent) {
                grdParent.left = entry;
            } else {
                grdParent.right = entry;
            }
            entry.parent = grdParent;
        } else {
            rootEntry = entry;
            entry.parent = NIL;
        }
        entry.right = sevedParent;
        entry.parent = grdParent;
        sevedParent.left = sevedRight;
        sevedParent.parent = entry;
    }

    @Nullable
    public V get(K key) {
        Entry<K, V> entryBuffer = getEntryByKey(key);
        if (entryBuffer != NIL) {
            return entryBuffer.value;
        } else return null;
    }

    @Nullable
    private Entry<K, V> getEntryByKey(K key) {
        Entry<K, V> entryBuffer = rootEntry;
        boolean iterate = true;
        while (iterate) {
            if (entryBuffer == NIL) {
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
        if (toPos == NIL || that == NIL) {
            return;
        }
        Entry par = toPos.parent,
                left = toPos.left,
                right = toPos.right;
        if (par == NIL) {
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
        if (entryBuffer == NIL) {
            return null;
        } else {
            if ((entryBuffer.left != NIL && entryBuffer.right == NIL) ||
                    (entryBuffer.left == NIL && entryBuffer.right != NIL)) {
                Entry<K, V> child = entryBuffer.left != NIL ? entryBuffer.left : entryBuffer.right;
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
            entryBuffer.parent.left = NIL;
        } else entryBuffer.parent.right = NIL;
        return retValue;
    }

    private void deleteCases(Entry<K, V> entry) {
        if (entry.parent != NIL) {         // del case 1
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
        if (getEntryByKey(key) != NIL) {
            return true;
        } else return false;
    }

    public boolean consistValue(V value) {
        return false;
    }

    public boolean isEmpty() {
        return rootEntry == null || rootEntry == NIL;
    }

    @Nullable
    private Entry<K, V> grdParent(Entry<K, V> entry) {
        if (entry.parent != NIL && entry.parent.parent != NIL) {
            return entry.parent.parent;
        }
        return NIL;
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
        return NIL;
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
            parent = NIL;
            left = NIL;
            right = NIL;

            this.key = key;
            this.value = value;
            this.color = true;
        }

        <T extends K, E extends V> Entry(Entry parent, T key, E value) {
            this.parent = parent;
            this.left = NIL;
            this.right = NIL;

            this.key = key;
            this.value = value;
            this.color = true;
        }

        boolean hasLeft() {
            return left != null && left != NIL;
        }

        boolean hasRight() {
            return right != null && right != NIL;
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
            String col = this.color ? "RED" : "BLACK";
            return "key = " + key + " " + col;
        }
    }
}
