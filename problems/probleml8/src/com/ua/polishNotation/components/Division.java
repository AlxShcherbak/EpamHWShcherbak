package com.ua.polishNotation.components;

import com.ua.polishNotation.components.enums.OperationType;

/**
 * Created by AlxEx on 22.11.2015.
 * <p>
 * Оперерация Деления
 *
 * @author AlxEx
 * @see com.ua.polishNotation.components.AbstractComponent
 */
public class Division extends AbstractOperation {
    public Division() {
        operationType = OperationType.DIVISION;
    }

    @Override
    public double doOperation() {
        value = left.doOperation() / right.doOperation();
        return value;
    }
}
