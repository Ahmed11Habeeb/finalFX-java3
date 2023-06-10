package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.view.ViewManager;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import java.io.IOException;

public class crudpatient {


    //side bar

    @FXML
    void createPatient(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().createPatientScene();
    }

    @FXML
    void updatePatient(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().updatePatientScene();
    }

    @FXML
    void deletePatient(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().deletePatientScene();
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().mainScene();
    }



}
