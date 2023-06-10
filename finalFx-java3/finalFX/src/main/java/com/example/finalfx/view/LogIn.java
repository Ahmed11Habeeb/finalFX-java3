package com.example.finalfx.view;

import com.example.finalfx.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LogIn extends Stage {

    private Scene logIn;
    private Scene patientRegister;


    public void logInScene() throws IOException{
        FXMLLoader loader=new FXMLLoader(LogIn.class.getResource("logInFXML/logIn.fxml"));
        Parent root =loader.load();
        logIn=new Scene(root);
        this.setScene(logIn);
    }

    public void patientRegisterScene() throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("logInFXML/registerPage.fxml"));
        patientRegister=new Scene(loader.load());
        this.setScene(patientRegister);
    }


}
