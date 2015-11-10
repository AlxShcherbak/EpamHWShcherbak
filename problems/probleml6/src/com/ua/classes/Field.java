package com.ua.classes;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * Created by AlxEx on 10.11.2015.
 */
public class Field {
    private Cell[][] cells = new Cell[10][10];
    private Ship[] ships = new Ship[10];

    public Field() {
        for (Cell[] celles : cells) {
            for (Cell cell : celles) {
                cell = new Cell();
            }
        }
        for (Ship ship : ships) {
            ship = new Ship();
        }
    }

    public boolean[] shot(int x, int y) {
        boolean[] retArray = new boolean[]{false, false};
        Cell cell = cells[x][y];
        cell.shot();
        for (Ship ship : ships) {
            retArray[0] = ship.shot(cell);
            if (retArray[0]) {
                retArray[1] = ship.isKilled();
                return retArray;
            }
        }
        return retArray;
    }

    public boolean allShipsKilled() {
        for (Ship ship : ships) {
            if (!ship.isKilled()) {
                return false;
            }
        }
        return true;
    }

    public boolean cellShoted(int x, int y) {
        boolean returnValue = cells[x][y].isShoted();
        if (!returnValue){
            returnValue = cells[x+1][y+1].isShoted();
        }
        if (!returnValue){
            returnValue = cells[x+1][y-1].isShoted();
        }
        if (!returnValue){
            returnValue = cells[x+1][y-1].isShoted();
        }
        if (!returnValue){
            returnValue = cells[x-1][y-1].isShoted();
        }
        return returnValue;
    }

    public void setShips(int[][] koordCells){

    }
}
