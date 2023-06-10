package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.model.Appointment;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentComment {

    @FXML
    private TextField bookedAppointmentID;

    @FXML
    private TextArea myComment;

    @FXML
    private Label resultAlert;
    //check if appointment ID is booked and in waiting status
    boolean isSearch=false;


    @FXML
    void appointmentSearch(ActionEvent event){
        try {
            int appointmentID = Integer.parseInt(bookedAppointmentID.getText());
            ResultSet appointmentData = Appointment.searchInBookedAppointment(appointmentID);
            if(appointmentData.next()){
                if(appointmentData.getString("status").equalsIgnoreCase("waiting")){
                    isSearch=true;
                    resultAlert.setText("appointment is found");
                }else
                    resultAlert.setText("appointment is finished");
            }else
                resultAlert.setText("appointment not found");
        }catch (NumberFormatException n){
            resultAlert.setText("please Enter numeric value");
        }catch (SQLException x ){
            resultAlert.setText("failed connection to DB");
        }
    }
    @FXML
    void submitComment(ActionEvent event) throws SQLException {
        if(isSearch){
            int appointmentID = Integer.parseInt(bookedAppointmentID.getText());
            Appointment.giveComment(myComment.getText(),appointmentID);
            resultAlert.setText("your comment added successfully");
        }
    }

    //sdie bar events
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
