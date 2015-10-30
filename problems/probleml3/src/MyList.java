/**
 * Created by AlxEx on 22.10.2015.
 */
public interface MyList <E> {
    <T extends E> void add  (T element);

    <T extends E> void add(int index, T element);

    <T extends E> void addAll(T[] elementsArray);

    <T extends E> void addAll(int index, T[] elementsArray);

    E get(int index);

    E remove(int index);

    <T extends E> void set(int index, T element);

    <T extends E> int indexOf(T element);

    int size();

    E[] toArray();

    boolean isEmpty();

    <T extends E> boolean contains(T element);
}
