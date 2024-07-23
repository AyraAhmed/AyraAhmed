package com.mycompany.w1947450_planemangement;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class W1947450_PlaneMangement {
// declare all the available seat rows 
    public static char[] CorrectRows = {'A', 'B', 'C', 'D'};
    static Ticket [] tickets =new Ticket[52]; 
    static int count;
    static int totalsales = 0;
    // declare all the available seat numbers in each row. the sub-array holds seat number, seat availability, seat price
    public static int [][] seatNumbersRowA = {{1,0,200}, {2,0,200},{3,0,200},{4,0,200},{5,0,200},{6,0,150},{7,0,150},{8,0,150},{9,0,150},{10,0,180},{11,0,180},{12,0,180},{13,0,180},{14,0,180}};
    public static int [][] seatNumbersRowB = {{1,0,200}, {2,0,200},{3,0,200},{4,0,200},{5,0,200},{6,0,150},{7,0,150},{8,0,150},{9,0,150},{10,0,180},{11,0,180},{12,0,180}};
    public static int [][] seatNumbersRowC = {{1,0,200}, {2,0,200},{3,0,200},{4,0,200},{5,0,200},{6,0,150},{7,0,150},{8,0,150},{9,0,150},{10,0,180},{11,0,180},{12,0,180}};
    public static int [][] seatNumbersRowD = {{1,0,200}, {2,0,200},{3,0,200},{4,0,200},{5,0,200},{6,0,150},{7,0,150},{8,0,150},{9,0,150},{10,0,180},{11,0,180},{12,0,180},{13,0,180},{14,0,180}};
    public static boolean menuContinue = true;
    public static boolean menuLoop = true;
    
    public static void main(String[] args) {
        //person UserInput = new person(person.setName);
        while (menuLoop & menuContinue){ // loop the menu every time the users inputs an data
        // display main menu
        System.out.println("Welcome to the Plane Management Application!");
        
        System.out.println("*".repeat(80));
        System.out.println("*" + " ".repeat(33) + "MENU OPTIONS" + " ".repeat(33)+ "*" + " ".repeat(33));
        System.out.println("*".repeat(80));
        
        // Menu options 
        System.out.println(" ".repeat(10) + "1)" + " ".repeat(2) + "Buy a seat");
        System.out.println(" ".repeat(10) + "2)" + " ".repeat(2) + "Cancel a seat");
        System.out.println(" ".repeat(10) + "3)" + " ".repeat(2) + "Find first available seat");
        System.out.println(" ".repeat(10) + "4)" + " ".repeat(2) + "Show seating plan");
        System.out.println(" ".repeat(10) + "5)" + " ".repeat(2) + "Print tickets information and total sales ");
        System.out.println(" ".repeat(10) + "6)" + " ".repeat(2) + "Search ticket");
        System.out.println(" ".repeat(10) + "0)" + " ".repeat(2) + "Quit");
        
        // input the user choice from the available options 
        
        // Asking the user to select an option 
        Scanner menuOption = new Scanner(System.in); // Creating a scanner object to read user input
        int choice = -1; // Initialising the choice variable with an invalid value to enter the loop
        // Loop to display the menu and process user input until the choice is 0 (exit)
        while (choice !=0){
            System.out.println("Please select an option from Menu Options: ");
            choice = menuOption.nextInt();
            switch (choice){
                case 1: 
                    Purchase_seat();
                    break;
                
                case 2:
                    Cancel_seat();
                    break;

                case 3:
                    find_first_available();
                    break;

                case 4:
                    show_seating_plan();
                    break;

                case 5:
                    print_tickets_info();
                    break;

                case 6: 
                    search_ticket();
                    break;

                case 0:
                    menuLoop = false;
                    break;
                default:
                    System.out.println(choice+ " is not a valid option.");
            }
        }       
    }
    }    
       //method to buy a seat 
    public static void Purchase_seat() {
        // this section will take the input for a seat row from user and loop until user enters the valid seat row
        boolean validSeatRow = false; 
        char selectedSeatRow = 0;
        int selectedSeatNumber[] = {0,0,0};
        Scanner UserInput = new Scanner(System.in);
        
        while (!validSeatRow){
            System.out.println("Enter your seat row: ");
            String seatRow = UserInput.next().toUpperCase();
            
            // String is array so take first letter and search in the seatRows 
            
        if ((Arrays.binarySearch(CorrectRows, seatRow.charAt(0)))>=0){
            selectedSeatRow = seatRow.charAt(0);
            //System.out.println("Thank you, you ahve selected seat row as " + selectedSeatRow);
            validSeatRow = true;
        }else{
            System.out.println("Not a vlid row, please try again [valid seat rows are: A, B, C, D ]");
            selectedSeatRow = 0;
            validSeatRow = false;
        }   
        
        }
        // this section will take the input for a seat row from user and loop until user enters the valid seat row 
        boolean validSeatNumber = false;
        boolean reservedSeatNumber = false; 
        int minSeatNumber = 1; 
        int maxSeatNumber = 14; 
        if (selectedSeatRow == 'B' || selectedSeatRow == 'C'){
            maxSeatNumber = 12;
        }
        while (! validSeatNumber){
            System.out.println("Now please selected a seat number in seat row (" + selectedSeatRow + ")");
            
            int seatNumber = UserInput.nextInt();
            
            if (seatNumber >= minSeatNumber && seatNumber <= maxSeatNumber){
                int seat;
                if (selectedSeatRow =='A'){
                    selectedSeatNumber[0]=seatNumbersRowA[seatNumber-1][0];
                    selectedSeatNumber[1] = seatNumbersRowA[seatNumber-1][1];
                    selectedSeatNumber[2] = seatNumbersRowA[seatNumber-1][2];
                    if(selectedSeatNumber[1]==0){
                        //its a valid seat and is availabe too. 
                        seatNumbersRowA[seatNumber-1][1]=1;
                        validSeatNumber = true;
                    }else{
                        //its a valid seat but not available as it has already been reserved. 
                        validSeatNumber = true;
                        reservedSeatNumber = true;
                    }  
                }
                else if (selectedSeatRow == 'B'){
                    selectedSeatNumber[0]=seatNumbersRowB[seatNumber-1][0];
                    selectedSeatNumber[1]=seatNumbersRowB[seatNumber-1][1];
                    selectedSeatNumber[2]=seatNumbersRowB[seatNumber-1][2];
                    if (selectedSeatNumber[1] == 0){
                        seatNumbersRowB[seatNumber-1][1] = 1;
                        validSeatNumber = true;
                    }else{
                        validSeatNumber = true;
                        reservedSeatNumber = true;
                    }
                }
                else if (selectedSeatRow == 'C'){
                    selectedSeatNumber[0]=seatNumbersRowC[seatNumber-1][0];
                    selectedSeatNumber[1]=seatNumbersRowC[seatNumber-1][1];
                    selectedSeatNumber[2]=seatNumbersRowC[seatNumber-1][2];
                    if(selectedSeatNumber[1] == 0){
                        seatNumbersRowC[seatNumber-1][1]=1;
                        validSeatNumber = true;
                    }else{
                        validSeatNumber = true;
                        reservedSeatNumber = true;
                    }
                }
                else if(selectedSeatRow == 'D'){
                    selectedSeatNumber[0]=seatNumbersRowD[seatNumber-1][0];
                    selectedSeatNumber[1]=seatNumbersRowD[seatNumber-1][1];
                    selectedSeatNumber[2]=seatNumbersRowD[seatNumber-1][2];
                    if (selectedSeatNumber[1] == 0){
                        seatNumbersRowD[seatNumber-1][1]=1;
                        validSeatNumber = true;
                    }else{
                        validSeatNumber = true; 
                        reservedSeatNumber = true;
                    }
                }
            }else{
                selectedSeatNumber[0] = 0;
                selectedSeatNumber[1] = 0;
                System.out.println("Not valid seat number, please try again");
                validSeatNumber = false;
            }
        }
        if(reservedSeatNumber){
            System.out.println("Seat number " + selectedSeatRow + selectedSeatNumber[0] + " has already been reserved.");
        }else{
            System.out.println("Please passenger first name: ");
            String fn = UserInput.next();
            System.out.println("Please passenger surname: ");
            String sn = UserInput.next();
            System.out.println("Please passenger email: ");
            String em = UserInput.next();
            Person person = new Person(fn, sn, em);
            Ticket ticket = new Ticket(person,selectedSeatRow, selectedSeatNumber[0], selectedSeatNumber[2]);
            totalsales+= selectedSeatNumber[2];
            tickets[count] = ticket;
            count++;
            System.out.println("Congratulations!! Your selected seat reserved for you. Deatails --> : Seat #" + selectedSeatRow + selectedSeatNumber[0] +", price: £" + selectedSeatNumber[2]);
        }
    }
    
    // method to search a ticket 
public static void search_ticket() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter seat row: ");
    char row = scanner.next().toUpperCase().charAt(0);
    System.out.println("Enter seat number: ");
    int seatNumber = scanner.nextInt();

    boolean found = false;
    for (int i = 0; i < tickets.length; i++) {
        if (tickets[i] != null && tickets[i].getRow() == row && tickets[i].getSeat() == seatNumber) {
            System.out.println("Ticket occupied at Seat #" + row + seatNumber);
            found = true;
            // Print user information from the Person class
            Person person = tickets[i].getPerson();
            System.out.println("Passenger Name & Surname: " + person.getName() + " " + person.getSurname());
            System.out.println("Passenger Email: " + person.getEmail());
        }
    }

    if (!found) {
        // Check if the seat is in CorrectRows but not available
        if (Arrays.binarySearch(CorrectRows, row) >= 0) {
            System.out.println("Seat #" + row + seatNumber + " is not occupied.");
        } else {
            System.out.println("Seat #" + row + seatNumber + " is not valid.");
        }
    }
}

    // method to print ticket info
    public static void print_tickets_info(){
        System.out.println("Your ticket information: " + totalsales + " pounds");
    }
    
