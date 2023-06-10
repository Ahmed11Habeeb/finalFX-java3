package com.example.finalfx.model;

import java.sql.*;

public  class User {

    public static User loginPatient;
    private int id;
    private String username;

    private String pass;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String gender;
    private String role;

    public User(String username,String pass,String firstName,String lastName,int age,String email,String phone,String gender,Role role){
        this.setUsername(username);
        this.setPass(pass);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setEmail(email);
        this.setPhone(phone);
        this.setGender(gender);
        this.setRole(String.valueOf(role).toLowerCase().trim());
    }
    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public void insertUser() throws SQLException {
        Connection con=DB.getInstance().makeConnection();
        PreparedStatement insertState=con.prepareStatement("INSERT INTO users (username, password, firstname, lastname, age, email, phone, gender, role)" +
                " VALUES (?,?,?,?,?,?,?,?,?)");
        insertState.setString(1,this.getUsername());
        insertState.setString(2,this.getPass());
        insertState.setString(3,this.getFirstName());
        insertState.setString(4,this.getLastName());
        insertState.setInt(5,this.getAge());
        insertState.setString(6,this.getEmail());
        insertState.setString(7,this.getPhone());
        insertState.setString(8,this.getGender());
        insertState.setString(9,this.getRole());

        int alert=insertState.executeUpdate();

        if(alert==1){
            //print alert
        }

    }
    public static ResultSet readUsers() throws SQLException {

        Connection connection=DB.getInstance().makeConnection();
        Statement reader=connection.createStatement();
        ResultSet usersData=reader.executeQuery("select * from users");
        return  usersData;
    }
    public static  ResultSet searchByUserName(String userName) throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement selectUser=connection.prepareStatement("select * from users where username=?");
        selectUser.setString(1,userName);
        ResultSet rs =selectUser.executeQuery();
        return rs;
    }

    public static void userUpdate(String newUserName,String newPass,String newEmail,String newPhone,String oldUserName) throws SQLException {
        Connection con=DB.getInstance().makeConnection();
        PreparedStatement updateState=con.prepareStatement("update users set username=?,password=?,email=?," +
                "phone=? where username=?");
        updateState.setString(1,newUserName);
        updateState.setString(2,newPass);
        updateState.setString(3,newEmail);
        updateState.setString(4,newPhone);
        updateState.setString(5,oldUserName);

        int alert=updateState.executeUpdate();
        if(alert==1){
            //print alert
        }
    }
    public static void userDelete(String username) throws SQLException {
        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement deleteSate= connection.prepareStatement("delete from users where username=?");
        deleteSate.setString(1,username);
        int alert=deleteSate.executeUpdate();

        if(alert==1){
            //print alert
        }
    }

    public boolean bookAppointment(int appointmentID) throws SQLException {

        Connection connection=DB.getInstance().makeConnection();
        PreparedStatement bookAppointmentState=connection.prepareStatement("insert into booked_appointments (appointment_id,user_id,status)" +
                "values (?,?,?)");
        bookAppointmentState.setInt(1,appointmentID);
        bookAppointmentState.setInt(2,this.getId());
        bookAppointmentState.setString(3,"waiting");
        int result=bookAppointmentState.executeUpdate();
        //change the appointment status to booked
        PreparedStatement updateAppointmentStatus=connection.prepareStatement("update appointments set status=? where id=?");
        updateAppointmentStatus.setString(1,"booked");
        updateAppointmentStatus.setInt(2,appointmentID);
        updateAppointmentStatus.executeUpdate();
        return result==1;
    }
}
