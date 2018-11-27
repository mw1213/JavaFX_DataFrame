package com.almasb.test;

import dataframe.Column;
import dataframe.DataFrame;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ChartControler {
    private DataFrame dataFrame;
    private Column x_axis;
    private Column y_axis;

    @FXML
    public BorderPane borderPane;

    public void setDataFrame(DataFrame dataFrame) {
        this.dataFrame = dataFrame;
    }

    public void set_x(Column column) {
        x_axis=column;
    }

    public void set_y(Column column) {
        y_axis=column;
    }

    public void setChart(){
        final CategoryAxis xAxis = new CategoryAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final LineChart<String, String> chart = new LineChart(xAxis,yAxis);

        chart.setTitle("Char of " + x_axis.getName() + " and " + y_axis.getName());
        XYChart.Series series = new XYChart.Series();
        series.setName("DataFrame");

        for (int i = 0; i < x_axis.size(); i++) {
            series.getData().add(new XYChart.Data<>(x_axis.elAtIndex(i).toString(), y_axis.elAtIndex(i).toString()));
        }
        chart.getData().add(series);

        borderPane.setCenter(chart);
    }

}
