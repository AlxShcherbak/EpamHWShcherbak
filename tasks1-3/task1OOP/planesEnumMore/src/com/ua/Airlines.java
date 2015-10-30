package com.ua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by AlxEx on 28.10.2015.
 */
public class Airlines {
    List<Plane> planes;

    public Airlines() {
        this.planes = new ArrayList<>();
    }

    public Airlines(List<Plane> planes) {
        this.planes = planes;
    }

    public Airlines(Plane plane) {
        this.planes = new ArrayList<>();
        this.planes.add(plane);
    }

    public Airlines(Plane[] planes) {
        this.planes = new ArrayList<>();
        this.planes.addAll(Arrays.asList(planes));
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public void sortPlanesByRange() {
        Collections.sort(planes);
    }

    /**
     * @param minFlueCons - minimum flue consuption     t/h = 10^3 kg/h
     * @param maxFlueCons
     * @return
     */
    public List<Plane> searchPlanesByFlueConsuption(double minFlueCons, double maxFlueCons) {
        List<Plane> returnPlanesList = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane.fuelConsuption() >= minFlueCons && plane.fuelConsuption() <= maxFlueCons){
                returnPlanesList.add(plane);
            }
        }
        return returnPlanesList;
    }
}
