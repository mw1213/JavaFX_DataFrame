package com.almasb.test;

import dataframe.DataFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import myExceptions.WrongTypeInColumnException;
import value.DateTimeValue;
import value.FloatValue;
import value.StringValue;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class FXAppControler {


    public Button load;
    public Button min;
    public Button max;
    public Button sum;
    public Button var;
    public Button std;
    public Button mean;
    public DataFrame dataFrame;

    public void handleFileLoadAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        String filePath = fileChooser.showOpenDialog(stage).getAbsolutePath();
        try {
            dataFrame = new DataFrame(filePath,new Class[]{StringValue.class, DateTimeValue.class, FloatValue.class, FloatValue.class}, true);
            min.disableProperty().setValue(false);
            max.disableProperty().setValue(false);
            sum.disableProperty().setValue(false);
            var.disableProperty().setValue(false);
            std.disableProperty().setValue(false);
            mean.disableProperty().setValue(false);
            load.disableProperty().setValue(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (WrongTypeInColumnException e1) {
            FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("error.fxml"));
            ErrorControler controler = new ErrorControler();
            loader.setController(controler);
            Stage stage1= new Stage();

            Parent root = null;
            try {
                root = loader.load();
                controler.setMessage(e1.getStringMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("ERROR");
            stage1.show();
        }
    }

    public void min(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("mathoperation.fxml"));
        MathoperationControler controler = new MathoperationControler();
        controler.setDataFrame(dataFrame);
        controler.setName(new String("Min"));
        loader.setController(controler);
        Stage stage1= new Stage();

        Parent root = null;
        try {
            root = loader.load();
            controler.setText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Minimum");
        stage1.show();

    }

    public void max(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("mathoperation.fxml"));
        MathoperationControler controler = new MathoperationControler();
        controler.setDataFrame(dataFrame);
        controler.setName(new String("Max"));
        loader.setController(controler);
        Stage stage1= new Stage();

        Parent root = null;
        try {
            root = loader.load();
            controler.setText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Maximum");
        stage1.show();    }

    public void sum(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("mathoperation.fxml"));
        MathoperationControler controler = new MathoperationControler();
        controler.setDataFrame(dataFrame);
        controler.setName(new String("Sum"));
        loader.setController(controler);
        Stage stage1= new Stage();

        Parent root = null;
        try {
            root = loader.load();
            controler.setText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Sum");
        stage1.show();

    }

    public void var(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("mathoperation.fxml"));
        MathoperationControler controler = new MathoperationControler();
        controler.setDataFrame(dataFrame);
        controler.setName(new String("Var"));
        loader.setController(controler);
        Stage stage1= new Stage();

        Parent root = null;
        try {
            root = loader.load();
            controler.setText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Variance");
        stage1.show();
    }

    public void std(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("mathoperation.fxml"));
        MathoperationControler controler = new MathoperationControler();
        controler.setDataFrame(dataFrame);
        controler.setName(new String("Std"));
        loader.setController(controler);
        Stage stage1 = new Stage();

        Parent root = null;
        try {
            root = loader.load();
            controler.setText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Standard deviation");
        stage1.show();
    }

    public void mean(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("mathoperation.fxml"));
        MathoperationControler controler = new MathoperationControler();
        controler.setDataFrame(dataFrame);
        controler.setName(new String("Mean"));
        loader.setController(controler);
        Stage stage1= new Stage();

        Parent root = null;
        try {
            root = loader.load();
            controler.setText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Mean");
        stage1.show();
    }
}
