package com.ua.classes;

import com.ua.classes.interfaces.SentencePart;
import com.ua.classes.interfaces.TextPart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlxEx on 30.10.2015.
 */
public class Sentence implements TextPart {
    private List<SentencePart> sentParts;

    public Sentence() {
        sentParts = new ArrayList<>();
    }

    public Sentence(List<SentencePart> sentens) {
        this.sentParts = sentens;
    }

    public void addPart(SentencePart sentencePart) {
        this.sentParts.add(sentencePart);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (SentencePart sentPart : sentParts) {
            stringBuilder.append(sentPart);
        }
        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        return sentParts.isEmpty();
    }

    @Override
    public boolean lasSymbolIsSpase() {
        return sentParts.get(sentParts.size() - 1).lasSymbolIsSpase();
    }

    public List<SentencePart> getSentParts() {
        return sentParts;
    }
}
