/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCentreCoursework_5COSC019W_Package;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public abstract class StaffMember implements Comparable<StaffMember> {
    
    private String name;
    private String surname;
    private LocalDate dob;
    private String phoneNo;
    private String staffID;
    
    // Constructor
    public StaffMember(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    
    // SET AND GET METHODS
    
    // Set name
    public void setName(String name){
        this.name = name;
    }
    
    // Set surname
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    // Set dob
    public void setDob(LocalDate dob){
        this.dob = dob;
    }
    
    // Set Phone Number
    public void setPhoneNo(String phoneNo){
        //format exmaple +44 1234 111-222
        this.phoneNo = phoneNo;
    }

    // set ID
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    
    // Get Name
    public String getName(){
        return name;
    }
    
    // Get Surname
    public String getSurname(){
        return surname;
    }
    
    // Get Date
    public LocalDate getDob() {
        return dob;
    }
    
    // Get Date of Birth in String "dd/MM/yyyy" format
    public String getStringDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dob.format(formatter);
        return formattedDate;
    }

    // Get Phone Number
    public String getPhoneNo(){
        return phoneNo;
    }

    // Get staffID
    public String getStaffID() {
        return staffID;
    }
    
    
    @Override
    public String toString(){
        return name + " " + surname +  ", ID: " + staffID + ", DOB: "  + getStringDate() + ", phone: " + phoneNo + ", ";
    }
    
    @Override 
    public int compareTo(StaffMember o){
        
        return this.surname.compareTo(o.surname);
        
    }
    
   


    
}
