/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package HealthCentreCoursework_5COSC019W_Package;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author w1947450
 */
public class DoctorTest {
    public Doctor doctor;
    
    public DoctorTest() {
    }

    
    @BeforeEach
    public void setUp() {
        doctor = new Doctor("Emily", "Paris");
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setLicenceNumber method, of class Doctor.
     */
    
    @Test
    public void testConstructor(){
        assertEquals("Emily", doctor.getName());
        assertEquals("Paris",doctor.getSurname());
    }
    @Test
    public void testSetAndGetLiceenceNumber(){
        doctor.setLicenceNumber("24680a");
        assertEquals("24680a", doctor.getLicenceNumber());
    }
    @org.junit.jupiter.api.Test
    public void testSetLicenceNumber() {
    }

    /**
     * Test of setSpecialisation method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testSetSpecialisation() {
    }

    /**
     * Test of setNumberConsultationsperWeek method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testSetNumberConsultationsperWeek() {
    }

    /**
     * Test of getLicenceNumber method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testGetLicenceNumber() {
    }

    /**
     * Test of getSpec method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testGetSpec() {
    }

    /**
     * Test of getNumberConsultationsperWeek method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumberConsultationsperWeek() {
    }

    /**
     * Test of toString method, of class Doctor.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
    }
    
}