//method to cancel a seat 
public static void Cancel_seat(){
    //this section will take the input for a seat row from the user and loop until the user enters the valid seat row 
    boolean validSeatRow = false; 
    char selectedSeatRow = 0; 
    int selectedSeatNumber[] = {0,0,0};
    
    Scanner UserInput = new Scanner(System.in);
    
    while (! validSeatRow){
        System.out.println("Enter your seat row: ");
        String seatRow = UserInput.next().toUpperCase();
        
        // String is array so take first letter and search in the seatRows
        
        if ((Arrays.binarySearch(CorrectRows, seatRow.charAt(0))) >=0){
            selectedSeatRow = seatRow.charAt(0);
            //System.out.println("Thank you, you have selected seat row as " + selectedSeatRow);
            validSeatRow = true;
        }else{
            System.out.println("Not a valid Row, please try again [valid seat rows are: A, B, C, D]");
            selectedSeatRow = 0; 
            validSeatRow = false; 
            
        }
    }
    
    //this section will take the input for a seat row from user and loop until user enters the valid seat row 
    boolean validSeatNumber = false; 
    boolean reservedSeatNumber = false;
    int minSeatNumber = 1; 
    int maxSeatNumber = 14;
    if (selectedSeatRow == 'B' || selectedSeatRow == 'C'){
            maxSeatNumber = 12;
    }
    while (! validSeatNumber){
            System.out.println("Now please selected a seat number in seat row (" + selectedSeatRow + ")");
            
            int seatNumber = UserInput.nextInt();
            
            if (seatNumber >= minSeatNumber && seatNumber <= maxSeatNumber){
                int seat;
                if (selectedSeatRow =='A'){
                    selectedSeatNumber[0]=seatNumbersRowA[seatNumber-1][0];
                    selectedSeatNumber[1] = seatNumbersRowA[seatNumber-1][1];
                    selectedSeatNumber[2] = seatNumbersRowA[seatNumber-1][2];
                    if(selectedSeatNumber[1]==1){
                        //its a valid seat and is availabe too. 
                        seatNumbersRowA[seatNumber-1][1]=0;
                        validSeatNumber = true;
                        reservedSeatNumber = true;
                    }else{
                        //its a valid seat but not available as it has already been reserved. 
                        validSeatNumber = false;
                        reservedSeatNumber = false;
                    }  
                }
                else if (selectedSeatRow == 'B'){
                    selectedSeatNumber[0]=seatNumbersRowB[seatNumber-1][0];
                    selectedSeatNumber[1]=seatNumbersRowB[seatNumber-1][1];
                    selectedSeatNumber[2]=seatNumbersRowB[seatNumber-1][2];
                    if (selectedSeatNumber[1] == 1){
                        seatNumbersRowB[seatNumber-1][1] = 0;
                        validSeatNumber = true;
                        reservedSeatNumber = true;
                    }else{
                        validSeatNumber = false;
                        reservedSeatNumber = false;
                    }
                }
                else if (selectedSeatRow == 'C'){
                    selectedSeatNumber[0]=seatNumbersRowC[seatNumber-1][0];
                    selectedSeatNumber[1]=seatNumbersRowC[seatNumber-1][1];
                    selectedSeatNumber[2]=seatNumbersRowC[seatNumber-1][2];
                    if(selectedSeatNumber[1] == 1){
                        seatNumbersRowC[seatNumber-1][1]=0;
                        validSeatNumber = true;
                        reservedSeatNumber = true;
                    }else{
                        validSeatNumber = false;
                        reservedSeatNumber = false;
                    }
                }
                else if(selectedSeatRow == 'D'){
                    selectedSeatNumber[0]=seatNumbersRowD[seatNumber-1][0];
                    selectedSeatNumber[1]=seatNumbersRowD[seatNumber-1][1];
                    selectedSeatNumber[2]=seatNumbersRowD[seatNumber-1][2];
                    if (selectedSeatNumber[1] == 1){
                        seatNumbersRowD[seatNumber-1][1]=0;
                        validSeatNumber = true;
                        reservedSeatNumber = true;
                    }else{
                        validSeatNumber = false; 
                        reservedSeatNumber = false;
                    }
                }
            }else{
                selectedSeatNumber[0] = 0;
                selectedSeatNumber[1] = 0;
                System.out.println("Not valid seat number, please try again");
                validSeatNumber = false;
            }
         
}
    if (reservedSeatNumber){
        totalsales-=selectedSeatNumber[2];
        System.out.println("Thanks, seat number " + selectedSeatRow + selectedSeatNumber[0] + " has been cancelled.");   
    }
    else{
        System.out.println("Sorry, seat number " + selectedSeatRow + selectedSeatNumber[0] + " is not reserved, so cannot be cancelled.");
    }
}
// method to find_first_avaiable 
public static void find_first_available() {
    int firstAvailableSeatColumn = -1;
    char firstAvailableSeatRow = ' ';
    
    // Variable to break the loop whenever an empty seat is found
    boolean emptySeatFound = false;
    
    // Loop through each row
    for (char row = 'A'; row <= 'C'; row++) {
        // Loop through each seat in the row
        for (int column = 0; column < 12; column++) {
            if (row == 'A' && seatNumbersRowA[column][1] == 0) {
                firstAvailableSeatRow = row;
                firstAvailableSeatColumn = column + 1;
                emptySeatFound = true;
                break; // Break the inner loop once an empty seat is found
            } else if ((row == 'B' || row == 'C') && seatNumbersRowB[column][1] == 0) {
                firstAvailableSeatRow = row;
                firstAvailableSeatColumn = column + 1;
                emptySeatFound = true;
                break; // Break the inner loop once an empty seat is found
            }
        }
        if (emptySeatFound) {
            break; // Break the outer loop once an empty seat is found
        }
    }
    
    String msg = "";
    if (firstAvailableSeatColumn > 0) {
        msg = "First empty seat is: " + firstAvailableSeatRow + firstAvailableSeatColumn;
    } else {
        msg = "Sorry, no seat available at the moment.";
    }
    
    // Print the message
    System.out.println("|" + " ".repeat(((82 - msg.length()) / 2) - 1) + msg + " ".repeat(((82 - msg.length()) / 2)) + "|");
    System.out.println(" " + "-".repeat(80));
}


