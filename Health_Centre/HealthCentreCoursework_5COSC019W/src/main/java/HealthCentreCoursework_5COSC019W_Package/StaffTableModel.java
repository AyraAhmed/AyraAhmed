/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HealthCentreCoursework_5COSC019W_Package;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class StaffTableModel extends AbstractTableModel{
    
    
    private String[] columnNames = {"Name", "Surname", "Date of Birth", "Role", "Staff ID"}; 
    private ArrayList<StaffMember> list; 
    
    public StaffTableModel(ArrayList<StaffMember> staffList){
        list = staffList;
    }

    @Override
    public int getRowCount() {
        return list.size();   
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null; 
        if (columnIndex == 0) { 
         temp = list.get(rowIndex).getName(); 
      } 
        else if (columnIndex == 1) { 
         temp = list.get(rowIndex).getSurname(); 
      } 
      else if (columnIndex == 2) { 
         temp = list.get(rowIndex).getStringDate(); 
      } 
      else if (columnIndex == 3) { 
          if(list.get(rowIndex) instanceof Doctor){
            temp = "Doctor"; 
          }else if(list.get(rowIndex) instanceof Receptionist){
            temp = "Receptionist";
          
          }else{
              temp = "Nurse";
              
          }
      } else if (columnIndex == 4){
          temp = list.get(rowIndex).getStaffID();
          
      }
      return temp; 
        
    }
    
    // needed to show column names in JTable 
   public String getColumnName(int col) { 
      return columnNames[col]; 
   } 

    
}

