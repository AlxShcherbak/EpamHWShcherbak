import java.util.*;

/**
 * Created by AlxEx on 22.10.2015.
 */
public class Main {
    static void some() throws Exception{

        try {
            throw new Exception("k");
        } finally {
            throw new Exception("m");
        }
    }

    public static void main(String... args) {
        Map<Integer, Integer> map = new TreeMap<>();
        //System.out.print(map instanceof Collection);
        try{
            some();
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
