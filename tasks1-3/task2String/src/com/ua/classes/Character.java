package com.ua.classes;

import com.ua.classes.interfaces.SentencePart;
import com.ua.classes.interfaces.TextPart;

/**
 * Created by AlxEx on 30.10.2015.
 */
public class Character implements SentencePart, TextPart {
    private char aChar;

    public Character(char aChar) {
        this.aChar = aChar;
    }

    public char getaChar() {
        return aChar;
    }

    @Override
    public String toString() {
        return String.valueOf(aChar);
    }

    @Override
    public boolean lasSymbolIsSpase() {
        return aChar == ' ';
    }
}
