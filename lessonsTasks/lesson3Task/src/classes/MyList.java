package classes;

/**
 * Created by AlxEx on 22.10.2015.
 */
public interface MyList <E> {
    void add(E element);

    void add(int index, E element);

    void addAll(E[] elementsArray);

    void addAll(int index, E[] elementsArray);

    E get(int index);

    E remove(int index);

    void set(int index, E element);

    int indexOf(E element);

    int size();

    E[] toArray();

    boolean isEmpty();

    boolean contains(E element);
}