// method to show_seating_plan
public static void show_seating_plan(){
 String title = "SEAT  PLAN"; 
    System.out.println(" " + "-".repeat(80));
    System.out.println("|" + " ".repeat(((82-title.length())/2)-1) + title + " ".repeat(((82-title.length())/2)-1)+ "|" );
    System.out.println(" " + "-".repeat(80));
    String seatPlan = "";

    // Row A
    for (int i=0;i<=seatNumbersRowA.length-1;i++){
        if (seatNumbersRowA[i][1] == 0) {
            seatPlan +=" O " ; 
        }
        else{
            seatPlan +=" X "  ;
        }
     }
    // Row B
    System.out.println("|" + " ".repeat(19) + seatPlan + " ".repeat(19) + "|" );
    seatPlan = "";

    for (int i=0;i<=seatNumbersRowB.length-1;i++){
        if (seatNumbersRowB[i][1] == 0) {
            seatPlan +=" O " ; 
        }
        else{
            seatPlan +=" X "  ;
        }
     }

     System.out.println("|" + " ".repeat(19) + seatPlan + " ".repeat(25) + "|" );
    seatPlan = "";

    // Row C
    for (int i=0;i<=seatNumbersRowC.length-1;i++){
        if (seatNumbersRowC[i][1] == 0) {
            seatPlan +=" O " ; 
        }
        else{
            seatPlan +=" X "  ;
        }
     }

     System.out.println("|" + " ".repeat(19) + seatPlan + " ".repeat(25) + "|" );
    seatPlan = "";

    // Row D
    for (int i=0;i<=seatNumbersRowD.length-1;i++){
        if (seatNumbersRowD[i][1] == 0) {
            seatPlan +=" O " ; 
        }
        else{
            seatPlan +=" X "  ;
        }
     }

    System.out.println("|" + " ".repeat(19) + seatPlan + " ".repeat(19) + "|" );
    seatPlan = "";
    System.out.println(" " + "-".repeat(80));
}
    }

