package com.ua.polishNotation.components.factory;

import com.ua.polishNotation.components.*;
import com.ua.polishNotation.components.Number;
import com.ua.polishNotation.components.enums.OperationType;

/**
 * Created by AlxEx on 22.11.2015.
 * Фабрика генерации обьектов AbstractComponent (примитивов Number и композиты Addition, Minus, Multiplication, Division
 *
 * @author AlxEx
 * @see com.ua.polishNotation.components.Number
 * @see com.ua.polishNotation.components.Addition
 * @see com.ua.polishNotation.components.Minus
 * @see com.ua.polishNotation.components.Division
 * @see com.ua.polishNotation.components.Multiplication
 */
public class ComponentFactory {
    public static AbstractComponent getComponent(double value) {
        return new Number(value);
    }

    public static AbstractComponent getComponent(String strType) {
        OperationType opT = OperationType.getOpType(strType);
        switch (opT) {
            case ADDITION:
                return new Addition();
            case MINUS:
                return new Minus();
            case MULTIPLICATION:
                return new Multiplication();
            case DIVISION:
                return new Division();
        }
        return new Number(0);
    }
}
