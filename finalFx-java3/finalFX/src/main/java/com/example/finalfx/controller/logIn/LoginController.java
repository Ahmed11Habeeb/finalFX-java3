package com.example.finalfx.controller.logIn;
import com.example.finalfx.model.DB;

import com.example.finalfx.model.User;
import com.example.finalfx.view.LogIn;
import com.example.finalfx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    Label alert;

    @FXML
    public void logIn(ActionEvent actionEvent) throws SQLException, IOException {
        Connection con=DB.getInstance().makeConnection();
        String uName=userName.getText();
        PreparedStatement preparedStatement=con.prepareStatement("select * from users where username=?");
        preparedStatement.setString(1,uName);
        ResultSet rs=preparedStatement.executeQuery();

        if(rs.next()&&uName.length()!=0) {
            if (rs.getRow() >= 1) {
                String role = rs.getString("role");
                String pass = rs.getString("password");
                String passInput = password.getText();
                boolean passCheck = passInput.equals(pass);
                if (passCheck) {
                    ViewManager.getLogInStage().close();
                    if (role.equals("admin")) {
                        ViewManager.getAdminDashBoard().mainScene();
                        ViewManager.getAdminDashBoard().show();
                    } else if (role.equals("patient")) {
                        ViewManager.getPatientDashboard().mainScene();
                        ViewManager.getPatientDashboard().show();
                        //make session for patient and save register data
                        User loginedPatient=new User();
                        loginedPatient.setUsername(uName);
                        loginedPatient.setPass(pass);
                        loginedPatient.setRole(role);
                        loginedPatient.setId(rs.getInt("id"));
                        User.loginPatient=loginedPatient;
                    }
                } else
                    alert.setText("Invalid password");
            } else
                ViewManager.getLogInStage().patientRegisterScene();
        }else
            alert.setText("Please Enter User Name");
    }

}
