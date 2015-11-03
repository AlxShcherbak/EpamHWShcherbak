package com.ua.classes;

import com.ua.classes.interfaces.SentencePart;
import com.ua.classes.interfaces.TextPart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlxEx on 30.10.2015.
 */
public class Text {
    private List<Sentence> sentences;

    public Text() {
        this.sentences = new ArrayList<>();
    }

    public Text(List<Sentence> Sentences) {
        this.sentences = Sentences;
    }

    public void addSentence(Sentence Sentence) {
        this.sentences.add(Sentence);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sentence Sentence : sentences) {
            if (stringBuilder.length()!=0){
                stringBuilder.append(" " + Sentence);
            }else {
                stringBuilder.append(Sentence);
            }
        }
        return stringBuilder.toString();
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
