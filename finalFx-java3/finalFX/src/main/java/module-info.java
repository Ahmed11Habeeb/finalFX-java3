module com.example.finalfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.finalfx to javafx.fxml;
    opens com.example.finalfx.controller.logIn to javafx.fxml;
    opens com.example.finalfx.controller.adminDashboard to javafx.fxml;
    opens com.example.finalfx.model to javafx.fxml;
    opens  com.example.finalfx.view.PatientFXML to javafx.fxml;
    opens com.example.finalfx.controller.patientDashboard to javafx.fxml;

    exports com.example.finalfx;
    exports com.example.finalfx.controller.logIn;
    exports com.example.finalfx.controller.adminDashboard;
    exports com.example.finalfx.model;

}