package classes;

/**
 * Created by AlxEx on 22.10.2015.
 */
public interface Container<E extends Object> extends Cloneable {
    /**
     * not deep clone
     *
     * @return
     */
    Container clone();

    int size();

    E get(int index);

    boolean contains(E element);

    void add(E element);
}
