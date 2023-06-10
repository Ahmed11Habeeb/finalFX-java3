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

public class updatePatient {
    //for ensure the user is used the search event before use update event and he verify the condition
    boolean useSearch=false;
    private String oldUserName;
    @FXML
    private TextField patientUpdateUserName;

    @FXML
    private TextField newPhone;

    @FXML
    private TextField newUserName;

    @FXML
    private TextField newPass;

    @FXML
    private TextField newEmail;

    @FXML
    Label alert;

    @FXML
    void searchForUpadte(ActionEvent event) throws SQLException {
        ResultSet userData= User.searchByUserName(patientUpdateUserName.getText());
        if(userData.next()){
            if(!(userData.getString("role").equalsIgnoreCase("patient"))){
                alert.setText("this user name not for patient");
                useSearch=true;
                return;
            }
            newUserName.setText(userData.getString("username"));
            newPass.setText(userData.getString("password"));
            newPhone.setText(userData.getString("phone"));
            newEmail.setText(userData.getString("email"));
            oldUserName=userData.getString("username");
            alert.setText("");
        }else {
            alert.setText("user name not found");
            newUserName.setText("");
            newPass.setText("");
            newPhone.setText("");
            newEmail.setText("");
            alert.setText("");
        }
    }

    @FXML
    void update(ActionEvent event) throws SQLException, IOException {
        if(useSearch){
            String userName=newUserName.getText();
            String pass=newPass.getText();
            String phone=newPhone.getText();
            String email=newEmail.getText();
            User.userUpdate(userName,pass,email,phone,oldUserName);
            ViewManager.getAdminDashBoard().crudPatientScene();
        }
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
