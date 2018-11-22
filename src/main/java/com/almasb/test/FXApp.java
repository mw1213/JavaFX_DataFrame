package com.almasb.test;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

public class FXApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        Parent root = FXMLLoader.load(FXApp.class.getClassLoader().getResource("startmenu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("DataFrame");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);


    }


}
