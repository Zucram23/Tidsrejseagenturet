package com.example.tidsagenturet.Controllers;
import com.example.tidsagenturet.Applications.TimeTravelApplication;
import com.example.tidsagenturet.Database.DatabaseConnection;
import com.example.tidsagenturet.Database.Repository;
import com.example.tidsagenturet.Extra_Classes.*;
import com.example.tidsagenturet.Database.Repository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class TimePeriodsController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}