/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCentreCoursework_5COSC019W_Package;


public class Doctor extends StaffMember {
    // Attributes
    private String licenceNumber;
    private String specialisation;
    private int numberConsultationsperWeek;

    // Constructor
    public Doctor(String name, String surname){
        super(name, surname);
    }
    
    // SET AND GET METHODS
    // Set Medical License Number
    public void setLicenceNumber(String licenceNumber){
        this.licenceNumber = licenceNumber;
    }
    
    // Set Specialisation
    public void setSpecialisation(String specialisation){
        this.specialisation = specialisation;
    }
    
    // Set Numb of consultations per week
    public void setNumberConsultationsperWeek(int numberConsultationsperWeek) {
        this.numberConsultationsperWeek = numberConsultationsperWeek;
    }
    
    // Get Medical License Number
    public String getLicenceNumber(){
        return licenceNumber;
    }
    
    // Get Specialisation
    public String getSpec(){
        return specialisation;
    }
    
    // Get number of consulttaions per week
    public int getNumberConsultationsperWeek() {
        return numberConsultationsperWeek;
    }
    
     @Override
    public String toString(){
        return super.toString() + " Doctor - Medical Licence number: " + licenceNumber + ",  Specialisation: " + specialisation;
    }
    
}
