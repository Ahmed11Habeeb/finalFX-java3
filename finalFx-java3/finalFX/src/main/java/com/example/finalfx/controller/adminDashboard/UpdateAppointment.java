package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.model.Appointment;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateAppointment {

    @FXML
    private TextField appointmnetUpdateID;
    @FXML
    private TextField newStatus;
    @FXML
    private TextField newTime;
    @FXML
    private TextField newDay;
    @FXML
    private TextField newDate;
    @FXML
    private Label alert;

    boolean checked=false;
    @FXML
    void searchForUpadte(ActionEvent event){
        try {
            int id=Integer.parseInt(appointmnetUpdateID.getText());
            ResultSet searchedAppointment=Appointment.selectByID(id);
            if(searchedAppointment.next()){
                newDate.setText(searchedAppointment.getString("appointment_date"));
                newDay.setText(searchedAppointment.getString("appointment_day"));
                newTime.setText(searchedAppointment.getString("appointment_time"));
                newStatus.setText(searchedAppointment.getString("status"));
                checked=true;
                alert.setText("appointment is found");
            }else
                alert.setText("appointment not found");

        }catch (NumberFormatException x){
            alert.setText("please enter number value");
            newDate.setText("");
            newDay.setText("");
            newTime.setText("");
            newStatus.setText("");
        } catch (SQLException e) {
            alert.setText("connection failed");
        }
    }

    @FXML
    void update(ActionEvent event) throws SQLException, IOException {
        if(checked){
            int id=Integer.parseInt(appointmnetUpdateID.getText());
            String updateDate=newDate.getText();
            String updateDay=newDay.getText();
            String updateTime=newTime.getText();
            String updateStatus=newStatus.getText();
            boolean result=Appointment.updateAppointment(id,updateDate,updateDay,updateTime,updateStatus);
            if(!result)
                alert.setText("Appointment not update");

            ViewManager.getAdminDashBoard().crudAppointmentScene();
        }
    }

    //side bar
    @FXML
    void createAppointment(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().createAppointmentScene();
    }

    @FXML
    void updateAppointment(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().updateAppointmentScene();
    }

    @FXML
    void deleteAppointment(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().deleteAppointmentScene();
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        ViewManager.getAdminDashBoard().mainScene();
    }
}
