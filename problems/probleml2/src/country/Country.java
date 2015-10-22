package country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Country {
    String title;
    List<Area> areas = new ArrayList<>();
    City capital;

    public double calcSquare() {
        double square = 0;
        for (Area area : areas) {
            square += area.calcSquare();
        }
        return square;
    }

    public void printSquare() {
        System.out.println("Square of " + this.title + " = " + this.calcSquare());
    }

    public void printAreas() {
        System.out.println("numbers of areas = " + areas.size());
        System.out.printf("%-4s %-15s %-10s \n", "", "Title area", "center city");
        int i = 1;
        for (Area area : areas) {
            System.out.printf("%-4d %-15s %-10s \n", i++, area.getTitle(), area.getCenterCity());
        }
    }

    public void printCapital() {
        System.out.println("Capital of " + this.getTitle() + " is " + this.capital.getTitle());
    }


    public Country(String title, City capital) {
        this.title = title;
        this.capital = capital;
    }

    public void addArea(Area area) {
        areas.add(area);
    }


    public String getTitle() {
        return title;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public City getCapital() {
        return capital;
    }
}
