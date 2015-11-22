package com.ua.polishNotation.components;

import com.ua.polishNotation.components.enums.ComponentType;

/**
 * Created by AlxEx on 22.11.2015.
 * <p>
 * Примитив число
 *
 * @author AlxEx
 * @see com.ua.polishNotation.components.AbstractComponent
 */
public class Number extends AbstractNumber {
    public Number(double value) {
        super(value);
        componentType = ComponentType.PRIMITIVE;
    }

    @Override
    public void add(AbstractComponent newComponent) {
        return;
    }

    @Override
    public double doOperation() {
        return value;
    }
}
