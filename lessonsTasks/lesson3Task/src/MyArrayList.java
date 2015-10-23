import java.util.Arrays;
import java.util.RandomAccess;

/**
 * Created by AlxEx on 22.10.2015.
 */
public class MyArrayList<E> implements MyList<E>, Container<E>, RandomAccess {
    private final int DEFAULT_CAPACITY = 10;
    private final double DEFAULT_FILL_FACTOR = 0.75;    //Дефолтный коэфициент заполнения

    private E[] array;
    private int capacity = DEFAULT_CAPACITY;
    private double fillFactor = DEFAULT_FILL_FACTOR;
    private int size;


    public MyArrayList() {
        array = (E[]) new Object[capacity];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Illegal args to constructor MyArrayList");
        this.capacity = capacity;
        array = (E[]) new Object[this.capacity];
    }

    public MyArrayList(int capacity, double fillFactor) {
        if (fillFactor < 0.50 || fillFactor > 1 || capacity <= 0)
            throw new IllegalArgumentException("Illegal args to constructor MyArrayList");
        this.capacity = capacity;
        this.fillFactor = fillFactor;
        array = (E[]) new Object[this.capacity];

    }

    public MyArrayList(E[] otherArray) {
        capacity = (int) (otherArray.length / DEFAULT_FILL_FACTOR);
        array = (E[]) new Object[this.capacity];
        for (int i = 0; i < otherArray.length; i++) {
            array[i] = otherArray[i];
        }
        size = otherArray.length;
    }

    /**
     * not deep clone
     *
     * @return
     */
    @Deprecated
    @Override
    public Container clone() {
        return new MyArrayList<E>(array.clone());
    }

    @Override
    public void add(E element) {
        ensureCapacity(size() + 1);
        array[size()] = element;
        size++;
    }

    public void ensureCapacity(int minCapacity) {
        if (capacity < minCapacity) {
            int newCapacity = (int) (minCapacity / fillFactor);
            E[] newArray = (E[]) (new Object[newCapacity]);
            //newArray = Arrays.copyOf(array, size());
            System.arraycopy(array, 0, newArray, 0, size());
            array = newArray;
            capacity = newCapacity;
        }
    }

    @Override
    public void add(int index, E element) {
        if (index >= size() || index < 0)
            throw new IndexOutOfBoundsException("element index out of bound MyArrayList.add()");

        ensureCapacity(size() + 1);
        E[] bufferArray = (E[]) new Object[size() - index]; //buffer array saved tail
        System.arraycopy(array, index, bufferArray, 0, size() - index);
        this.set(index, element);    //changed value of el at pos index
        System.arraycopy(bufferArray, 0, array, index + 1, size() - index); //concat the tail
        size++;
    }

    @Override
    public void addAll(E[] elementsArray) {
        ensureCapacity(size() + elementsArray.length);
        System.arraycopy(elementsArray, 0, array, size(), elementsArray.length);
        size += elementsArray.length;
    }

    @Override
    public void addAll(int index, E[] elementsArray) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        ensureCapacity(size() + elementsArray.length);
        E[] bufferArray = (E[]) (new Object[size() - index]);
        System.arraycopy(array, index, bufferArray, 0, size() - index);
        System.arraycopy(elementsArray, 0, array, index, elementsArray.length);
        System.arraycopy(bufferArray, 0, array, index + elementsArray.length, size() - index);
        size += elementsArray.length;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        E returnValue = this.get(index);
        System.arraycopy(array, index + 1, array, index, size() - index - 1);
        array[size() - 1] = null;
        size--;
        return returnValue;
    }

    @Override
    public void set(int index, E element) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        array[index] = element;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        return Arrays.copyOf(array,size());
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else return false;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
