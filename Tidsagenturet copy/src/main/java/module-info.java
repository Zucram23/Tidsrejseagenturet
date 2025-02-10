module com.example.tidsagenturet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.tidsagenturet to javafx.fxml;
    exports com.example.tidsagenturet.Database;
    opens com.example.tidsagenturet.Database to javafx.fxml;
    exports com.example.tidsagenturet.Extra_Classes;
    opens com.example.tidsagenturet.Extra_Classes to javafx.fxml;
    exports com.example.tidsagenturet.Controllers;
    opens com.example.tidsagenturet.Controllers to javafx.fxml;
    exports com.example.tidsagenturet.Applications;
    opens com.example.tidsagenturet.Applications to javafx.fxml;
}