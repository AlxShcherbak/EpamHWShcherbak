package com.ua;

import com.ua.eNums.PlaneModel;

import java.util.GregorianCalendar;

/**
 * Created by AlxEx on 29.10.2015.
 */
public class PlaneFactory {
    private static PlaneFactory planeFactory = new PlaneFactory();

    private PlaneFactory() {

    }

    public static PlaneFactory getPlaneFactory() {
        return planeFactory;
    }

    public Plane plane(String bortNumber, PlaneModel planeModel) {
        return new Plane(bortNumber, planeModel, new GregorianCalendar());
    }

    public Plane plane(String bortNumber, String planeModel) {
        String planeModelLC = new String(planeModel.toLowerCase());
        if (planeModelLC.equals(PlaneModel.AN_225.toString().toLowerCase()) || planeModelLC.equals("an225")
                || planeModelLC.equals("an-225") || planeModelLC.equals("an 225") || planeModelLC.equals("ан225")
                || planeModelLC.equals("ан-225") || planeModelLC.equals("ан 225")) {
            return new Plane(bortNumber, PlaneModel.AN_225, new GregorianCalendar());
        }
        if (planeModelLC.equals(PlaneModel.AN_24.toString().toLowerCase()) || planeModelLC.equals("an24")
                || planeModelLC.equals("an-24") || planeModelLC.equals("an 24") || planeModelLC.equals("ан24")
                || planeModelLC.equals("ан-24") || planeModelLC.equals("ан 24")) {
            return new Plane(bortNumber, PlaneModel.AN_24, new GregorianCalendar());
        }
        if (planeModelLC.equals(PlaneModel.Tu_154.toString().toLowerCase()) || planeModelLC.equals("tu154")
                || planeModelLC.equals("tu-154") || planeModelLC.equals("tu 154") || planeModelLC.equals("ту154")
                || planeModelLC.equals("ту-154") || planeModelLC.equals("ту 154")) {
            return new Plane(bortNumber, PlaneModel.Tu_154, new GregorianCalendar());
        }
        if (planeModelLC.equals(PlaneModel.BOING_747.toString().toLowerCase()) || planeModelLC.equals("boing747")
                || planeModelLC.equals("boing-747") || planeModelLC.equals("boing 747")) {
            return new Plane(bortNumber, PlaneModel.BOING_747, new GregorianCalendar());
        }
        if (planeModelLC.equals(PlaneModel.BOING_777_300ER.toString().toLowerCase()) || planeModelLC.equals("boing777")
                || planeModelLC.equals("boing-777") || planeModelLC.equals("boing_777")
                || planeModelLC.equals("boing 777")) {
            return new Plane(bortNumber, PlaneModel.BOING_777_300ER, new GregorianCalendar());
        }
        else throw new IllegalArgumentException("no match plane model");
    }
}
