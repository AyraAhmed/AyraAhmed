/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCentreCoursework_5COSC019W_Package;

/**
 *
 * @author w1947450
 */
public class Nurse extends StaffMember{
    private int YearOfExperience;
    private String department;

    public Nurse(String name, String surname) {
        super(name, surname);
    }

    public int getYearOfExperience() {
        return YearOfExperience;
    }

    public void setYearOfExperience(int YearOfExperience) {
        this.YearOfExperience = YearOfExperience;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String toString(){
        return super.toString() + " Years of Experience: " + YearOfExperience + "Department: " + department;
    }
    
}
