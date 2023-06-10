package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.model.Appointment;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteAppointment {

    @FXML
    private Label result;

    @FXML
    private TextField deleteAppointmnetID;

    @FXML
    void delete(ActionEvent event) throws SQLException {
        int appointmentID=Integer.parseInt(deleteAppointmnetID.getText());

        if(Appointment.deleteAppointment(appointmentID))
            result.setText("deleted successfully");
        else
            result.setText("not found");
    }

    //side bar events
    @FXML
    void createAppointment(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().createAppointmentScene();
    }

    @FXML
    void updateAppointment(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().updateAppointmentScene();
    }

    @FXML
    void deleteAppointment(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().deleteAppointmentScene();
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().mainScene();
    }



}
