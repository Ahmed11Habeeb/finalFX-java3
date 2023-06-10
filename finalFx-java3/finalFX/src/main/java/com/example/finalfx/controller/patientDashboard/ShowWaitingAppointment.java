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

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowWaitingAppointment implements Initializable {

    @FXML
    private TableView<Appointment> appointmentsTable;

    @FXML
    private TableColumn<Appointment, String> appointment_day;

    @FXML
    private TableColumn<Appointment, String> appointment_time;

    @FXML
    private TableColumn<Appointment, String> appointment_date;

    @FXML
    private TableColumn<Appointment, Integer> id;

    @FXML
    private TableColumn<Appointment, String> status;

    ObservableList<Appointment> appointments= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointment_date.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointment_day.setCellValueFactory(new PropertyValueFactory<>("appointmentDay"));
        appointment_time.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        appointments.clear();
    }
    @FXML
    void refresh(ActionEvent event){
        appointments.clear();
        try {
            ResultSet waitingAppointments=Appointment.patientWaitingAppointments();
            while(waitingAppointments.next()){
                boolean  appointmentStatusChek=waitingAppointments.getString(4).equalsIgnoreCase("waiting");
                boolean userIDCheck=waitingAppointments.getInt(3)== User.loginPatient.getId();
                System.out.println("statisCheck"+appointmentStatusChek);
                System.out.println("IDCheck"+userIDCheck);
                if(appointmentStatusChek&&userIDCheck){
                    int appointID=waitingAppointments.getInt(6);
                    String date=waitingAppointments.getString(7);
                    String day=waitingAppointments.getString(8);
                    String time=waitingAppointments.getString(9);
                    String status=waitingAppointments.getString(10);
                    Appointment appointment=new Appointment();
                    appointment.setId(appointID);
                    appointment.setAppointmentDate(date);
                    appointment.setAppointmentDay(day);
                    appointment.setAppointmentTime(time);
                    appointment.setStatus(status);
                    appointments.add(appointment);
                    System.out.println("hello,world");
                }
            }
            appointmentsTable.setItems(appointments);
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