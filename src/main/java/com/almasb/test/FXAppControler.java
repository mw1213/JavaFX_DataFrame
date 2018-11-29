package com.almasb.test;

import dataframe.Column;
import dataframe.DataFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import myExceptions.WrongTypeInColumnException;
import value.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.XMLFormatter;

public class FXAppControler {

    public TextArea showColumns;
    public Button resetColumns;
    public Button resetGrupBy;
    public TextArea showGrupBy;
    public ChoiceBox choiseGrupBy;
    public Button setGrupBy;
    public Button addGrupBy;
    /**
     * dataFrame for other math operation and additional helpful variables connected to it
     */
    private String filePath;
    public DataFrame dataFrame;
    private int DataFrame_width;
    private Class<? extends Value>[] types;
    private String[] names;
    private Column X_axis;
    private Column Y_axis;
    private List<String> grupByList;
    private String[] grupByColumnForm;

    /**
     * ObservableLists for choisBoxes: one is for addin types to dataframe, one for colNames for charts
     */
    private ObservableList<String> allTypesList = FXCollections.observableArrayList(
            "DateTimeValue", "DoubleValue", "FloatValue","IntegerValue","StringValue");

    private ObservableList<String> colNames = FXCollections.observableArrayList();

    public Button load;
    public Button min;
    public Button max;
    public Button sum;
    public Button var;
    public Button std;
    public Button mean;

    public ChoiceBox col1;
    public ChoiceBox col2;
    public Button draw;

    public ChoiceBox choise;
    public Button add;
    public Button create;
    public Label created;
    public TextField width;
    public Button set_width;
    public Button set_x;
    public Button set_y;

    public void handleFileLoadAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();

        filePath = fileChooser.showOpenDialog(stage).getAbsolutePath();
        choise.disableProperty().setValue(false);
        add.disableProperty().setValue(false);
        width.disableProperty().setValue(false);
        set_width.disableProperty().setValue(false);
        choise.setItems(allTypesList);

    }

    public void handleCreateDataFrame(javafx.event.ActionEvent actionEvent){

        try {
            dataFrame = new DataFrame(filePath, types, true, 100);


            names=dataFrame.getColumnsNames();
            for (int i=0; i<names.length;i++){
                colNames.add(names[i]);
            }
            col1.setItems(colNames);
            col2.setItems(colNames);
            choiseGrupBy.setItems(colNames);
        } catch (IOException e1) {
            FXMLLoader loader = new FXMLLoader(MathoperationControler.class.getClassLoader().getResource("error.fxml"));
            ErrorControler controler = new ErrorControler();
            loader.setController(controler);
            Stage stage1= new Stage();

            Parent root = null;
            try {
                root = loader.load();
                controler.setMessage("You added wrong classes man!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.setTitle("ERROR");
            stage1.show();
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
        created.setVisible(true);
        choise.disableProperty().setValue(true);
        create.disableProperty().setValue(true);
        add.disableProperty().setValue(true);
        width.disableProperty().setValue(true);
        set_width.disableProperty().setValue(true);
        choiseGrupBy.disableProperty().setValue(false);
        addGrupBy.disableProperty().setValue(false);
        resetColumns.disableProperty().setValue(true);

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
            controler.setText(grupByColumnForm);
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
            controler.setText(grupByColumnForm);
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
            controler.setText(grupByColumnForm);
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
            controler.setText(grupByColumnForm);
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
            controler.setText(grupByColumnForm);
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
            controler.setText(grupByColumnForm);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Mean");
        stage1.show();
    }

    public void addColumnType(ActionEvent actionEvent) {
        resetColumns.disableProperty().setValue(false);
        for (int i=0;i<DataFrame_width;i++){
            if(types[i]==null) {
                if (choise.getValue()=="DateTimeValue"){
                    types[i]=DateTimeValue.class;
                    showColumns.setText(showColumns.getText()+" "+ types[i]);
                }
                if (choise.getValue()=="DoubleValue"){
                    types[i]= DoubleValue.class;
                    showColumns.setText(showColumns.getText()+" "+ types[i]);
                }
                if (choise.getValue()=="FloatValue") {
                    types[i]=FloatValue.class;
                    showColumns.setText(showColumns.getText()+" "+ types[i]);
                }
                if (choise.getValue()=="IntegerValue"){
                    types[i]=IntegerValue.class;
                    showColumns.setText(showColumns.getText()+" "+ types[i]);
                }
                if (choise.getValue()=="StringValue") {
                    types[i]=StringValue.class;
                    showColumns.setText(showColumns.getText()+" "+ types[i]);
                }
                break;
            }

        }
        if (types[DataFrame_width-1]!=null){
            create.disableProperty().setValue(false);
        }
    }
    public void setDataFrameWidth(ActionEvent actionEvent) {
        DataFrame_width = Integer.parseInt(width.getText());
        types = new Class[DataFrame_width];
        names = new String[DataFrame_width];
        grupByList = new ArrayList<>();
    }

    public void addToGrupBy(ActionEvent actionEvent) {
        setGrupBy.disableProperty().setValue(false);
        resetGrupBy.disableProperty().setValue(false);
        grupByList.add(choiseGrupBy.getValue().toString());
        showGrupBy.setText(showGrupBy.getText() +" " + choiseGrupBy.getValue().toString());
    }


    public void setGrupBy(ActionEvent actionEvent) {
        grupByColumnForm = new String[grupByList.size()];
        for (int i=0; i<grupByList.size();i++){
            grupByColumnForm[i]=grupByList.get(i);
        }
        min.disableProperty().setValue(false);
        max.disableProperty().setValue(false);
        sum.disableProperty().setValue(false);
        var.disableProperty().setValue(false);
        std.disableProperty().setValue(false);
        mean.disableProperty().setValue(false);
        load.disableProperty().setValue(true);
        col1.disableProperty().setValue(false);
        col2.disableProperty().setValue(false);
        draw.disableProperty().setValue(false);
        set_x.disableProperty().setValue(false);
        set_y.disableProperty().setValue(false);

    }

    public void resetGrupBy(ActionEvent actionEvent) {
        setGrupBy.disableProperty().setValue(true);
        grupByList.clear();
        showGrupBy.setText("");
    }

    public void resetColumns(ActionEvent actionEvent) {
        create.disableProperty().setValue(true);
        for (int i = 0; i<DataFrame_width; i++){
            types[i]=null;
        }

        showColumns.setText("");
    }


    public void set_x(ActionEvent actionEvent) {
        X_axis = dataFrame.get(col2.getSelectionModel().getSelectedItem().toString());
    }

    public void set_y(ActionEvent actionEvent) {
        Y_axis = dataFrame.get(col1.getSelectionModel().getSelectedItem().toString());
    }

    public void draw(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(ChartControler.class.getClassLoader().getResource("chart.fxml"));
        ChartControler controler = new ChartControler();
        controler.setDataFrame(dataFrame);
        controler.set_x(X_axis);
        controler.set_y(Y_axis);
        loader.setController(controler);
        Stage stage1= new Stage();
        Parent root = null;
        try {
            root = loader.load();
            controler.setChart();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setTitle("Chart");
        stage1.show();
    }


}
