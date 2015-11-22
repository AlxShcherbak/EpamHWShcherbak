package com.ua.classes;

/**
 * Created by AlxEx on 10.11.2015.
 */
public class Cell {
    private boolean shoted;
    private boolean shipOn;

    public Cell() {
    }

    public void shot() {
        shoted = true;
    }

    public boolean isShoted() {
        return shoted;
    }

    public boolean isShipOn() {
        return shipOn;
    }

    public void setShip(){
        shipOn = true;
    }
}
