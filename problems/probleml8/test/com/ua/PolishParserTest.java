package com.ua;

import com.ua.polishNotation.operators.PolishParser;

/**
 * Created by AlxEx on 22.11.2015.
 */
public class PolishParserTest {

    @org.junit.Test
    public void testCalculate() throws Exception {
        double res = PolishParser.calculate("8+2*5/4*(1-6+-9/15-(2+6))");

    }
}