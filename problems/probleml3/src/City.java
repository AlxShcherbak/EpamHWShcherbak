import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlxEx on 03.11.2015.
 * <p>
 * Создать класс  City с внутренним классом, с помощью объектов которого
 * можно хранить информацию о проспектах, улицах, площадях.
 */

public class City {
    private List<Street> streets = new ArrayList<>();

    public City() {
    }

    public void addStreet(Street street){
        streets.add(street);
    }

    public List<Street> getStreets() {
        return streets;
    }

    public static enum StreetType{
        STREET, SQUARE, AVENUE;
    }

    protected class Street{
        String title;
        int buildNumb;
        StreetType streetType;
        double length;

        public Street(String title, int buildNumb, StreetType streetType, double length) {
            this.title = title;
            this.buildNumb = buildNumb;
            this.streetType = streetType;
            this.length = length;
        }
    }
}
