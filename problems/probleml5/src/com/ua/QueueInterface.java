package com.ua;

import java.util.Queue;

/**
 * Created by AlxEx on 03.11.2015.
 */
public interface QueueInterface<E> {
    <T extends E> boolean add(T var1);

    <T extends E> boolean offer(T var1);

    E poll() throws MyPriorityQueue.PriorityQueueIsEmptyException;

    E peek() throws MyPriorityQueue.PriorityQueueIsEmptyException;

    int size();

    boolean isEmpty();

    <T extends E> boolean contains(T var1);

    Object[] toArray();

    <T extends E> boolean remove(T var1);
}
