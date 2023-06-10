package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CrudAppointment {

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
