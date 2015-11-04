package com.ua;

/**
 * Created by AlxEx on 03.11.2015.
 */
public class MyPriorityQueue<T extends Comparable> implements QueueInterface<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private Object[] queue;

    private int size;

    public MyPriorityQueue() {
        this.queue = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public MyPriorityQueue(int capacity) {
        if (capacity > MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException();
        }
        this.queue = new Object[capacity];
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity > queue.length) {
            Object[] newQueue = new Object[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }
    }

    @Override
    public <E extends T> boolean add(E var1) {
        return this.offer(var1);
    }

    @Override
    public <E extends T> boolean offer(E var1) {
        if (var1 == null)
            throw new NullPointerException();
        ensureCapacity(size + 1);
        queue[this.size] = var1;
        int change = size;
        int changeTop = (change - 1) / 2;
        while (change > 0) {
            if (((T) queue[changeTop]).compareTo(var1) > 0) {
                Object buff = queue[changeTop];
                queue[changeTop] = queue[change];
                queue[change] = buff;
                /**if (queue[changeTop * 2 + 1] != null && ((T) queue[changeTop]).compareTo(queue[changeTop * 2 + 1]) > 0) {
                 buff = queue[changeTop];
                 queue[changeTop] = queue[changeTop * 2 + 1];
                 queue[changeTop * 2 + 1] = buff;
                 }
                 if (queue[changeTop * 2 + 2] != null && ((T) queue[changeTop]).compareTo(queue[changeTop * 2 + 2]) > 0) {
                 buff = queue[changeTop];
                 queue[changeTop] = queue[changeTop * 2 + 2];
                 queue[changeTop * 2 + 2] = buff;
                 }*/
                change = changeTop;
                changeTop = (change - 1) / 2;
            } else break;
        }
        size++;
        return true;
    }

    @Override
    public T poll() throws PriorityQueueIsEmptyException {
        Object returnObject;
        if (!this.isEmpty()) {
            returnObject = queue[0];
            System.arraycopy(queue, 1, queue, 0, --size);
            queue[size] = null;
        } else throw new PriorityQueueIsEmptyException();
        return (T) returnObject;
    }

    @Override
    public T peek() throws PriorityQueueIsEmptyException {
        Object returnObject;
        if (!this.isEmpty()) {
            returnObject = queue[0];
        } else throw new PriorityQueueIsEmptyException();
        return (T) returnObject;
    }

    @Override
    public int size() {
        return this.size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public <E extends T> boolean contains(E var1) {
        for (int i = 0; i < queue.length; i++) {
            if (((T) queue[i]).compareTo(var1) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return this.queue;
    }

    @Override
    public <E extends T> boolean remove(E var1) {
        int indexOf = -1;
        if (this.contains(var1)) {
            for (int i = 0; i < queue.length; i++) {
                if (var1.equals(this.queue[i])) {
                    indexOf = i;
                    break;
                }
            }
            System.arraycopy(queue, indexOf + 1, queue, indexOf, --size);
            queue[size] = null;
            // check of balance
            for (int i = size - 1; i > 0; i--) {
                int checked = i,
                        checkedTop = (checked - 1) / 2;
                while (checked > 0) {
                    if (((T) queue[checkedTop]).compareTo(queue[checked]) > 0) {
                        Object buff = queue[checkedTop];
                        queue[checkedTop] = queue[checked];
                        queue[checked] = buff;

                        checked = checkedTop;
                        checkedTop = (checked - 1) / 2;
                    } else break;
                }
            }

            return true;
        }
        return false;
    }

    public static class PriorityQueueIsEmptyException extends Exception {
        public PriorityQueueIsEmptyException() {
        }

        public PriorityQueueIsEmptyException(String s) {
            super(s);
        }
    }
}

