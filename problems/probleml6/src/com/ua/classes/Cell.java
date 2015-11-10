package com.ua.classes;

/**
 * Created by AlxEx on 10.11.2015.
 */
public class Cell {
    private boolean shoted;

    public Cell() {
    }

    public void shot() {
        shoted = true;
    }

    public boolean isShoted() {
        return shoted;
    }
}
