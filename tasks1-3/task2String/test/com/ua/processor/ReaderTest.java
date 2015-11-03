package com.ua.processor;

import com.ua.classes.Text;

import static org.junit.Assert.*;

/**
 * Created by AlxEx on 30.10.2015.
 */
public class ReaderTest {

    @org.junit.Test
    public void testReadFile() throws Exception {
        String stringActual = new Reader().readFile("testDataSourse/UlukomoriyaTest");
        String stringExpected = "У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том:\n" +
                "И днём и ночью кот учёный\n" +
                "Всё ходит по цепи кругом;\n" +
                "Идёт направо - песнь заводит,\n" +
                "Налево - сказку говорит.";

        assertEquals(stringExpected,stringActual);



    }
}