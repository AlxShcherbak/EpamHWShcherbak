package com.ua.polishNotation.operators;

import com.ua.polishNotation.components.AbstractComponent;
import com.ua.polishNotation.components.factory.ComponentFactory;

/**
 * Created by AlxEx on 22.11.2015.
 * Класс роботы с математической строкой и нахождение решения по математическим правилам
 * решение производится через обратную польскую нотацию
 *
 * @author AlxEx
 * @see com.ua.polishNotation.components
 */
public class PolishParser {
    /**
     * Нахождение значения введеного выражения
     *
     * @param inputString - выражение
     * @return
     */
    public static double calculate(String inputString) {
        String str = compositePolishNotation(inputString);  // Привидение входной строки в Обратную польскую строку (нотацию)
        AbstractComponent abs = compositeTree(str); // привидение польской строки в дерево компонентов (дерево правонаправленое)
        double f = abs.doOperation();   // нахождение решения через дерево компонентов
        return f;
    }

    /**
     * Привидение входной строки в польскую нотацию
     *
     * @param inputString --> input = "8+2*5/4*(1-6+-9/15-(2+6)"
     * @return - строка в виде обратной польской нотации    ->> return = ",8,2,5,*,4,/,1,6,-,9,15,/,2,6,+,+,-,*,+,,"
     */
    private static String compositePolishNotation(String inputString) {
        StringBuilder stack = new StringBuilder(),
                exit = new StringBuilder(",");
        char lastStack = 'n',
                lastInput = 'n';
        boolean inv = false;
        for (char ch : inputString.toCharArray()) {
            if (isNumber(ch)) {
                exit.append(ch);
            } else {
                if (exit.length() > 0 && isNumber(lastInput)) {
                    exit.append(',');
                }
                switch (ch) {
                    case '+': {
                        if (lastStack == '+' || lastStack == '-' || lastStack == '*' || lastStack == '/') {
                            exit.append(lastStack);
                            exit.append(',');
                            stack.deleteCharAt(stack.length() - 1);
                        }
                        stack.append(ch);
                        break;
                    }
                    case '-': {
                        // "--" & "+-" situation
                        if (lastInput == '-') {
                            stack.deleteCharAt(stack.length() - 1);
                            stack.append('+');
                            break;
                        } else if (lastInput == '+') {
                            stack.deleteCharAt(stack.length() - 1);
                            stack.append('-');
                            break;
                        }

                        if (lastStack == '+' || lastStack == '-' || lastStack == '*' || lastStack == '/') {
                            exit.append(lastStack);
                            exit.append(',');
                            stack.deleteCharAt(stack.length() - 1);
                        }
                        stack.append(ch);
                        break;
                    }
                    case '*': {
                        if (lastStack == '*' || lastStack == '/') {
                            exit.append(lastStack);
                            exit.append(',');
                            stack.deleteCharAt(stack.length() - 1);
                        }
                        stack.append(ch);
                        break;
                    }
                    case '/': {
                        if (lastStack == '*' || lastStack == '/') {
                            exit.append(lastStack);
                            exit.append(',');
                            stack.deleteCharAt(stack.length() - 1);
                        }
                        stack.append(ch);
                        break;
                    }
                    case '(': {
                        stack.append(ch);
                        break;
                    }

                    case ')': {
                        while (lastStack != '(') {
                            if (inv && lastStack == '-')
                                exit.setCharAt(exit.length() - 2, '+');
                            exit.append(lastStack);
                            exit.append(',');
                            stack.deleteCharAt(stack.length() - 1);
                            inv = lastStack == '-';
                            lastStack = stack.charAt(stack.length() - 1);
                        }
                        stack.deleteCharAt(stack.length() - 1);
                        break;
                    }
                }
                lastStack = stack.charAt(stack.length() - 1);
            }
            lastInput = ch;
        }
        lastStack = 'n';
        lastInput = 'n';
        for (int i = stack.length() - 1; i >= 0; i--) {
            if (inv && stack.charAt(i) == '-') {
                lastStack = '+';
            } else lastStack = stack.charAt(i);
            exit.append(lastStack);
            exit.append(',');
            inv = lastStack == '-';
        }
        exit.append(',');
        return exit.toString();
    }

    /**
     * Перевод строки в виде обратной польской нотации в правостороние дерево
     * @param inputValue
     * @return - дерево компонентов
     */
    private static AbstractComponent compositeTree(String inputValue) {
        AbstractComponent retValue = null;
        StringBuilder strBuff = new StringBuilder();
        boolean operation = false;

        for (int i = inputValue.length() - 1; i >= 0; i--) {
            char ch = inputValue.charAt(i);
            if (ch == ',' && strBuff.length() > 0) {
                if (retValue == null) {
                    if (operation) {
                        retValue = ComponentFactory.getComponent(strBuff.toString());
                    } else {
                        strBuff.reverse();
                        retValue = ComponentFactory.getComponent(Double.parseDouble(strBuff.toString()));
                    }
                } else {
                    if (operation) {
                        retValue.add(ComponentFactory.getComponent(strBuff.toString()));
                    } else {
                        strBuff.reverse();
                        retValue.add(ComponentFactory.getComponent(Double.parseDouble(strBuff.toString())));
                    }
                }
                strBuff.setLength(0);
                operation = false;
            } else if (isNumber(ch)) {
                operation = false;
                strBuff.append(ch);
                continue;
            } else if (ch != ',') {
                operation = true;
                strBuff.append(ch);
                continue;
            }
        }
        return retValue;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
