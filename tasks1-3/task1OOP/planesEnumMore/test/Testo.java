import com.ua.Airlines;
import com.ua.Plane;
import com.ua.PlaneFactory;
import com.ua.eNums.PlaneModel;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by AlxEx on 29.10.2015.
 */
public class Testo {
    private static PlaneFactory planeFactory = PlaneFactory.getPlaneFactory();

    public static void main(String... args) {
        Plane boing747 = new Plane("B747", PlaneModel.BOING_747, new GregorianCalendar()),
                boing777 = new Plane("B777", PlaneModel.BOING_777_300ER, new GregorianCalendar()),
                an225 = new Plane("AN225", PlaneModel.AN_225, new GregorianCalendar()),
                an24 = new Plane("AN24", PlaneModel.AN_24, new GregorianCalendar()),
                tu154 = new Plane("Tu154", PlaneModel.Tu_154, new GregorianCalendar());
        System.out.println();
        System.out.println(PlaneModel.AN_225.toString());

        List<Plane> planeList = new ArrayList<>();
        planeList.add(planeFactory.plane("B747", PlaneModel.BOING_747));
        planeList.add(planeFactory.plane("AN24-1", PlaneModel.AN_24));
        planeList.add(planeFactory.plane("AN24-2", "AN24"));
        planeList.add(planeFactory.plane("AN24-3", "АН 24"));
        planeList.add(planeFactory.plane("AN225-1", "АН-225"));
        planeList.add(planeFactory.plane("boing 777-1", "boing777"));

        Airlines airlines = new Airlines(planeList);
        airlines.addPlane(tu154);

        System.out.println();
        for (Plane plane : planeList) {
            System.out.println(plane + " : range = " + plane.range());
        }

        airlines.sortPlanesByRange();

        int i = 0;
        System.out.println();
        for (Plane plane : airlines.getPlanes()) {
            System.out.println(i++ + " : range = " + plane.range());
        }

        List<Plane> planesByFlueCons = airlines.searchPlanesByFlueConsuption(1,10);

        System.out.println();
        for (Plane plane : planesByFlueCons) {
            System.out.println(plane + " : flueCons = " + plane.fuelConsuption());
        }

        planesByFlueCons = airlines.searchPlanesByFlueConsuption(10,20);

        System.out.println();
        for (Plane plane : planesByFlueCons) {
            System.out.println(plane + " : flueCons = " + plane.fuelConsuption());
        }

        System.out.println();
        for (Plane plane : planeList) {
            System.out.println(plane);
        }

        System.out.println();
        System.out.println(airlines.getCapacity());

    }
}
