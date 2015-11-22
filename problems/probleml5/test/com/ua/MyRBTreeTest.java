package com.ua;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AlxEx on 10.11.2015.
 */
public class MyRBTreeTest {

    @Test
    public void testPut() throws Exception {
        MyRBTree rbTree = new MyRBTree();
        rbTree.put(4, 4);
        rbTree.put(3, 3);
        rbTree.put(7, 7);
        rbTree.put(9, 9);
        rbTree.put(8, 8);
        rbTree.put(10, 10);
        System.out.println();
    }
}