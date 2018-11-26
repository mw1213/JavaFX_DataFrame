package com.almasb.test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import myExceptions.WrongTypeInColumnException;

public class ErrorControler {
    @FXML
    public Label message;

    public void setMessage(String message) {
        this.message.setText(message);
    }
}
