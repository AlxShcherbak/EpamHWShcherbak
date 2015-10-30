package com.ua;

import com.ua.eNums.PlaneModel;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by AlxEx on 29.10.2015.
 */
public class Plane implements Comparable {
    private String bortNumber;
    private PlaneModel planeModel;
    private GregorianCalendar yearDev;

    public Plane(String bortNumber, PlaneModel planeModel, GregorianCalendar yearDev) {
        this.bortNumber = bortNumber;
        this.planeModel = planeModel;
        this.yearDev = yearDev;
    }

    public String getBortNumber() {
        return bortNumber;
    }

    public PlaneModel getPlaneModel() {
        return planeModel;
    }

    public GregorianCalendar getYearDev() {
        return yearDev;
    }

    public double getCargoCapacity() {
        return planeModel.getCargoCapacity();
    }

    public int getPassengerCapacity() {
        return planeModel.getPassengerCapacity();
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
        return planeModel.range();
    }

    public double fuelConsuption() {
        return planeModel.fuelConsuption();
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("M/yyyy");
        return "Plane { " +
                "bortNumber = " + bortNumber +
                "\t\tplaneModel = " + planeModel +
                "\tyearDev = " + fmt.format(yearDev.getTime()) +
                " }";
    }
}
