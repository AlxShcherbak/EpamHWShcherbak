package com.ua.polishNotation.components;

/**
 * Created by AlxEx on 22.11.2015.
 * <p>
 * Уровень абстракции примитивов (чисел)
 *
 * @author AlxEx
 * @see com.ua.polishNotation.components.AbstractComponent
 */
public abstract class AbstractNumber extends AbstractComponent {
    public AbstractNumber() {
        this.fullMarker = true;
    }

    public AbstractNumber(double value) {
        super(value);
        this.fullMarker = true;
    }
}
