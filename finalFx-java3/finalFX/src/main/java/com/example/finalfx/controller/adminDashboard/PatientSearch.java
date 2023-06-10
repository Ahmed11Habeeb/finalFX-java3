package com.example.finalfx.controller.adminDashboard;

import com.example.finalfx.model.User;
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

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PatientSearch implements Initializable {

    @FXML
    public TextField patientFName;

    @FXML
    private TableView<User> patientData;
    @FXML
    private TableColumn<User, String> userName;

    @FXML
    private TableColumn<User, String> fName;
    @FXML
    private TableColumn<User, String> lName;
    @FXML
    private TableColumn<User, Integer> age;
    @FXML
    private TableColumn<User, String> gender;
    @FXML
    private TableColumn<User, String> phone;
    @FXML
    private TableColumn<User, String> email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setCellValueFactory(new PropertyValueFactory<>("username"));
        fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    void patientSearch(ActionEvent event){

        String patientSearchName=patientFName.getText();
        try {
            ResultSet useresData=User.readUsers();
            ObservableList<User> patients= FXCollections.observableArrayList();
            while (useresData.next()) {
                boolean searchName=useresData.getString("username").contains(patientSearchName);
                boolean isPatient=useresData.getString("role").equalsIgnoreCase("patient");
                if(isPatient&&searchName){
                    User patient = new User();
                    patient.setUsername(useresData.getString("username"));
                    patient.setFirstName(useresData.getString("firstname"));
                    patient.setLastName(useresData.getString("lastname"));
                    patient.setAge(useresData.getInt("age"));
                    patient.setEmail(useresData.getString("email"));
                    patient.setPhone(useresData.getString("phone"));
                    patient.setGender(useresData.getString("gender"));
                    patients.add(patient);
                }
            }
            patientData.setItems(patients);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }


    //Side Bar functions controller
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
