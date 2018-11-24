package com.almasb.test;

import javafx.scene.control.Label;
import myExceptions.WrongTypeInColumnException;

public class ErrorControler {
    public Label message;

    ErrorControler(String errorText){
        message.setText(errorText);
    }
}
