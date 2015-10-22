package classes;

import com.sun.istack.internal.Nullable;

/**
 * Created by AlxEx on 22.10.2015.
 */
public class MyLinkedListDouble<E> implements MyList<E>, Container<E> {
    Element<E> first;
    Element<E> last;
    int size = 0;

    public MyLinkedListDouble() {
    }

    public MyLinkedListDouble(E value) {
        first = new Element<E>(value);
        last = first;
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
        return this;
    }

    @Override
    public void add(E element) {
        if (isEmpty()) {
            first = new Element(element);
            last = first;
        } else {
            last.setNext(new Element(element));
            last = last.next();
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Element elementCounter;
        if (index <= size() / 2) {
            int counter = 0;
            elementCounter = first;
            while (counter < index) {
                counter++;
                elementCounter = elementCounter.next();
            }
        } else {
            elementCounter = last;
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
    public void addAll(E[] elementsArray) {
        for (E el : elementsArray) {
            this.add(el);
        }
    }

    @Override
    public void addAll(int index, E[] elementsArray) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Element elementCounter;
        if (index <= size() / 2) {
            int counter = 0;
            elementCounter = first;
            while (counter < index) {
                counter++;
                elementCounter = elementCounter.next();
            }
        } else {
            elementCounter = last;
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

    @Override
    public E get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Element<E> returnElement;
        if (index <= size() / 2) {
            returnElement = first;
            int counter = 0;
            while (counter < index) {
                returnElement = returnElement.next();
                counter++;
            }
            return returnElement.getValue();
        } else {
            returnElement = last;
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
        if (index == 0) {
            returnValue = first.getValue();
            first = first.next();
            first.prev = null;
        } else if (index == size() - 1) {
            returnValue = last.getValue();
            last = last.prev();
            last.next = null;
        } else if (index <= size() / 2) {
            returnElement = first;
            int counter = 0;
            while (counter < index) {
                returnElement = returnElement.next();
                counter++;
            }
            returnValue = returnElement.getValue();
            returnElement.remove();
        } else {
            returnElement = last;
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
    public void set(int index, E element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        Element<E> returnElement;
        if (index <= size() / 2) {
            returnElement = first;
            int counter = 0;
            while (counter < index) {
                returnElement = returnElement.next();
                counter++;
            }
        } else {
            returnElement = last;
            int backCounter = size() - 1;
            while (backCounter > index) {
                returnElement = returnElement.prev();
                backCounter--;
            }
        }
        returnElement.setValue(element);
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        return null;
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
    public boolean contains(E element) {
        return false;
    }

    @Nullable
    public E getFirst() {
        if (!this.isEmpty()) {
            return first.value;
        }
        return null;
    }

    @Nullable
    public E getLast() {
        if (!this.isEmpty()) {
            return last.value;
        }
        return null;
    }

    protected class Element<E> {
        private Element next;
        private Element prev;
        E value;

        public Element(E value) {
            this.value = value;
        }

        public Element(Element prev, E value) {
            this.prev = prev;
            this.value = value;
        }

        boolean hasNext() {
            return false;
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

        void setValue(E value) {
            this.value = value;
        }
    }
}
