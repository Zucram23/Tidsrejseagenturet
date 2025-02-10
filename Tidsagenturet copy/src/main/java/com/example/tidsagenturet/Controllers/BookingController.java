package com.example.tidsagenturet.Controllers;
import com.example.tidsagenturet.Applications.TimeTravelApplication;
import com.example.tidsagenturet.Database.DatabaseConnection;
import com.example.tidsagenturet.Database.Repository;
import com.example.tidsagenturet.Extra_Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
public class BookingController {

    @FXML
    private ListView<TimePeriod> timePeriodListview;
    @FXML
    private ListView<TimeMachine> machineListView;
    @FXML
    private ListView<Guide> guideListView;

    @FXML
    private Label bookingLabel;

    @FXML
    private Label timePeriodLabel;
    @FXML
    private Label machineLabel;
    @FXML
    private Label guideLabel;

    @FXML
    private Button createBookingButton;

    @FXML
    private Button menuButton;

    @FXML
    private Label bookingDetailsLabel;

    private Stage stage;
    private Connection connection;

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    public void initialize() {
        // Initialize DB connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://tidsagenturet/");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fillListViews();

    }


    private void fillListViews(){

            timePeriodListview.getItems().clear();
            machineListView.getItems().clear();
            guideListView.getItems().clear();

            ArrayList<TimePeriod> timePeriods = new ArrayList<>();

            timePeriods.add(new TimePeriod(1, "Jesus' birth", "Here you can see the world jesus was born into."));
            timePeriods.add(new TimePeriod(2, "Future", "Here you can go 500 years into the future"));
            timePeriods.add(new TimePeriod(3, "Mongolian empire reign period", "Here you can see gengis khan committing epic things"));
            timePeriods.add(new TimePeriod(4, "Preset", "Here you can go to the preset"));

            timePeriodListview.getItems().setAll(timePeriods);

            ArrayList<Guide> guides = new ArrayList<>();

            guides.add(new Guide(1, "Caspar", "Region"));
            guides.add(new Guide(2, "Marcus", "Future"));
            guideListView.getItems().setAll(guides);

            try {
             ArrayList<TimeMachine> timeMachines = loadTimeMachinesFromDB();
               machineListView.getItems().setAll(timeMachines);
            } catch (SQLException e) {
               e.printStackTrace();
           }

        }

        private ArrayList<TimeMachine> loadTimeMachinesFromDB () throws SQLException {
            ArrayList<TimeMachine> machines = new ArrayList<>();
            String sql = "SELECT * FROM time_machines";

            try (Connection connection = DatabaseConnection.getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {


                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int capacity = resultSet.getInt("capacity");
                    String status = resultSet.getString("status");
                    machines.add(new TimeMachine(id, name, capacity, status));

                    System.out.println("Timemachine " + id + ": " + name + ", Capacity: " + capacity + ", Status: " + status);
                }
                return machines;
            }
        }
        @FXML
        public void createBooking () {
            TimeMachine selectedTimeMachine = machineListView.getSelectionModel().getSelectedItem();
            TimePeriod selectedTimePeriod = timePeriodListview.getSelectionModel().getSelectedItem();
            Guide selectedGuide = guideListView.getSelectionModel().getSelectedItem();

            if (selectedTimeMachine != null && selectedTimePeriod != null && selectedGuide != null) {


                if (selectedTimeMachine.getStatus().equals("Available")) {
                    Customer customer = new Customer(0, "Ole", "Ole@example.com");

                    Booking booking = new Booking(
                            0,
                            customer,
                            selectedTimeMachine,
                            selectedTimePeriod,
                            selectedGuide
                    );
                    String sql = "INSERT INTO bookings";

                    try (Connection connection = DatabaseConnection.getConnection();
                         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setInt(1, 0);
                        preparedStatement.setInt(2, customer.getId());
                        preparedStatement.setInt(3, selectedTimeMachine.getId());
                        preparedStatement.setInt(4, selectedTimePeriod.getId());

                        preparedStatement.setInt(5, selectedGuide.getId());

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            bookingDetailsLabel.setText("Booking created");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @FXML
        public void backToMenu () throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(TimeTravelApplication.class.getResource("timeTravel.fxml"));
            Parent root = fxmlLoader.load();

            TimeTravelController timeTravelController = fxmlLoader.getController();
            timeTravelController.setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }

