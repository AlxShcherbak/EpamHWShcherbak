package country;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class City {
    String title;
    int population;

    public City(String title, int population) {
        this.title = title;
        this.population = population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getTitle() {
        return title;
    }

    public int getPopulation() {
        return population;
    }
}
