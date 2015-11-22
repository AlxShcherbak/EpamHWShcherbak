package com.ua;

import java.util.*;

/**
 * Created by AlxEx on 20.11.2015.
 */
public class HuffmanString {
    /**
     * PriorityQueue of Huffman code character - top is most used character and down less used
     */
    final private PriorityQueue<HuffmanCharacter> huffmanPriorityQueue = new PriorityQueue<>();
    /**
     * Input String to ArrayList of HuffmanCharacters from PriorityQueue
     */
    final private ArrayList<HuffmanCharacter> huffmanString;


    public HuffmanString(String inputString) {
        huffmanCodeFromString(inputString);
        huffmanString = new ArrayList<>();
        for (char aChar : inputString.toCharArray()) {
            for (HuffmanCharacter huffmanCharacter : huffmanPriorityQueue) {
                if (huffmanCharacter.isAChar(aChar)) {
                    huffmanString.add(huffmanCharacter);
                    break;
                }
            }
        }
    }

    /**
     * Converted from string to HashMap, there key is character and value is counting off this character.
     * HashMap -> KeySet -> HuffmanPriorityQueue
     *
     * @param inputString
     */
    private void huffmanCodeFromString(String inputString) {
        //anonymous class extends from HashMap
        //overrided put();
        Map<Character, Integer> mapChars = new HashMap() {
            @Override
            public Object put(Object o, Object o2) {
                int value = 1;
                if (containsKey(o)) {
                    value += (Integer) get(o);
                }
                return super.put(o, value);
            }
        };

        for (char aChar : inputString.toCharArray()) {
            mapChars.put(aChar, 1);
        }

        for (Character ch : mapChars.keySet()) {
            huffmanPriorityQueue.offer(new HuffmanCharacter(mapChars.get(ch), ch));
        }
    }

    @Override
    public String toString() {
        StringBuilder returnValue = new StringBuilder("Huffman string - ");
        for (HuffmanCharacter huffmanCharacter : huffmanString) {
            returnValue.append(huffmanCharacter);
        }
        return returnValue.toString();
    }

    public boolean equality(String inpString) {
        for (int i = 0; i < inpString.length(); i++) {
            if (huffmanString.get(i).getCharacter() != inpString.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
