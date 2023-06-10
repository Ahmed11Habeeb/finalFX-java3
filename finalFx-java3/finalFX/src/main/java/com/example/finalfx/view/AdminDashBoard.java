package com.example.finalfx.view;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class AdminDashBoard extends Stage {

    private Scene showAllPatient;
    private Scene main;
    private Scene patientSearch;
    private Scene crudPatient;
    private Scene createPatient;
    private Scene updatePatient;
    private Scene deletePatient;
    private Scene showAllAppointments;
    private Scene searchAppointments;
    private Scene crudAppointment;
    private Scene createAppointment;
    private Scene updateAppointment;
    private Scene deleteAppointment;
    private Scene giveAppointmentComment;
    public void mainScene() throws IOException {
        if(main==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/mainScene.fxml"));
            main = new Scene(loader.load());
        }
        this.setScene(main);

    }
    public void showAllPatientScene()  throws IOException {
        if(showAllPatient==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/showAllPatient.fxml"));
            showAllPatient = new Scene(loader.load());
        }
        this.setScene(showAllPatient);
    }
    public void patientSearchScene() throws IOException {
        if(patientSearch==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/patientSearch.fxml"));
            patientSearch = new Scene(loader.load());
        }
        this.setScene(patientSearch);
    }

    public void crudPatientScene() throws IOException {
        if(crudPatient==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/crudPatient.fxml"));
            crudPatient = new Scene(loader.load());
        }
        this.setScene(crudPatient);
    }

    public void createPatientScene() throws IOException {
        if(createPatient==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/createNewPatient.fxml"));
            createPatient = new Scene(loader.load());
        }
        this.setScene(createPatient);
    }
    public void updatePatientScene() throws IOException {
        if(updatePatient==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/updatePatient.fxml"));
            updatePatient = new Scene(loader.load());
        }
        this.setScene(updatePatient);
    }
    public void deletePatientScene() throws IOException {
        if(deletePatient==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/deletePatient.fxml"));
            deletePatient = new Scene(loader.load());
        }
        this.setScene(deletePatient);
    }

    public void showAllAppointmentsScene() throws IOException {
        if(showAllAppointments==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/showAllAppointments.fxml"));
            showAllAppointments = new Scene(loader.load());
        }
        this.setScene(showAllAppointments);
    }

    public void searchBookedAppointmentsScene() throws IOException {
        if(searchAppointments==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/searchBookedAppointments.fxml"));
            searchAppointments = new Scene(loader.load());
        }
        this.setScene(searchAppointments);
    }

    public void crudAppointmentScene() throws IOException {
        if(crudAppointment==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/crudAppointment.fxml"));
            crudAppointment = new Scene(loader.load());
        }
        this.setScene(crudAppointment);
    }

    public void createAppointmentScene() throws IOException {
        if(createAppointment==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/createAppointment.fxml"));
            createAppointment = new Scene(loader.load());
        }
        this.setScene(createAppointment);
    }

    public void updateAppointmentScene() throws IOException {
        if(updateAppointment==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/updateAppointment.fxml"));
            updateAppointment = new Scene(loader.load());
        }
        this.setScene(updateAppointment);
    }
    public void deleteAppointmentScene() throws IOException {
        if(deleteAppointment==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/deleteAppointment.fxml"));
            deleteAppointment = new Scene(loader.load());
        }
        this.setScene(deleteAppointment);
    }
    public void giveAppointmentCommentScene() throws IOException {
        if(giveAppointmentComment==null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminFXML/giveAppointmentComment.fxml"));
            giveAppointmentComment = new Scene(loader.load());
        }
        this.setScene(giveAppointmentComment);
    }


}
