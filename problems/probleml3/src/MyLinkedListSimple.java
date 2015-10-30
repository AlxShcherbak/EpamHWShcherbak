import com.sun.istack.internal.Nullable;

/**
 * Created by AlxEx on 22.10.2015.
 */
public class MyLinkedListSimple<E> implements MyList<E> {
    Element<E> first;
    int size = 0;

    public MyLinkedListSimple() {
    }

    public MyLinkedListSimple(E i) {
        first = new Element<E>(i);
        size++;
    }

    private Element getLast() {
        Element<E> bufEl = first;
        while (bufEl.hasNext()) {
            bufEl = bufEl.next();
        }
        return bufEl;
    }

    private Element getElByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("getElByIndex");
        }
        Element<E> buffEl = first;
        for (int i = 0; i <= index; i++) {
            buffEl = buffEl.next();
        }
        return buffEl;
    }

    @Override
    public <T extends E> void add(T element) {
        if (isEmpty()) {
            first = new Element<E>(element);
        } else {
            new Element<E>(getLast(), element);
        }
        size++;
    }

    @Override
    public <T extends E> void add(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("getElByIndex");
        }
        if (index == 0) {
            Element<E> sec = first;
            first = new Element<E>(element);
            first.setNext(sec);
        } else {
            Element<E> preEl = getElByIndex(index - 1);
            Element<E> elCh = preEl.next();
            Element<E> newEl = new Element<E>(preEl, element);
            newEl.setNext(elCh);
        }
        size++;
    }

    @Override
    public <T extends E> void addAll(T[] elementsArray) {
        Element last = getLast();
        for (T el : elementsArray) {
            Element lastN = new Element(last, el);
            last = lastN;
            size++;
        }
    }

    @Override
    public <T extends E> void addAll(int index, T[] elementsArray) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("getElByIndex");
        }
        if (elementsArray.length == 0) {
            return;
        } else if (elementsArray.length == 1) {
            add(index, elementsArray[0]);
            return;
        } else {
            Element<E> newThrStart = new Element<E>(elementsArray[0]);
            Element<E> newThrEnd = newThrStart;
            for (int i = 1; i < elementsArray.length; i++) {
                newThrEnd = new Element<E>(newThrEnd, elementsArray[i]);
                size++;
            }
            if (index == 0) {
                Element<E> elementChange = first;
                first = newThrStart;
                newThrEnd.setNext(elementChange);
            } else {
                Element<E> preEl = getElByIndex(index - 1);
                Element<E> elementChange = preEl.next();
                preEl.setNext(newThrStart);
                newThrEnd.setNext(elementChange);
            }
        }
    }

    @Override
    public E get(int index) {
        return (E) getElByIndex(index - 1).next().getValue();
    }

    @Override
    public E remove(int index) {
        Element<E> element = getElByIndex(index);
        return null;
    }

    @Override
    public <T extends E> void set(int index, T element) {

    }

    @Override
    public <T extends E> int indexOf(T element) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Nullable
    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size() != 0) {
            return false;
        }
        return true;
    }

    @Override
    public <T extends E> boolean contains(T element) {
        if (isEmpty()) {
            return false;
        } else {
            Element<E> buffEl = first;
            while (buffEl.hasNext()) {
                if (((E) buffEl.getValue()).equals(element)) {
                    return true;
                }
                buffEl = buffEl.next();
            }
            if (((E) buffEl.getValue()).equals(element)) {
                return true;
            }
        }
        return false;
    }

    private final class Element<E> {
        Element next;
        E value;

        public <T extends E> Element(T value) {
            this.value = value;
        }

        public <T extends E> Element(Element prev, T value) {
            prev.setNext(this);
            this.value = value;
        }

        boolean hasNext() {
            if (next() != null) {
                return true;
            } else return false;
        }

        Element next() {
            return next;
        }

        Element remove() {
            return this;
        }

        void setNext(Element next) {
            this.next = next;
        }

        E getValue() {
            return value;
        }

        <T extends E> void setValue(T value) {
            this.value = value;
        }
    }
}
