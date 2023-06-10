package com.example.finalfx.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static DB db=null;


    public static DB getInstance(){
        if(db==null)
            db=new DB();

        return db;
    }

    public Connection makeConnection() throws SQLException {
        //clinic_appointments
        String url="jdbc:mysql://localhost:3306/clinic_appointments";
        String userName="root";
        String password="";
        Connection con= DriverManager.getConnection(url,userName,password);
        return con;
    }
}
