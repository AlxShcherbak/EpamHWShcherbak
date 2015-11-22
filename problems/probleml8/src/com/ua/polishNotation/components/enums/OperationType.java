package com.ua.polishNotation.components.enums;

/**
 * Created by AlxEx on 22.11.2015.
 */
public enum OperationType {
    ADDITION, MULTIPLICATION, DIVISION, MINUS;

    public static OperationType getOpType(String str) {
        if (str.equals("-")) return MINUS;
        else if (str.equals("*")) return MULTIPLICATION;
        else if (str.equals("/")) return DIVISION;
        return ADDITION;
    }
}
