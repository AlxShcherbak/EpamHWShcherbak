import java.util.Arrays;

/**
 * Created by AlxEx on 22.10.2015.
 */
public class Main {
    public static void main(String... args) {
        Double[] arrayA = {0d, 1d, 200d, 500d};
        Double[] arrayB = arrayA.clone();
        Double[] arrayC = Arrays.copyOf(arrayA, 4);


        int[] array = {0, 1, 2, 3, 4, 5, 6};
        int[] newArray = new int[10];


        System.arraycopy(array, 4, array, 3, 3);
        System.out.println(arrayB);
    }
}
