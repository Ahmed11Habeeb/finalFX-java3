package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.model.Appointment;
import com.example.finalfx.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class searchBookedAppointments  implements Initializable {

    @FXML
    private TextField patientFName;

    @FXML
    private TableView<Appointment> appointmentData;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointment_date.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointment_day.setCellValueFactory(new PropertyValueFactory<>("appointmentDay"));
        appointment_time.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @FXML
    void searchAppointment(ActionEvent event) throws SQLException {
        String pFName= patientFName.getText();
        ResultSet bookedAppointment=Appointment.searchBookedAppointmentbyPFname(pFName);
        ObservableList<Appointment>appointments= FXCollections.observableArrayList();
        while(bookedAppointment.next()){
            Appointment appointment=new Appointment();
            appointment.setId(bookedAppointment.getInt(6));
            appointment.setAppointmentDate(bookedAppointment.getString(7));
            appointment.setAppointmentDay(bookedAppointment.getString(8));
            appointment.setAppointmentTime(bookedAppointment.getString(9));
            appointment.setStatus(bookedAppointment.getString(10));
            appointments.add(appointment);
        }
        appointmentData.setItems(appointments);
    }

    //side bar
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
