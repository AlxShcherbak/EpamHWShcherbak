package com.ua.polishNotation.components;

import com.ua.polishNotation.components.enums.OperationType;

/**
 * Created by AlxEx on 22.11.2015.
 * <p>
 * Операция умножения
 *
 * @author AlxEx
 * @see com.ua.polishNotation.components.AbstractComponent
 */
public class Multiplication extends AbstractOperation {
    public Multiplication() {
        operationType = OperationType.MULTIPLICATION;
    }

    @Override
    public double doOperation() {
        value = left.doOperation() * right.doOperation();
        return value;
    }
}
