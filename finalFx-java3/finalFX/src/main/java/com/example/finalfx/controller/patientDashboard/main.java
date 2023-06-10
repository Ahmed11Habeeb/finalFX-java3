package com.example.finalfx.controller.patientDashboard;

import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class main {

    @FXML
    void showAllAppointments(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().showAllAppointmentsScene();
    }

    @FXML
    void bookFreeAppointment(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().bookedAppointmentScene();
    }

    @FXML
    void BookedWaitingAppointment(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().waitingAppointmentScene();
    }

    @FXML
    void bookedFinishAppointment(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().finishAppointmentScene();
    }

    @FXML
    void finishAppointmnetDoctorComment(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().finishAppointmentCommentsScene();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().close();
        ViewManager.getLogInStage().logInScene();
        ViewManager.getLogInStage().show();
    }
}
