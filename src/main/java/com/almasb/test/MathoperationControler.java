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

    public void setText(){
        operation.setText("DataFrame "+ name);
        String text=new String("Numbers");
        try {
            if(name.equals("Min")){
                text = dataFrame.grupby(new String[]{"id"}).min().toString();
            }
            else if (name.equals("Max")){
                text = dataFrame.grupby(new String[]{"id"}).max().toString();
            }
            else if(name.equals("Sum")){
                text = dataFrame.grupby(new String[]{"id"}).sum().toString();
            }
            else if (name.equals("Std")){
                text = dataFrame.grupby(new String[]{"id"}).std().toString();
            }
            else if(name.equals("Mean")){
                text = dataFrame.grupby(new String[]{"id"}).mean().toString();
            }
            else if (name.equals("Var")){
                text = dataFrame.grupby(new String[]{"id"}).var().toString();
            }

        } catch (WrongTypeInColumnException e) {
            e.printStackTrace();
        };
        message.setText(text);
    }
}
