package com.ua;

import org.junit.Test;

import java.util.Arrays;
import java.util.IdentityHashMap;

import static org.junit.Assert.*;

/**
 * Created by AlxEx on 03.11.2015.
 */
public class MyPriorityQueueTest {

    @Test
    public void testAdd() throws Exception {
    }

    @Test
    public void testOffer() throws Exception {
        Integer[] integers = {10, 20, 30, 35, 40, 37, 49};
        Integer[] integersExp = {10, 20, 30, 35, 40, 37, 49, null, null, null, null};
        MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<>();
        for (Integer in : integers) {
            priorityQueue.offer(in);
        }
        assertArrayEquals(integersExp, priorityQueue.toArray());
    }

    @Test
    public void testPoll() throws Exception {

    }

    @Test
    public void testPeek() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }

    @Test
    public void testToArray() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {
        Integer[] integers = {5, 10, 9, 15, 20, 17, 30, 40, 60, 25, 42, 16};
        Integer[] integersExp = {5, 10, 9, 15, 17, 16, 30, 60, 25, 42, 20, null, null, null, null, null, null, null,
                null, null, null, null};
        MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<>();
        for (Integer in : integers) {
            priorityQueue.offer(in);
        }
        priorityQueue.remove(40);
        assertArrayEquals(integersExp, priorityQueue.toArray());
    }
}