package com.example.finalfx.controller.patientDashboard;

import com.example.finalfx.model.Appointment;
import com.example.finalfx.model.User;
import com.example.finalfx.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.finalfx.model.BookedAppointment;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowFinishAppointmnetComments implements Initializable {

    @FXML
    private TableView<BookedAppointment> bookedAppointment;

    @FXML
    private TableColumn<Appointment, Integer> appointmentID;

    @FXML
    private TableColumn<Appointment, String> appointmentDate;

    @FXML
    private TableColumn<Appointment, String> appointmentDay;

    @FXML
    private TableColumn<Appointment, String> doctorComment;
    ObservableList<BookedAppointment> bookedAppointments= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointmentDate.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointmentDay.setCellValueFactory(new PropertyValueFactory<>("appointmentDay"));
        doctorComment.setCellValueFactory(new PropertyValueFactory<>("doctorComment"));
        bookedAppointments.clear();
    }
    @FXML
    void refresh(ActionEvent event){
        bookedAppointments.clear();
        try {
            ResultSet waitingAppointments=Appointment.patientWaitingAppointments();

            while(waitingAppointments.next()){
                boolean  appointmentStatusChek=waitingAppointments.getString(4).equalsIgnoreCase("finished");
                boolean userIDCheck=waitingAppointments.getInt(3)== User.loginPatient.getId();
                if(appointmentStatusChek&&userIDCheck){
                    int appointID=waitingAppointments.getInt(6);
                    String date=waitingAppointments.getString(7);
                    String day=waitingAppointments.getString(8);
                    String doctorComment=waitingAppointments.getString(5);
                    BookedAppointment appointment=new BookedAppointment();
                    appointment.setAppointmentID(appointID);
                    appointment.setAppointmentDate(date);
                    appointment.setAppointmentDay(day);
                    appointment.setDoctorComment(doctorComment);
                    bookedAppointments.add(appointment);
                }
            }
            bookedAppointment.setItems(bookedAppointments);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
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
