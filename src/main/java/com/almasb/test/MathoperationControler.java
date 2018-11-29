package com.almasb.test;

import dataframe.DataFrame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import myExceptions.WrongTypeInColumnException;

public class MathoperationControler {
    
    public DataFrame dataFrame;
    public String name;
    @FXML
    public Label message;
    @FXML
    public Label operation;

    public void setDataFrame(DataFrame dataFrame) {
        this.dataFrame = dataFrame;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setText(String... columns){
        operation.setText("DataFrame "+ name);
        String text=new String("Numbers");
        try {
            if(name.equals("Min")){
                text = dataFrame.grupby(columns).min().toString();
            }
            else if (name.equals("Max")){
                text = dataFrame.grupby(columns).max().toString();
            }
            else if(name.equals("Sum")){
                text = dataFrame.grupby(columns).sum().toString();
            }
            else if (name.equals("Std")){
                text = dataFrame.grupby(columns).std().toString();
            }
            else if(name.equals("Mean")){
                text = dataFrame.grupby(columns).mean().toString();
            }
            else if (name.equals("Var")){
                text = dataFrame.grupby(columns).var().toString();
            }

        } catch (WrongTypeInColumnException e) {
            e.printStackTrace();
        };
        message.setText(text);
    }
}
