package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.model.Role;
import com.example.finalfx.model.User;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.sql.SQLException;

public class createPatient {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField userName;

    @FXML
    private TextField age;

    @FXML
    private TextField email;

    @FXML
    void backToCrud(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().crudPatientScene();
    }
    @FXML
    void newPatient(ActionEvent event) throws SQLException, IOException {
        String userN=userName.getText();
        String pass=password.getText();
        String fName=firstName.getText();
        String lName=lastName.getText();
        String email=this.email.getText();
        String phoneNum=phoneNumber.getText();
        int age=Integer.parseInt(this.age.getText());
        String gender=((RadioButton)this.gender.getSelectedToggle()).getText();
        User user=new User(userN,pass,fName,lName,age,email,phoneNum,gender, Role.patient);
        //move data to DB
        user.insertUser();
        ViewManager.getAdminDashBoard().crudPatientScene();
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
