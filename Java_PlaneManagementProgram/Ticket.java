/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1947450_planemangement;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author amala
 */
public class Ticket {
    private Person person;
    private char row;
    private int seat, price;

    public Ticket(Person person, char row, int seat, int price) {
        this.person = person;
        this.row = row;
        this.seat = seat;
        this.price = price;
        
        // call save method when ticket is created
        save();
    }

   

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    public void save(){
        String fileName = row + Integer.toString(seat) + ".txt";
         try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Ticket Information:");
            writer.println("Seat: " + row + seat);
            writer.println("Passenger: " + person.getName() + " " + person.getSurname());
            writer.println("Email: " + person.getEmail());
            writer.println("Price: $" + price);
            System.out.println("Ticket information saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving ticket to file.");
            e.printStackTrace();
        }
    }
    
}
