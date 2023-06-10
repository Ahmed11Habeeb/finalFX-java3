package com.example.finalfx.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {

    private int id;

    // date format:yyyy-MM-dd
    private String appointmentDate;
    private String appointmentDay;
    //time format~hh:mm
    private String appointmentTime;
    private String status;

    public Appointment(String appointment_date, Day day, String appointment_time, AppointmentStatus status){
        this.setAppointmentDate(appointment_date);
        this.setAppointmentDay(String.valueOf(day));
        this.setAppointmentTime(appointment_time);
        this.setStatus(String.valueOf(status));
    }
    public Appointment(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointment_date) {
        this.appointmentDate = appointment_date;
    }

    public String getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(String appointment_day) {
        this.appointmentDay = appointment_day;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointment_time) {
        this.appointmentTime = appointment_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void insertAppointment() throws SQLException, ParseException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement insertState= connection.prepareStatement("insert into appointments (appointment_date,appointment_day," +
                "appointment_time,status) values(?,?,?,?)");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(this.getAppointmentDate());
        java.sql.Date dateSQL=new java.sql.Date(date.getTime());
        insertState.setDate(1,dateSQL);
        insertState.setString(2,this.getAppointmentDay());

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        java.util.Date parsedTime = timeFormat.parse(this.getAppointmentTime());
        Time sqlTime = new Time(parsedTime.getTime());
        insertState.setTime(3,sqlTime);

        insertState.setString(4,this.getStatus());

        int alert=insertState.executeUpdate();

        if(alert==1){
            //print alert
        }
    }

    public static ResultSet selectAppointments() throws SQLException {

        Connection connection=DB.getInstance().makeConnection();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from appointments");

        return rs;
    }

    public static ResultSet selectByID(int id) throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement selectID=connection.prepareStatement("select * from appointments where id=?");
        selectID.setInt(1,id);
        ResultSet rs=selectID.executeQuery();
        return rs;
    }

    public static boolean updateAppointment(int id,String date,String day,String time,String status) throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement updateState=connection.prepareStatement("update appointments set appointment_date=?,appointment_day=?," +
                "appointment_time=?,status=? where id=?");
        updateState.setString(1,date);
        updateState.setString(2,day);
        updateState.setString(3,time);
        updateState.setString(4,status);
        updateState.setInt(5,id);
        int result=updateState.executeUpdate();
        return result==1;
    }
    public static boolean deleteAppointment(int appointmentID) throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement deleteState=connection.prepareStatement("delete from appointments where id=?");
        deleteState.setInt(1,appointmentID);
        int result=deleteState.executeUpdate();
        return result==1;
    }

    public static ResultSet patientWaitingAppointments() throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement waitingAppointments=connection.prepareStatement("select * from booked_appointments join appointments on " +
                "appointment_id=appointments.id ");
        ResultSet rs=waitingAppointments.executeQuery();
        return rs;
    }

    public static ResultSet searchInBookedAppointment(int id) throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement bookedAppointment=connection.prepareStatement("select * from booked_appointments where appointment_id=?");
        bookedAppointment.setInt(1,id);
        ResultSet rs=bookedAppointment.executeQuery();
        return rs;
    }

    public static boolean giveComment(String comment,int appointmentID) throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement giveComment=connection.prepareStatement("update booked_appointments set status=?,doctor_commnet=? where appointment_id =?");
        giveComment.setString(1,"finished");
        giveComment.setString(2,comment);
        giveComment.setInt(3,appointmentID);
        int result=giveComment.executeUpdate();
        return result==1;
    }
    //for searchBookedAppointment to admin
    public static ResultSet searchBookedAppointmentbyPFname(String pFName) throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from booked_appointments join " +
                "appointments on appointment_id =appointments.id join users on user_id=users.id where firstname=?");
        preparedStatement.setString(1,pFName);
        ResultSet rs=preparedStatement.executeQuery();
        return rs;
    }

}
