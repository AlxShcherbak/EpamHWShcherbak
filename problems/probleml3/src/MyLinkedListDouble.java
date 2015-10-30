import com.sun.istack.internal.Nullable;

/**
 * Created by AlxEx on 22.10.2015.
 */
public class MyLinkedListDouble<E> implements MyList<E> {
    Element<E> header;
    int size = 0;

    public MyLinkedListDouble() {
        header = new Element<E>(null);
        header.prev = header;
        header.next = header;
        }

    public MyLinkedListDouble(E value) {
        header = new Element<E>(null);

        header.next = new Element<E>(value);
        header.prev = header.next();
        size++;
    }

    /**
     * not work
     *
     * @return
     */
    @Deprecated
    @Override
    public MyLinkedListDouble<E> clone() {
        MyLinkedListDouble<E> clone = new MyLinkedListDouble<>();
        clone.addAll(this.toArray());
        return clone;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Element<E> returnElement;
        if (index <= size() / 2) {
            returnElement = header.next();
            int counter = 0;
            while (counter < index) {
                returnElement = returnElement.next();
                counter++;
            }
            return returnElement.getValue();
        } else {
            returnElement = header.prev();
            int backCounter = size() - 1;
            while (backCounter > index) {
                returnElement = returnElement.prev();
                backCounter--;
            }
            return returnElement.getValue();
        }
    }

    @Override
    @Nullable
    public E remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Element<E> returnElement;
        E returnValue = null;
        if (index <= size() / 2) {
            returnElement = header.next();
            int counter = 0;
            while (counter < index) {
                returnElement = returnElement.next();
                counter++;
            }
            returnValue = returnElement.getValue();
            returnElement.remove();
        } else {
            returnElement = header.prev();
            int backCounter = size() - 1;
            while (backCounter > index) {
                returnElement = returnElement.prev();
                backCounter--;
            }
            returnValue = returnElement.getValue();
            returnElement.remove();
        }
        size--;
        return returnValue;
    }

    @Override
    public <T extends E> void set(int index, T element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Element<E> returnElement;
        if (index <= size() / 2) {
            returnElement = header.next();
            int counter = 0;
            while (counter < index) {
                returnElement = returnElement.next();
                counter++;
            }
        } else {
            returnElement = header.prev();
            int backCounter = size() - 1;
            while (backCounter > index) {
                returnElement = returnElement.prev();
                backCounter--;
            }
        }
        returnElement.setValue(element);
    }

    @Override
    public <T extends E> int indexOf(T element) {
        if (!this.isEmpty()) {
            Element elementCounter = header.next();
            for (int i = 0; i < size(); i++) {
                if (elementCounter.getValue().equals(element)) {
                    return i;
                }
                elementCounter = elementCounter.next();
            }
        }
        return -1;
    }

    @Override
    public <T extends E> void add(T element) {
        Element<T> newEl = new Element<T>(header.prev(), element);
        header.prev().setNext(newEl);
        newEl.setNext(header);
        size++;
    }

    @Override
    public <T extends E> void add(int index, T element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Element elementCounter;
        if (index <= size() / 2) {
            int counter = 0;
            elementCounter = header.next();
            while (counter < index) {
                counter++;
                elementCounter = elementCounter.next();
            }
        } else {
            elementCounter = header.prev();
            int backCounter = size() - 1;
            while (backCounter > index) {
                backCounter--;
                elementCounter = elementCounter.prev();
            }
        }
        elementCounter.prev().setNext(new Element(element));
        elementCounter.prev().next().setNext(elementCounter);
        size++;
    }

    @Override
    public <T extends E> void addAll(T[] elementsArray) {
        for (T el : elementsArray) {
            this.add(el);
        }
    }

    @Override
    public <T extends E> void addAll(int index, T[] elementsArray) {
        {
            if (index < 0 || index >= size())
                throw new IndexOutOfBoundsException();
            Element elementCounter;
            if (index <= size() / 2) {
                int counter = 0;
                elementCounter = header.next();
                while (counter < index) {
                    counter++;
                    elementCounter = elementCounter.next();
                }
            } else {
                elementCounter = header.prev();
                int backCounter = size() - 1;
                while (backCounter > index) {
                    backCounter--;
                    elementCounter = elementCounter.prev();
                }
            }
            Element iteratorNew = elementCounter.prev();
            for (E el : elementsArray) {
                iteratorNew.setNext(new Element(el));
                iteratorNew = iteratorNew.next();
            }
            iteratorNew.setNext(elementCounter);
            size += elementsArray.length;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @Nullable
    public E[] toArray() {
        if (!this.isEmpty()) {
            E[] array = (E[]) (new Object[size()]);
            Element<E> elementCounter = header.next();
            for (int i = 0; i < size(); i++) {
                array[i] = elementCounter.getValue();
                if (elementCounter.next() != header) {
                    elementCounter = elementCounter.next();
                }
            }
            return array;
        } else return null;
    }

    @Override
    public boolean isEmpty() {
        if (size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public <T extends E> boolean contains(T element) {
        if (!this.isEmpty()) {
            Element<E> elementCounter = header.next();
            for (int i = 0; i < size(); i++) {
                if (elementCounter.getValue().equals(element)) {
                    return true;
                } else {
                    if (elementCounter.next() != header) {
                        elementCounter = elementCounter.next();
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public E getFirst() {
        if (!this.isEmpty()) {
            return (E) header.next().value;
        }
        return null;
    }

    @Nullable
    public E getLast() {
        if (!this.isEmpty()) {
            return (E) header.prev().value;
        }
        return null;
    }

    private static class Element<E> {
        private Element next;
        private Element prev;
        E value;

        public <T extends E> Element(T value) {
            this.value = value;
        }

        public <T extends E> Element(Element prev, T value) {
            this.prev = prev;
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

        Element prev() {
            return prev;
        }

        void remove() {
            if (prev() != null) {
                prev.next = next();
                next.prev = prev();
            }
        }

        void setNext(Element next) {
            this.next = next;
            next.prev = this;
        }

        E getValue() {
            return value;
        }

        <T extends E> void setValue(T value) {
            this.value = value;
        }
    }
}
