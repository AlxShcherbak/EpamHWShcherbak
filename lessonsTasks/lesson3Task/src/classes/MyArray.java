package classes;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by AlxEx on 22.10.2015.
 */
public class MyArray<E> implements Container<E> {
    protected E[] array;
    protected int capacity;
    protected int size;

    public MyArray(E[] array) {
        this.array = array;
        this.capacity = array.length;
        this.size = array.length;
    }

    public MyArray(E[] array, int capacity) {
        if (capacity < array.length) {
            try {
                throw new IllegalArgumentException("capacity less then array");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            new MyArray(array);
            return;
        } else {
            this.array = (E[]) new Object[capacity];
            this.capacity = capacity;
            this.size = array.length;
            for (int i = 0; i < array.length; i++) {
                this.array[i] = array[i];
            }
        }
    }

    public MyArray(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * not deep clone
     *
     * @return
     */
    @Override
    @Deprecated
    public MyArray<E> clone() {
        return new MyArray<E>(array.clone());
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public boolean contains(Object element) {
        for (E el : array) {
            if (el == element || el.equals(element)) {
                return true;
            }
        }
        return false;
    }


    public void add(E element) {
        if (size == capacity) {
            throw new ArrayStoreException("array other flow");
        } else {
            array[size] = element;
        }
    }
}
