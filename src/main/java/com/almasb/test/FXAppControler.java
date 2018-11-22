package com.almasb.test;

import dataframe.DataFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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

import java.awt.*;
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
    public DataFrame dataFrame = null;

    public void handleFileLoadAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        try {
            dataFrame = new DataFrame(file.getAbsolutePath(),new Class[]{StringValue.class, DateTimeValue.class, FloatValue.class, FloatValue.class}, true);
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
            Stage stage1 = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("error.fxml"));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            stage1.setScene(new Scene(root));
            stage1.setTitle("ERROR");
            stage1.show();
        }
    }

    public void min(ActionEvent actionEvent) {
        try {
            Stage stage1 = new Stage();
            Locale.setDefault(Locale.ENGLISH);
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("mathoperation.fxml"));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Scene scene =new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("Minimal values in DataFrame");
            stage1.show();
            System.out.println(dataFrame.grupby(new String[]{"id"}).min());
        } catch (WrongTypeInColumnException e) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("error.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.setScene(new Scene(root));
            stage.setTitle("ERROR");
            stage.show();
        }
    }

    public void max(ActionEvent actionEvent) {
        try {
            Stage stage1 = new Stage();
            Locale.setDefault(Locale.ENGLISH);
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("mathoperation.fxml"));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Scene scene =new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("Max values in DataFrame");
            stage1.show();
            System.out.println(dataFrame.grupby(new String[]{"id"}).max());
        } catch (WrongTypeInColumnException e) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("error.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.setScene(new Scene(root));
            stage.setTitle("ERROR");
            stage.show();
        }
    }

    public void sum(ActionEvent actionEvent) {
        try {
            Stage stage1 = new Stage();
            Locale.setDefault(Locale.ENGLISH);
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("mathoperation.fxml"));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Scene scene =new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("Sum values in DataFrame");
            stage1.show();
            System.out.println(dataFrame.grupby(new String[]{"id"}).sum());
        } catch (WrongTypeInColumnException e) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("error.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.setScene(new Scene(root));
            stage.setTitle("ERROR");
            stage.show();
        }
    }

    public void var(ActionEvent actionEvent) {
        try {
            Stage stage1 = new Stage();
            Locale.setDefault(Locale.ENGLISH);
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("mathoperation.fxml"));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Scene scene =new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("Variance values in DataFrame");
            stage1.show();
            System.out.println(dataFrame.grupby(new String[]{"id"}).var());
        } catch (WrongTypeInColumnException e) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("error.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.setScene(new Scene(root));
            stage.setTitle("ERROR");
            stage.show();
        }
    }

    public void std(ActionEvent actionEvent) {
        try {
            Stage stage1 = new Stage();
            Locale.setDefault(Locale.ENGLISH);
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("mathoperation.fxml"));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Scene scene =new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("Standard deviation values in DataFrame");
            stage1.show();
            System.out.println(dataFrame.grupby(new String[]{"id"}).std());
        } catch (WrongTypeInColumnException e) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("error.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.setScene(new Scene(root));
            stage.setTitle("ERROR");
            stage.show();
        }
    }

    public void mean(ActionEvent actionEvent) {
        try {
            Stage stage1 = new Stage();
            Locale.setDefault(Locale.ENGLISH);
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("mathoperation.fxml"));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Scene scene =new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("Mean values in DataFrame");
            stage1.show();
            System.out.println(dataFrame.grupby(new String[]{"id"}).mean());
        } catch (WrongTypeInColumnException e) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("error.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stage.setScene(new Scene(root));
            stage.setTitle("ERROR");
            stage.show();
        }
    }
}
