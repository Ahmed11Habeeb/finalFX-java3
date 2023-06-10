package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.model.Appointment;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class CreateAppointment {

    @FXML
    private TextField date;

    @FXML
    private TextField time;

    @FXML
    private TextField day;

    @FXML
    private TextField status;

    @FXML
    void addAppointment(ActionEvent event) throws SQLException, ParseException, IOException {
        String date=this.date.getText();
        String time=this.time.getText();
        String day=this.day.getText();
        String status=this.status.getText();

        Appointment newAppointment=new Appointment();
        newAppointment.setAppointmentDate(date);
        newAppointment.setAppointmentTime(time);
        newAppointment.setAppointmentDay(day);
        newAppointment.setStatus(status);

        newAppointment.insertAppointment();
        ViewManager.getAdminDashBoard().crudAppointmentScene();
    }

    @FXML
    void backToCrud(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().crudAppointmentScene();
    }
}
