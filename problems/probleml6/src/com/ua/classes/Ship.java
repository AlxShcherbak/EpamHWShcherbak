package com.ua.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by AlxEx on 10.11.2015.
 */
public class Ship {
    private Set<Cell> cells = new HashSet<>(4);
    private boolean killed;
    private int cellNumb;

    public boolean shot(Cell shotCell) {
        for (Cell cell : cells) {
            if (cell == shotCell) {
                return true;
            }
        }
        //System.out.println("Ship shoted" );
        return false;
    }

    public boolean isKilled() {
        if (!killed)
            for (Cell cell : cells) {
                if (!cell.isShoted()) {
                    return false;
                }
            }
        killed = true;
        return true;
    }

    private int getCellNumb() {
        return cellNumb;
    }
}
