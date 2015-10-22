package planes;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Plane {
    private String model;
    private int engineNumber;
    private Engine engine;
    private Chassis chassis;
    private Wing wing;

    private double maxWeight;
    private double range;
    private double passangerCapacity;
    private double goodsCapacity;

    private Course course;

    public void flight() {
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return this.course;
    }

    public void printCourse() {
        System.out.println(this.course.toString());
    }


    public Plane(String model, int engineNumber, Engine engine, Chassis chassis, Wing wing, double maxWeight,
                 double range, double passangerCapacity, double goodsCapacity) {
        this.model = model;
        this.engineNumber = engineNumber;
        this.engine = engine;
        this.chassis = chassis;
        this.wing = wing;
        this.maxWeight = maxWeight;
        this.range = range;
        this.passangerCapacity = passangerCapacity;
        this.goodsCapacity = goodsCapacity;
    }

    public Plane(String model, int engineNumber, Engine engine, Chassis chassis, Wing wing) {
        this.model = model;
        this.engineNumber = engineNumber;
        this.engine = engine;
        this.chassis = chassis;
        this.wing = wing;
    }

    public String getModel() {
        return model;
    }

    public int getEngineNumber() {
        return engineNumber;
    }

    public Engine getEngine() {
        return engine;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public Wing getWing() {
        return wing;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getRange() {
        return range;
    }

    public double getPassangerCapacity() {
        return passangerCapacity;
    }

    public double getGoodsCapacity() {
        return goodsCapacity;
    }

    public double puwerfull() {
        return engine.getPower() * engineNumber;
    }
}
