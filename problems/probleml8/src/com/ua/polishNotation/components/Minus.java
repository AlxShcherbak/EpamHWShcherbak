package com.ua.polishNotation.components;

import com.ua.polishNotation.components.enums.OperationType;

/**
 * Created by AlxEx on 22.11.2015.
 * <p>
 * Операция отнимания
 *
 * @author AlxEx
 * @see com.ua.polishNotation.components.AbstractComponent
 */
public class Minus extends AbstractOperation {

    public Minus() {
        operationType = OperationType.MINUS;
    }

    @Override
    public double doOperation() {
        value = left.doOperation() - right.doOperation();
        return value;
    }
}
