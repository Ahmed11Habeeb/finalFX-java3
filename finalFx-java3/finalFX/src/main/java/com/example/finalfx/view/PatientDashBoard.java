package com.example.finalfx.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientDashBoard extends Stage {

    private Scene main;
    private Scene showAllAppointments;
    private Scene bookedAppointment;
    private Scene showFinishAppointmentComments;
    private Scene showWaitingAppointment;
    private Scene showFinishAppointment;


    public void mainScene() throws IOException {
        if(main==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientFXML/mainScene.fxml"));
            main = new Scene(loader.load());
        }
        this.setScene(main);
    }

    public void showAllAppointmentsScene() throws IOException {
        if(showAllAppointments==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientFXML/showAppointments.fxml"));
            showAllAppointments = new Scene(loader.load());
        }
        this.setScene(showAllAppointments);
    }
    public void bookedAppointmentScene() throws IOException {
        if(bookedAppointment==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientFXML/bookedAppointment.fxml"));
            bookedAppointment = new Scene(loader.load());
        }
        this.setScene(bookedAppointment);
    }

    public void finishAppointmentCommentsScene() throws IOException {
        if(showFinishAppointmentComments==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientFXML/showFinishAppointmentComments.fxml"));
            showFinishAppointmentComments = new Scene(loader.load());
        }
        this.setScene(showFinishAppointmentComments);
    }
    public void finishAppointmentScene() throws IOException {
        if(showFinishAppointment==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientFXML/showFinishAppointments.fxml"));
            showFinishAppointment = new Scene(loader.load());
        }
        this.setScene(showFinishAppointment);
    }
    public void waitingAppointmentScene() throws IOException {
        if(showWaitingAppointment==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientFXML/showWaitingAppointments.fxml"));
            showWaitingAppointment = new Scene(loader.load());
        }
        this.setScene(showWaitingAppointment);
    }



}
