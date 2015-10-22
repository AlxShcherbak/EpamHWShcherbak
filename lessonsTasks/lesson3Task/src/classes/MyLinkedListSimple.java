package classes;

/**
 * Created by AlxEx on 22.10.2015.
 */
public class MyLinkedListSimple implements MyList, Container {
    /**
     * not deep clone
     *
     * @return
     */
    @Override
    public Container clone() {
        return null;
    }

    @Override
    public void add(Object element) {

    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public void addAll(Object[] elementsArray) {

    }

    @Override
    public void addAll(int index, Object[] elementsArray) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void set(int index, Object element) {

    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }
}
