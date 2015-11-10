package com.ua.processor;

import com.ua.classes.Letter;
import com.ua.classes.Sentence;
import com.ua.classes.Text;
import com.ua.classes.Word;
import com.ua.classes.Character;
import com.ua.classes.interfaces.SentencePart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by AlxEx on 30.10.2015.
 */
public class Processor {

    /**
     * Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово,
     * Предложение, Знак препинания и др. Во всех задачах с формированием текста заменять табуляции и последовательности
     * пробелов одним пробелом.
     *
     * @param text
     * @return
     */
    public Text parser(String text) {
        char[] chars = text.toCharArray();
        Text returnText = new Text();
        Sentence buffSent = new Sentence();
        Word buffWord = new Word();

        for (int count = 0; count < chars.length; count++) {
            if (java.lang.Character.isDigit(chars[count]) || java.lang.Character.isLetter(chars[count])) {  // входной символ буква или цифра
                buffWord.addLetter(new Letter(chars[count]));
            } else {
                if (!buffWord.isEmpty()) {
                    buffSent.addPart(buffWord);
                    buffWord = new Word();
                }
                if (chars[count] != '\t' && chars[count] != ' ') {  // обработка табуляции и 2+ пробелов
                    buffSent.addPart(new Character(chars[count]));
                } else {
                    if (!buffSent.isEmpty() && !buffSent.lasSymbolIsSpase()) {  // исключение начала предложения с пробела
                        buffSent.addPart(new Character(' '));
                    }
                }
            }
            if (chars[count] == '.' || chars[count] == '!' || chars[count] == '?') {    // обработка конца предложения
                if (!(count + 1 < chars.length && (chars[count + 1] == '.'  // проверка на конец текста
                        || chars[count + 1] == '!' || chars[count + 1] == '?'))) {
                    returnText.addSentence(buffSent);
                    buffSent = new Sentence();
                }
            } else if (count == chars.length - 1) { // конец текста, обработка последней итерации
                buffSent.addPart(buffWord);
                returnText.addSentence(buffSent);
            }
        }
        return returnText;
    }

    /**
     * 13.	Отсортировать слова в тексте по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту
     *
     * @param sortedText       - исходный текст для сортировки слов
     * @param comperableSympol - символ для сортировки
     * @return
     */
    public List<Word> sortedBySymb(Text sortedText, char comperableSympol) {
        List<Word> wordList = new ArrayList<>();

        for (Sentence sentence : sortedText.getSentences()) {
            for (SentencePart sentencePart : sentence.getSentParts()) {
                if (Word.class.getName().equals(sentencePart.getClass().getName())) {
                    wordList.add((Word) sentencePart);
                }
            }
        }
        Collections.sort(wordList, new MyComparator(comperableSympol));
        return wordList;
    }

    private class MyComparator implements Comparator<Word> {
        char compChar;

        MyComparator(char compChar) {
            this.compChar = compChar;
        }

        @Override
        public int compare(Word t1, Word t2) {
            int chrContT1 = 0,
                    chrContT2 = 0;
            for (Letter letter : t1.getLetterList()) {
                if (java.lang.Character.toLowerCase(letter.getaChar()) == java.lang.Character.toLowerCase(compChar)) {
                    chrContT1++;
                }
            }
            for (Letter letter : t2.getLetterList()) {
                if (java.lang.Character.toLowerCase(letter.getaChar()) == java.lang.Character.toLowerCase(compChar)) {
                    chrContT2++;
                }
            }
            if (chrContT1 < chrContT2) return 1;
            else if (chrContT1 > chrContT2) return -1;
            else {
                int lengTLow = Math.min(t1.getLetterList().size(), t1.getLetterList().size());
                for (int i = 0; i < lengTLow; i++) {
                    if (java.lang.Character.toLowerCase(t1.getLetterList().get(i).getaChar()) >
                            java.lang.Character.toLowerCase(t2.getLetterList().get(i).getaChar()))
                        return 1;
                    else if (java.lang.Character.toLowerCase(t1.getLetterList().get(i).getaChar()) <
                            java.lang.Character.toLowerCase(t2.getLetterList().get(i).getaChar()))
                        return -1;
                    else if (t1.getLetterList().size() > t2.getLetterList().size()) return 1;
                    else if (t1.getLetterList().size() < t2.getLetterList().size()) return -1;
                }
            }
            return 0;
        }
    }
}
