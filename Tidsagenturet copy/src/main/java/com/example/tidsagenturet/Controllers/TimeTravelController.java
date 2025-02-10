package com.example.tidsagenturet.Controllers;
import com.example.tidsagenturet.Extra_Classes.*;
import com.example.tidsagenturet.Database.*;
import com.example.tidsagenturet.Applications.TimeTravelApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
public class TimeTravelController {



    @FXML
    private Button BookingButton;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @FXML
    public void customerAdminButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TimeTravelApplication.class.getResource("/com/example/tidsagenturet/customerAdmin.fxml"));
        Parent root = fxmlLoader.load();

        CustomerAdminController customerAdminController = fxmlLoader.getController();
        customerAdminController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void timeTravelMachinesButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TimeTravelApplication.class.getResource("timeTravelMachines.fxml"));
        Parent root = fxmlLoader.load();

        TimeMachinesController timeMachinesController = fxmlLoader.getController();
        timeMachinesController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void timePeriodsButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TimeTravelApplication.class.getResource("timePeriods.fxml"));
        Parent root = fxmlLoader.load();

        TimePeriodsController timePeriodsController = fxmlLoader.getController();
        timePeriodsController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

     @FXML
    public void BookingButton() throws IOException {
     FXMLLoader fxmlLoader = new FXMLLoader(TimeTravelApplication.class.getResource("/com/example/tidsagenturet/Booking.fxml"));
     Parent root = fxmlLoader.load();


        BookingController bookingController = fxmlLoader.getController();
        bookingController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

