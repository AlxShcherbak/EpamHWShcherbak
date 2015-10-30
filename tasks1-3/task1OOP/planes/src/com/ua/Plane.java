package com.ua;

import com.ua.enums.Engine;
import com.ua.enums.PlaneType;

/**
 * Created by AlxEx on 29.10.2015.
 */
public class Plane implements Comparable {
    private String bortNumber;
    private String planeModel;
    private PlaneType planeType;

    private Engine engine;
    private int engineNumber;
    private double speed;

    private double flueCapacity;
    private double cargoCapacity;
    private int passCapacity;

    public Plane(String bortNumber, String planeModel, PlaneType planeType, Engine engine, int engineNumber,
                 double speed, double flueCapacity, double cargoCapacity, int passCapacity) {
        this.bortNumber = bortNumber;
        this.planeModel = planeModel;
        this.planeType = planeType;
        this.engine = engine;
        this.engineNumber = engineNumber;
        this.speed = speed;
        this.flueCapacity = flueCapacity;
        this.cargoCapacity = cargoCapacity;
        this.passCapacity = passCapacity;
    }

    @Override
    public int compareTo(Object o) {
        Plane other = (Plane) o;
        if (this.range() - other.range() < -0.01) {
            return -1;
        } else if (this.range() - other.range() <= 0.01) {
            return 0;
        } else return 1;
    }

    public double range() {
        return flueCapacity * 0.9 / fuelConsuption() * speed;
    }

    public double fuelConsuption() {
        return engine.getFuelConsuption() * engineNumber;
    }

    public String getBortNumber() {
        return bortNumber;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getEngineNumbers() {
        return engineNumber;
    }

    public double getSpeed() {
        return speed;
    }

    public double getFlueCapacity() {
        return flueCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public int getPassCapacity() {
        return passCapacity;
    }
}
