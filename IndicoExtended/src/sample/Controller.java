package sample;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Map;
import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Controller {

    public void choosDir(final Stage stage){
        //directorychooser

        Desktop desktop = Desktop.getDesktop();

        stage.setTitle("Indico");

        final DirectoryChooser directoryChooser = new DirectoryChooser();
        final Button openButton = new Button("Wybierz folder");
        ObservableList<String> names = FXCollections
                .observableArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<String>(data);
        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        String _path="";
                        File file = directoryChooser.showDialog(stage);
                        if (file != null) {
                            _path = file.getPath();


                            LinkedList<String> photosChoice = new LinkedList<String>();
                            File directory = new File(_path);
                            if (!directory.exists()) {
                                try {
                                    throw new DirectoryNotExists();
                                } catch (DirectoryNotExists directoryNotExists) {
                                    directoryNotExists.printStackTrace();
                                }
                            } else {


                                File[] files = directory.listFiles();
                                List<File> photos = new LinkedList<File>();

                                for (File f : files) {
                                    if (f.isFile() && f.getAbsolutePath().matches(".*\\.jpg")) {
                                        photos.add(f);
                                    } else
                                        try {
                                            throw new NotAPhotoInsideDirectory();
                                        } catch (NotAPhotoInsideDirectory notAPhotoInsideDirectory) {
                                            notAPhotoInsideDirectory.printStackTrace();
                                        }
                                }
                                for (File f : photos) {
                                    photosChoice.add(f.getName());
                                    names.addAll(f.getName());
                                    data.addAll(f.getName());

                                    listView.setPrefSize(250, 250);
                                    listView.setEditable(true);
                                    listView.setItems(data);
                                    listView.getSelectionModel().selectedItemProperty().addListener(
                                            (ObservableValue<? extends String> ov, String old_val,
                                             String new_val) -> {
                                                System.out.println(new_val);
                                                try {
                                                    imgView(stage,f.getPath());
                                                } catch (FileNotFoundException e1) {
                                                    e1.printStackTrace();
                                                } catch (IOException e1) {
                                                    e1.printStackTrace();
                                                } catch (IndicoException e1) {
                                                    e1.printStackTrace();
                                                }

                                            });
                                }
                            }
                        }
                    }
                });
        //directorychooser






        //directorychooser
        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(openButton, 0, 0);
        GridPane.setConstraints(listView, 1, 1);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().add(openButton);
        inputGridPane.getChildren().add(listView);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();
        //directorychooser

    }
    public void imgView(Stage primaryStage,String path) throws IOException, IndicoException {

        double tmpValue = 0;
        String tmpName = "";
        PieChart pieChart = new PieChart();

        ObservableList<PieChart.Data> answer = FXCollections.observableArrayList();

        FileInputStream input = new FileInputStream(path);
        Image image = new Image(input);
        File f=new File(path);

        if(InetAddress.getLocalHost().isReachable(5)) {
            Indico indico = new Indico("63518acb5d3b0edd4db938ba2193f047");
            IndicoResult single = indico.imageRecognition.predict(f);
            Map<String, Double> result = single.getImageRecognition();
            LinkedList<PieChart> list=new LinkedList<>();


            Set<Map.Entry<String, Double>> entrySet = result.entrySet();
            for (Map.Entry<String, Double> entry : entrySet) {
//                System.out.println(entry.getKey());
//                System.out.println(entry.getValue());
                if (entry.getValue() > tmpValue) {
                    if(entry.getValue()>0.005) {
                        answer.add(new PieChart.Data(entry.getKey(), entry.getValue()));
                    }
                    tmpValue = entry.getValue();
                    tmpName = entry.getKey();
                }
            }
        }


        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(image);

        pieChart.setData(answer);

        HBox hbox = new HBox(imageView,pieChart);
        primaryStage.setTitle(tmpName);
        Scene scene = new Scene(hbox, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

