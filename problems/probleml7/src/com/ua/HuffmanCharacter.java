package com.ua;

/**
 * Created by AlxEx on 20.11.2015.
 */
public class HuffmanCharacter implements Comparable {
    private int counter;
    private char character;
    private byte code;

    public HuffmanCharacter(int counter, char character) {
        this.counter = counter;
        this.character = character;
    }

    public int getCounter() {
        return counter;
    }

    public char getCharacter() {
        return character;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    @Override
    public int compareTo(Object o) {
        HuffmanCharacter other = (HuffmanCharacter) o;
        return other.getCounter() - this.getCounter();
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    public boolean isAChar(char aChar) {
        return character == aChar;
    }
}
