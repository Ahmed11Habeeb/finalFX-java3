package com.example.finalfx.view;

public class ViewManager {

    private static LogIn logInStage=null;
    private static AdminDashBoard adminDashBoard=null;

    private static PatientDashBoard patientDashBoard=null;



    public static LogIn getLogInStage(){
        if(logInStage==null)
            logInStage=new LogIn();
        return logInStage;
    }

    public static AdminDashBoard getAdminDashBoard(){
        if(adminDashBoard==null)
            adminDashBoard=new AdminDashBoard();
        return adminDashBoard;
    }

    public static PatientDashBoard getPatientDashboard(){
        if(patientDashBoard==null)
            patientDashBoard=new PatientDashBoard();
        return patientDashBoard;
    }



}
