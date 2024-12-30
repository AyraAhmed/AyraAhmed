/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCentreCoursework_5COSC019W_Package;

/**
 *
 * @author b.villarini
 */
public class Receptionist extends StaffMember {

    private int deskNumber;
    private int hoursPerWeek;
    
    public Receptionist(String name, String surname){
        super(name, surname);
        deskNumber = 0;
    }
    
    public void setDeskNumber(int deskNumber){
        this.deskNumber = deskNumber;
    }
    
    public void setHoursPerWeek(int hourPerWeek) {
        this.hoursPerWeek = hourPerWeek;
    }
    
    public int getDeskNumber() {
        return deskNumber;
    }
    
    public int getHourPerWeek() {
        return hoursPerWeek;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Receptionist - Desk number: " + deskNumber + ", Working hours per week: " + hoursPerWeek; 
    }
}
