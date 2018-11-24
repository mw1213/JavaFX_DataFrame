package com.almasb.test;

import dataframe.DataFrame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import myExceptions.WrongTypeInColumnException;

public class MathoperationControler {

    public Label operation= new Label();
    public Label message = new Label();
    public DataFrame dataFrame;
    public String name;

    public void setDataFrame(DataFrame dataFrame) {
        this.dataFrame = dataFrame;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setText(){
        operation.setText("DataFrame "+ name);
        String text=new String("Numbers");
        try {
            text = dataFrame.grupby(new String[]{"id"}).min().toString();
        } catch (WrongTypeInColumnException e) {
            e.printStackTrace();
        };
        message.setText(text);
    }
}
