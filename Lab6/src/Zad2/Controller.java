package Zad2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class Controller {
    private int od_, end_, prob_;
    private String wsp_;
    private int k;
    private int tablica_wspolczynnikow[];

    public void input(Stage stage) {
        String wspołczynniki = "";
        String zakres = "";
        String prob = "";
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 150, Color.WHITE);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        ColumnConstraints column1 = new ColumnConstraints(200);
        ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
        column2.setHgrow(Priority.ALWAYS);
        gridpane.getColumnConstraints().addAll(column1, column2);

        Label fNameLbl = new Label("Podaj wartości wspólczynników");
        TextField fNameFld = new TextField();
        Label ZakresLbl = new Label("Podaj zakres");
        TextField ZakresFld = new TextField();
        Label ProbLbl = new Label("Podaj próbkowanie");
        TextField ProbLFld = new TextField();


        Button saveButt = new Button("Rysuj wykres");

        // wielomian label
        GridPane.setHalignment(fNameLbl, HPos.RIGHT);
        gridpane.add(fNameLbl, 0, 0);

        // zakres label
        GridPane.setHalignment(ZakresLbl, HPos.RIGHT);
        gridpane.add(ZakresLbl, 0, 1);

        // probkowanie label
        GridPane.setHalignment(ProbLbl, HPos.RIGHT);
        gridpane.add(ProbLbl, 0, 2);

        // wielomian field
        GridPane.setHalignment(fNameFld, HPos.LEFT);
        gridpane.add(fNameFld, 1, 0);


        // zakres field
        GridPane.setHalignment(ZakresFld, HPos.LEFT);
        gridpane.add(ZakresFld, 1, 1);

        // probkowanie field
        GridPane.setHalignment(ProbLFld, HPos.LEFT);
        gridpane.add(ProbLFld, 1, 2);

        // Save button
        GridPane.setHalignment(saveButt, HPos.RIGHT);
        gridpane.add(saveButt, 1, 3);
        saveButt.setOnAction((ActionEvent e) -> {

            if (isDigit(ZakresFld.getText().toString())) {
                od_ = (Integer.parseInt(ZakresFld.getText().toString()));
            }
            if (isDigit(ZakresFld.getText().toString())) {
                end_ = (Integer.parseInt(ZakresFld.getText().toString()));
            }
            if (isDigit(ProbLFld.getText().toString())) {
                prob_ = (Integer.parseInt(ProbLFld.getText().toString()));
            }
            wsp_ = fNameFld.getText().toString();
            wykres();


        });
        root.setCenter(gridpane);
        stage.setScene(scene);

        stage.show();
    }

    public boolean isDigit(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }


    public void wykres() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(
                xAxis, yAxis);

        lineChart.setTitle("Wykres");
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("Dane");
        // populating the series with data

        for (int i = od_; i < od_ + 10; i = i + prob_) {
            series.getData().add(new XYChart.Data<Number, Number>(i, Horner(k,wsp_, i)));
        }
        Scene scene1 = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.show();


    }


    float Horner(int m, String tab, float x) {
        int[] tablica = new int[tab.length()];

        int k = 0;
        int toAdd;

        for (int i = 0; i < tab.length(); i++) {
            if (tab.charAt(i) > 47 & tab.charAt(i) < 58) {
                toAdd = Integer.parseInt(Character.toString(tab.charAt(i)));
                tablica[k] = toAdd;
                k++;
                //System.out.println(tablica[k] + "_" + i);
            }
            if (Character.toString(tab.charAt(i)).equals(" ")) {
                // System.out.println("-");
            }
        }

        int i;
       float wartosc = tablica[0];
        //System.out.println(wartosc);

        for (i = 1; i <= k  ; i++){
            System.out.println(tablica[i]);
            wartosc = wartosc * (x) + tablica[i];
            // System.out.println(wartosc);
            // System.out.println(tablica_wspolczynnikow[i]);
        }
        return wartosc;
    }
//
//    public int [] wartości(String tab) {
//        int[] tablica = new int[tab.length()];
//
//        int k = 0;
//        int toAdd;
//
//        for (int i = 0; i < tab.length(); i++) {
//            if (tab.charAt(i) > 47 & tab.charAt(i) < 58) {
//                toAdd = Integer.parseInt(Character.toString(tab.charAt(i)));
//                tablica[k] = toAdd;
//                k++;
//                //System.out.println(tablica[k] + "_" + i);
//            }
//            if (Character.toString(tab.charAt(i)).equals(" ")) {
//               // System.out.println("-");
//            }
//        }



//        int[] tablicaOK = new int[k];
//        for (int j = 0; j < k; k++) {
//            tablicaOK[j] = tablica[j];
//            System.out.println(tablicaOK[j]);
//        }
        //System.out.println(tablica);

        //  System.out.println(tablica[2]);
//        System.out.println(tablica[3]);
        //   System.out.println(tablica[4]);
//       return tablica;
//
//    }
}