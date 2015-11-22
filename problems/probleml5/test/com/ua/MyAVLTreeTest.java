package com.ua;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AlxEx on 18.11.2015.
 */
public class MyAVLTreeTest {

    @Test
    public void testPut() throws Exception {
        MyAVLTree<Integer, Integer> avlTree = new MyAVLTree<>();
        avlTree.put(4, 4);
        avlTree.put(3, 3);
        avlTree.put(7, 7);
        avlTree.put(9, 9);
        avlTree.put(8, 8);
        avlTree.put(10, 10);
        System.out.println();
    }
}