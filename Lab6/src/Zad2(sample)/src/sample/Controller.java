package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.io.IOException;


public class Controller {
    @FXML
    private javafx.scene.control.TextField wsp, od, end, prob, butt;
    private int od_, end_, prob_;
    private String wsp_;
    private int k;

    public void draw2(ActionEvent actionEvent) throws IOException {
        if (isDigit(od.getText().toString())) {
            od_ = (Integer.parseInt(od.getText().toString()));
        }
        if (isDigit(end.getText().toString())) {
            end_ = (Integer.parseInt(end.getText().toString()));
        }
        if (isDigit(prob.getText().toString())) {
            prob_ = (Integer.parseInt(prob.getText().toString()));
        }

        wsp_ = wsp.getText().toString();
        wartości(wsp_);

        butt.setOnAction((ActionEvent e) -> {
            System.out.println("cl");
            wykres();

        });
    }

    public boolean isDigit(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }


    float Horner(int k, int tablica_wspolczynnikow[], float x) {
        int i;
        float wartosc = tablica_wspolczynnikow[0];
        for (i = 1; i < k + 1; i++)
            wartosc = wartosc * x + tablica_wspolczynnikow[i];
        return wartosc;
    }

    public int[] wartości(String tab) {
        int[] tablica = new int[10];

        int k = 0;

        for (int i = 0; i <= tab.length() - 2; i++) {
            if (tab.charAt(i) != ' ') {
                tablica[i] = Integer.parseInt(Character.toString(tab.charAt(i)));
                k++;
            }

        }
        return tablica;

    }

    public void wykres() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(
                xAxis, yAxis);

        lineChart.setTitle("Line Chart");
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("My Data");
        // populating the series with data

        for (int i = od_; i < end_; i = i + prob_) {
            series.getData().add(new XYChart.Data<Number, Number>(i, Horner(k, wartości(wsp_), i)));
        }
        Scene scene1 = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.show();

    }

}