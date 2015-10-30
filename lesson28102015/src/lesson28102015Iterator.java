import java.util.Iterator;

/**
 * Created by AlxEx on 28.10.2015.
 */

class MyArray<T> implements Iterable {
    T a[];

    class MyIterator<T> implements Iterator<T> {
        int current = -1;

        @Override
        public boolean hasNext() {
            return current < a.length - 1;
        }

        @Override
        public T next() {
            return (T) a[++current];
        }
    }

    public MyArray(int n) {
        a = (T[]) (new Object[n]);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
}

public class lesson28102015Iterator {
    public static void main(String... args) {
        MyArray<Integer> m = new MyArray<Integer>(10);
        for (Object a : m) {
            System.out.print((Integer) a);
        }
    }
}
