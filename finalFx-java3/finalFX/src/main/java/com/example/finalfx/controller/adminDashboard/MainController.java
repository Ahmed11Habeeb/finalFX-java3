package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.Main;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainController {


    @FXML
    void showAllPatient(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().showAllPatientScene();
    }

    @FXML
    void searchInPatient(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().patientSearchScene();
    }

    @FXML
    void crudPatient(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().crudPatientScene();
    }

    @FXML
    void crudAppointment(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().crudAppointmentScene();
    }

    @FXML
    void showMyAppointments(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().showAllAppointmentsScene();
    }

    @FXML
    void searchInBookedAppointments(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().searchBookedAppointmentsScene();
    }

    @FXML
    void giveBookedAppointmentMyComment(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().giveAppointmentCommentScene();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().close();
        ViewManager.getLogInStage().logInScene();
        ViewManager.getLogInStage().show();
    }

}
