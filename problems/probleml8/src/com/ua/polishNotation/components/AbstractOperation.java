package com.ua.polishNotation.components;

import com.ua.polishNotation.components.enums.ComponentType;
import com.ua.polishNotation.components.enums.OperationType;

/**
 * Created by AlxEx on 22.11.2015.
 * <p>
 * Первый уровень абстракции композитов мат. действий (отнимания, суммы, деления, умножения)
 *
 * @author AlxEx
 * @version 0.1.0
 * @see com.ua.polishNotation.components.AbstractComponent
 */
public abstract class AbstractOperation extends AbstractComponent {
    /**
     * левый потомок (ветвь дерева)
     */
    protected AbstractComponent left;
    /**
     * правый потомок
     */
    protected AbstractComponent right;
    /**
     * тип операции
     *
     * @see com.ua.polishNotation.components.enums.OperationType
     */
    protected OperationType operationType;

    @Override
    public void add(AbstractComponent newComponent) {
        newComponent.setTop(this);
        AbstractOperation leftComposite = null,
                rightComposite = null;
        if (this.full()) {
            return;
        }
        if (this.right == null) {           // правый свободный
            this.right = newComponent;
            return;
        } else if (!this.right.full()) {    // правый не заполнен
            this.right.add(newComponent);
        } else if (this.left == null) {     // левый свободный
            this.left = newComponent;
            return;
        } else if (!this.left.full()) {     // левый не заполнен
            this.left.add(newComponent);
        }
    }


    public AbstractOperation() {
        componentType = ComponentType.COMPOSITE;
    }

    public void setRight(AbstractComponent right) {
        this.right = right;
    }

    public void setLeft(AbstractComponent left) {
        this.left = left;
    }

    @Override
    public boolean full() {
        this.fullMarker = this.left != null && this.right != null && this.right.full() && this.left.full();
        return this.fullMarker;
    }
}
