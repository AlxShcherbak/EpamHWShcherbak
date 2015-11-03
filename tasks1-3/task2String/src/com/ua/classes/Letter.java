package com.ua.classes;

/**
 * Created by AlxEx on 30.10.2015.
 */
public class Letter {
    private char aChar;

    public Letter(char aChar) {
        this.aChar = aChar;
    }

    public char getaChar() {
        return aChar;
    }

    @Override
    public String toString() {
        return String.valueOf(aChar);
    }
}
