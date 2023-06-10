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
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowAllAppointments implements Initializable {

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

    ObservableList<Appointment> appointments=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        appointment_date.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointment_day.setCellValueFactory(new PropertyValueFactory<>("appointmentDay"));
        appointment_time.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @FXML
    void refresh(ActionEvent event){
        appointments.clear();
        try {
            ResultSet appointmentsData=Appointment.selectAppointments();
            while(appointmentsData.next()){
                if(appointmentsData.getString("status").equalsIgnoreCase("free")) {
                    //get data from DB
                    Integer id = appointmentsData.getInt(1);
                    String appointment_date = appointmentsData.getString(2);
                    String appointment_day = appointmentsData.getString(3);
                    String appointment_time = appointmentsData.getString(4);
                    String appointment_status = appointmentsData.getString(5);
                    //make Appointment object and assign his data
                    Appointment appointment = new Appointment();
                    appointment.setId(id);
                    appointment.setAppointmentDate(appointment_date);
                    appointment.setAppointmentDay(appointment_day);
                    appointment.setAppointmentTime(appointment_time);
                    appointment.setStatus(appointment_status);
                    //add to ObservableList
                    appointments.add(appointment);
                }
            }
            appointmentsTable.setItems(appointments);
        } catch (SQLException e) {
            System.out.println("failed connection");
        }
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
