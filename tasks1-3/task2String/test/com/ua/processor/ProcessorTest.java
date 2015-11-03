package com.ua.processor;

import com.ua.classes.Text;
import com.ua.classes.Word;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by AlxEx on 02.11.2015.
 */
public class ProcessorTest {

    @Test
    public void testParser() throws Exception {
        String stringExpected = "У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том.";
        String stringActual = (new Processor().parser(stringExpected)).toString();

        assertEquals(stringExpected, stringActual);
    }

    @Test
    public void testSortedBySymb() throws Exception {
        String stringExpected = "У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том.";
        Text text = new Processor().parser(stringExpected);
        List<Word> textChanged = new Processor().sortedBySymb(text,'У');
        assertEquals(stringExpected, text.toString());
    }
}