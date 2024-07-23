/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1947450_planemangement;

/**
 *
 * @author amala
 */
public class Person {
    private String name;
    private String surname;
    private String email;
    

    public Person ( String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
       
    }
    public void setName(String name) {
        this.name= name;
    }
    public String getName() {
        return this.name;
    }
    public void setSurname(String surname) {
        this.surname= surname;
    }
    public String getSurname() {
        return this.surname;
    }
    public void setEmail(String email) {
        this.email= email;
    }
    public String getEmail() {
        return this.email;
    }
}


