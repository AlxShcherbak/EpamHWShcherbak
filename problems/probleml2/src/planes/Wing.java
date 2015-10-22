package planes;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Wing {
    private double wingspan;
    private double flueCapacity;

    public Wing(double wingspan, double flueCapacity) {
        this.wingspan = wingspan;
        this.flueCapacity = flueCapacity;
    }

    public double getWingspan() {
        return wingspan;
    }

    public double getFlueCapacity() {
        return flueCapacity;
    }
}
