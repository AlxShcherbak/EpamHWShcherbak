package com.ua.polishNotation.components;

import com.ua.polishNotation.components.enums.ComponentType;

/**
 * Created by AlxEx on 22.11.2015.
 * <p>
 * Абстрактный компонент, абстракция нат примитивами и композитами
 *
 * @author AlxEx
 * @version 0.1.0
 */
public abstract class AbstractComponent {
    /**
     * родительский компонент служит для высходящего перехода
     */
    protected AbstractComponent top;
    /**
     * значение у композитов высчитываеться у примитивов заается
     */
    protected double value;
    /**
     * тип компонента, примитив или композит
     */
    protected ComponentType componentType;
    /**
     * флаг заполноности у примитивов всегда true
     */
    protected boolean fullMarker = false;

    public AbstractComponent() {
    }

    public AbstractComponent(double value) {
        this.value = value;
    }

    /**
     * Добавить новый компонент, если примитив ничего не делает
     *
     * @param newComponent
     */
    public abstract void add(AbstractComponent newComponent);

    /**
     * выполнить мат. действие или вернуть значение
     *
     * @return
     */
    public abstract double doOperation();

    public AbstractComponent getTop() {
        return top;
    }

    public double getValue() {
        return value;
    }

    public void setTop(AbstractComponent top) {
        this.top = top;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    /**
     * определяет заполненость компонента
     *
     * @return
     */
    public boolean full() {
        return fullMarker;
    }
}
