package com.example.tidsagenturet.Applications;

import com.example.tidsagenturet.Controllers.TimeTravelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TimeTravelApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(TimeTravelApplication.class.getResource("/com/example/tidsagenturet/timeTravel.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        TimeTravelController timeTravelController = fxmlLoader.getController();
        timeTravelController.setStage(stage);



        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}