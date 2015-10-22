package classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by AlxEx on 23.10.2015.
 */
public class MyArrayListTest {

    @org.junit.Test
    public void testAddListEmpty() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);

        assertEquals(testList.get(0), (Integer) 0);
        assertEquals(testList.size(), 1);
    }


    @org.junit.Test
    public void testAddListNotEmpty() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals(testList.get(1), (Integer) 1);
        assertEquals(testList.get(2), (Integer) 2);

        assertEquals(testList.size(), 3);
    }

    @org.junit.Test
    public void testAddWithIndex() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        testList.add(1, 5);

        assertEquals(testList.get(1), (Integer) 5);


        assertEquals(testList.size(), 4);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexIndexBoundsExcLess() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        testList.add(-1, 5);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexIndexBoundsExcMore() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        testList.add(3, 5);
    }

    @org.junit.Test
    public void testAddAllListEmpty() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        Integer[] arrayInput = {0, 1, 2, 3};
        testList.addAll(arrayInput);

        assertEquals(testList.get(0), (Integer) 0);
        assertEquals(testList.get(2), (Integer) 2);
        assertEquals(testList.get(3), (Integer) 3);

        assertEquals(testList.size(), 4);
    }

    @org.junit.Test
    public void testAddAllListNotEmpty() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        Integer[] arrayInput = {3, 4, 5};
        testList.addAll(arrayInput);


        assertEquals(testList.get(0), (Integer) 0);
        assertEquals(testList.get(2), (Integer) 2);
        assertEquals(testList.get(3), (Integer) 3);
        assertEquals(testList.get(5), (Integer) 5);


        assertEquals(testList.size(), 6);
    }

    @org.junit.Test
    public void testAddAllWithIndex() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        Integer[] arrayInput = {3, 4, 5};
        testList.addAll(1, arrayInput);


        assertEquals(testList.get(0), (Integer) 0);
        assertEquals(testList.get(2), (Integer) 4);
        assertEquals(testList.get(3), (Integer) 5);
        assertEquals(testList.get(5), (Integer) 2);

        assertEquals(testList.size(), 6);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndexIndexBoundsExc() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        Integer[] arrayInput = {3, 4, 5};

        testList.addAll(-6, arrayInput);
        testList.addAll(-1, arrayInput);
        testList.addAll(3, arrayInput);
        testList.addAll(6, arrayInput);
    }

    @org.junit.Test
    public void testGet() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();

        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals(testList.get(0), (Integer) 0);
        assertEquals(testList.get(1), (Integer) 1);
        assertEquals(testList.get(2), (Integer) 2);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithIndexIndexBoundsExc() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        testList.get(-10);
        testList.get(-1);
        testList.get(3);
        testList.get(10);
    }

    @org.junit.Test
    public void testRemove() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        Integer[] arrayInput = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        testList.addAll(arrayInput);

        assertEquals(testList.remove(0), (Integer) 0);

        assertEquals(testList.get(0), (Integer) 1);
        assertEquals(testList.get(1), (Integer) 2);
        assertEquals(testList.get(7), (Integer) 8);
        assertEquals(testList.size(), 8);

        //------------------------------------------------------------------------
        testList = new MyArrayList<>();
        testList.addAll(arrayInput);

        assertEquals(testList.remove(5), (Integer) 5);

        assertEquals(testList.get(0), (Integer) 0);
        assertEquals(testList.get(5), (Integer) 6);
        assertEquals(testList.get(6), (Integer) 7);
        assertEquals(testList.size(), 8);

        //------------------------------------------------------------------------
        testList = new MyArrayList<>();
        testList.addAll(arrayInput);

        assertEquals(testList.remove(8), (Integer) 8);

        assertEquals(testList.get(0), (Integer) 0);
        assertEquals(testList.get(1), (Integer) 1);
        assertEquals(testList.get(7), (Integer) 7);
        assertEquals(testList.size(), 8);
    }

    @org.junit.Test
    public void testSet() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();
        Integer[] arrayInput = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        testList.addAll(arrayInput);

        testList.set(0, 5);
        testList.set(6, 1);
        testList.set(8, 1);

        assertEquals(testList.get(0), (Integer) 5);
        assertEquals(testList.get(6), (Integer) 1);
        assertEquals(testList.get(8), (Integer) 1);
        assertEquals(testList.size(), 9);
    }

    @org.junit.Test
    public void testIndexOf() throws Exception {

    }

    @org.junit.Test
    public void testSize() throws Exception {
        MyArrayList<Integer> testList = new MyArrayList<>();

        assertEquals(testList.size(), 0);

        //------------------------------------------------------------------------
        Integer[] arrayInput = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        testList.addAll(arrayInput);

        assertEquals(testList.size(), 9);
    }

    @org.junit.Test
    public void testToArray() throws Exception {

    }

    @org.junit.Test
    public void testIsEmpty() throws Exception {

        MyArrayList<Integer> testList = new MyArrayList<>();

        assertTrue(testList.isEmpty());

        //------------------------------------------------------------------------
        Integer[] arrayInput = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        testList.addAll(arrayInput);

        assertFalse(testList.isEmpty());
    }

    @org.junit.Test
    public void testContains() throws Exception {

    }
}