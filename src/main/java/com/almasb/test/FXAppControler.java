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
        System.out.println(MathoperationControler.class.getClassLoader().getResource("mathoperation.fxml").toString());
        FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("mathoperation.fxml"));
        MathoperationControler controler = new MathoperationControler();
        controler.setDataFrame(dataFrame);
        controler.setName(new String("Min"));
        controler.setText();
        loader.setController(controler);
        Stage stage1= new Stage();
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage1.setScene(scene);
        stage1.setTitle("Minimum");
        stage1.show();

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
