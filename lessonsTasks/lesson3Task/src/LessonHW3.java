/**
 * Created by AlxEx on 22.10.2015.
 */
public class LessonHW3 {

    public static void print(Integer s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void main(String... args) {
        /*
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(0);
        myArrayList.add(1);
        Integer[] ar = {2,3,4,5,6,7,8,9,10};
        myArrayList.addAll(ar);
        System.out.println(myArrayList.contains(8));
        System.out.println(myArrayList.indexOf(8));
        System.out.println(myArrayList.get(8));
        System.out.println(myArrayList.remove(6));
        System.out.print("some");*/


        MyLinkedListDouble<Integer> myLinkedListDouble0 = new MyLinkedListDouble<>(0),
                myLinkedListDouble1 = new MyLinkedListDouble<>();
        for (int i = 1; i < 10; i++) {
            myLinkedListDouble0.add(0);
        }

        Integer[] arrayInt = {1, 2, 3, 4};
        myLinkedListDouble0.addAll(5, arrayInt);

        for (int i = 0; i < myLinkedListDouble0.size(); i++) {
            print("S" + i + "\t= " + myLinkedListDouble0.get(i) + "\n");
        }
        print("Size = " + myLinkedListDouble0.size() + "\n");

        /*print(myLinkedListDouble0.get(1));
        print(myLinkedListDouble0.get(5));
        print(myLinkedListDouble0.get(9));

        myLinkedListDouble0.add(2, 0);
        myLinkedListDouble0.add(7, 0);

        print(myLinkedListDouble0.get(2));
        print(myLinkedListDouble0.get(3));
        print(myLinkedListDouble0.get(7));
        print(myLinkedListDouble0.get(8));*/

        System.out.print("some");
    }
}
