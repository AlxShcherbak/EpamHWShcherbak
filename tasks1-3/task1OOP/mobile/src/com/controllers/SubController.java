package com.controllers;


import com.classes.ValueInBound;
import javafx.scene.control.TextField;

/**
 * Created by Alx Shcherbak on 28.10.2015.
 */
public class SubController {
    /**
     * transformed textField.getText to Double if textField==null returned 0d
     *
     * @param textField - input textfield
     * @return - Double value of textField, if textField==null returned 0d
     */
    public Double textFieldToDouble(TextField textField) {
        try {
            return Double.parseDouble(textField.getText().toString());
        } catch (NumberFormatException e) {
        }
        return 0d;
    }

    /**
     * transformed textField.getText to Double if textField==null returned null
     *
     * @param textField - input textfield
     * @return - Double value of textField, if textField==null returned null
     */
    public Double textFieldToDoubleWithNull(TextField textField) {
        try {
            return Double.parseDouble(textField.getText().toString());
        } catch (NumberFormatException e) {
        }
        return null;
    }

    /**
     * @param downTF - down bound
     * @param upTF   - up bound
     * @return true or false
     * @throws NullPointerException;
     */
    public ValueInBound valueInBoundGen(TextField downTF, TextField upTF) {
        Double up = null, down = null;
        down = textFieldToDoubleWithNull(downTF);
        up = textFieldToDoubleWithNull(upTF);
        return new ValueInBound(down, up);
    }
}
