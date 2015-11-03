package com.ua.classes;

import com.ua.classes.interfaces.SentencePart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlxEx on 30.10.2015.
 */
public class Word implements SentencePart {
    private List<Letter> letterList;

    public Word() {
        this.letterList = new ArrayList<>();
    }

    public Word(List<Letter> letterList) {
        this.letterList = letterList;
    }

    public void addLetter(Letter letter) {
        this.letterList.add(letter);
    }

    public boolean isEmpty() {
        return letterList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Letter letter : letterList) {
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }

    public List<Letter> getLetterList() {
        return letterList;
    }

    @Override
    public boolean lasSymbolIsSpase() {
        return letterList.get(letterList.size() - 1).getaChar() == ' ';
    }
}
