package country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class District {
    String title;
    List<City> cities = new ArrayList<>();
    double square;

    public District(String title, double square) {
        this.title = title;
        this.square = square;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public String getTitle() {
        return title;
    }

    public List<City> getCities() {
        return cities;
    }

    public double getSquare() {
        return square;
    }
}
