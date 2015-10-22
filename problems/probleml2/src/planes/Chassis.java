package planes;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Chassis {
    private int landingGears;   // количество стоек шасси 1 стойка -> 2 колесса
    private double maxWeight;

    public Chassis(int landingGears, double maxWeight) {
        this.landingGears = landingGears;
        this.maxWeight = maxWeight;
    }

    public int getLandingGears() {
        return landingGears;
    }

    public double getMaxWeight() {
        return maxWeight;
    }
}
