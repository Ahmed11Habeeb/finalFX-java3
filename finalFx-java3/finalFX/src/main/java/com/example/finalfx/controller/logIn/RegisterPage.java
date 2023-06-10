package com.example.finalfx.controller.logIn;

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

public class RegisterPage {

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField email;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField age;
    @FXML
    ToggleGroup gender;

    @FXML
    public void newPatient(ActionEvent actionEvent) throws SQLException, IOException {
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
        ViewManager.getLogInStage().logInScene();
    }
}
