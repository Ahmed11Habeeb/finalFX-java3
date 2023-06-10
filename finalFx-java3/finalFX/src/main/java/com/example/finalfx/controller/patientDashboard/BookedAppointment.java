package com.example.finalfx.controller.patientDashboard;

import com.example.finalfx.model.Appointment;
import com.example.finalfx.model.User;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookedAppointment {

    @FXML
    private Label result;

    @FXML
    private TextField appointmentID;

    @FXML
    void bookAppointment(ActionEvent event){

        try {
            int appointmentID = Integer.parseInt(this.appointmentID.getText());
            ResultSet appointmentData = Appointment.selectByID(appointmentID);
            if(appointmentData.next()){
                if(!(appointmentData.getString("status").equalsIgnoreCase("free"))){
                    result.setText("appointment booked");
                    return;
                }
                User.loginPatient.bookAppointment(appointmentID);
                result.setText("booked appointment successfully");
            }else
                result.setText("appointment not found");
        }catch (NumberFormatException x){
            result.setText("Error:please enter numeric values");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //side bar

    @FXML
    void showAllAppointments(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().showAllAppointmentsScene();
    }

    @FXML
    void bookFreeAppointment(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().bookedAppointmentScene();
    }

    @FXML
    void BookedWaitingAppointment(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().waitingAppointmentScene();
    }

    @FXML
    void bookedFinishAppointment(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().finishAppointmentScene();
    }

    @FXML
    void finishAppointmnetDoctorComment(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().finishAppointmentCommentsScene();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        ViewManager.getPatientDashboard().close();
        ViewManager.getLogInStage().logInScene();
        ViewManager.getLogInStage().show();
    }


}
