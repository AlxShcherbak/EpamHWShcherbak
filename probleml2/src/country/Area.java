package country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Area {
    String title;
    List<District> districts = new ArrayList<>();
    City centerCity;

    public double calcSquare(){
        double squre = 0;
        for (District ditr :districts){
            squre += ditr.getSquare();
        }
        return squre;
    }

    public void setCenterCity(City centerCity) {
        this.centerCity = centerCity;
    }

    public Area(String title, City centerCity) {
        this.title = title;
        this.centerCity = centerCity;
    }

    public void addDistrict(District district){
        districts.add(district);
    }

    public String getTitle() {
        return title;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public City getCenterCity() {
        return centerCity;
    }
}
