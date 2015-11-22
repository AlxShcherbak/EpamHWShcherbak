package com.ua;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AlxEx on 20.11.2015.
 */
public class HuffmanStringTest {
    @Test
    public void testParse() {
        String string = "У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том.";
        HuffmanString huffmanString = new HuffmanString(string);
        //System.out.println(huffmanString);
    }

    @Test
    public void testEquality() throws Exception {
        String string = "У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том.";
        HuffmanString huffmanString = new HuffmanString(string);
        assertTrue(huffmanString.equality(string));
    }
}