package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.model.User;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deletePatient {

    @FXML
    private Label result;

    @FXML
    private TextField deletePatientUserName;

    @FXML
    void delete(ActionEvent event) throws SQLException {
        String userName=deletePatientUserName.getText();
        ResultSet patientData= User.searchByUserName(userName);

        if(patientData.next()){
            if(!(patientData.getString("role").equalsIgnoreCase("patient"))) {
                result.setText("user name not for patient");
                return;
            }
            User.userDelete(userName);
            result.setText("user deleted");
        }else
            result.setText("user name did not find");
    }


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
