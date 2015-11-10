package com.ua.classes;

/**
 * Created by AlxEx on 10.11.2015.
 */
public abstract class AbstractPlayer {
    protected Field[] fields = new Field[2];

    public AbstractPlayer() {
    }

    public void createFields() {
        for (Field field : fields) {
            field = new Field();
        }
    }

    public Field getMyField() {
        return fields[0];
    }

    public Field getOprtField() {
        return fields[1];
    }

    public void setFields(Field myField, Field oprField) {
        fields[0] = myField;
        fields[1] = oprField;
    }

    public boolean gameOver() {
        if (fields[0].allShipsKilled() || fields[1].allShipsKilled()) {
            return true;
        }
        return false;
    }

    abstract void doMove();

}
