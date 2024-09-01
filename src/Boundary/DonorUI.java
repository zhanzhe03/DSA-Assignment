/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Boundary;

import ADT.SortedListSetInterface;
import Entity.Donor;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class DonorUI {
     Scanner scanner = new Scanner(System.in);

    public int getDonorMenu() {
        System.out.println(""
                + "\n DONOR MANAGEMENT"
                + "\n 1. Display all donor"
                + "\n 2. Add a new donor"
                + "\n 3. Remove a donor"
                + "\n 4. Update donor details"
                + "\n 5. Search donor details"
                + "\n 6. Filter donor based on criteria"
                + "\n 7. List donors with all donation made "
                + "\n 8. Generate summary reports"
                + "\n 9. Back to MAIN MENU");
        System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }

    public void printText(String text) {
        System.out.println("\n" + text + "\n");
    }
    
     public void printDonorTitle() {
        System.out.printf("\n%-10s %-30s %-40s %-30s %-15s %-30s %-70s %-20s %-10s %-15s %-20s\n", "Donor ID", "Donor Category", "Donor Name", "Contact Person", "Contact","Email", "Address" , "Registered Date" ,"Status", "Donation ID", " Donation Date");
    }
     
     public void printAllDonors(SortedListSetInterface<Donor> donors) {
        System.out.println("\n" + donors.toString());
    }

    public void printNumberOfEntries(SortedListSetInterface<Donor> donors) {
        System.out.println("\nTotal Number of Donors > " + donors.getNumberOfEntries());
    }
    
    public int getDonorType(){
        System.out.println("Please select the type of donor:");
        System.out.println(String.format("%-5s %-15s", "1 = ", "Individual"));
        System.out.println(String.format("%-5s %-15s", "2 = ", "Organisation"));
        System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
    
    public int getOrganisationCategory() {
        System.out.println("Please select the category of Organisation:");
        System.out.println(String.format("%-5s %-15s", "1 = ", "Public"));
        System.out.println(String.format("%-5s %-15s", "2 = ", "Private"));
        System.out.println(String.format("%-5s %-15s", "3 = ", "Government"));
        System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
    
    public String getDonorName() {
        System.out.print("\nEnter Donor's Name :");
        String name = scanner.nextLine();
        return name;
    }

    public String getDonorEmail() {
        System.out.print("\nEnter Donor's Email :");
        String email = scanner.nextLine();
        return email;
    }
    
    public String getDonorContactPerson() {
        System.out.print("\nEnter Donor's Contact Person :");
        String contact = scanner.nextLine();
        return contact;
    }

    public String getDonorContact() {
        System.out.print("\nEnter Donor's Contact with (-) :");
        String contact = scanner.nextLine();
        return contact;
    }

    public String getDonorAddress() {
        System.out.print("\nEnter Donor's Address :");
        String address = scanner.nextLine();
        return address;
    }
    
    public int getDonorSearchMenu(){
         System.out.println(""
                + "\n Search Donor by : "
                + "\n 1. Donor ID"
                + "\n 2. Donor Name"
                + "\n 3. Donor Contact"
                + "\n 4. Back"
                );
          System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
    
    public int getDonorDeleteMenu(){
         System.out.println(""
                + "\n Remove Donor: "
                + "\n 1. Donor ID"
                + "\n 2. Delete All Banned Donor"
                + "\n 3. Back"
                );
          System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
    
    public int getAgainOrBack(String action){
        System.out.println(""
                + "\n Do you want to : "
                + "\n 1. " + action +" again"
                + "\n 2. Go Back"
                );
        System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
            
    public String getConfirmation(String action){
        System.out.print("\n\nDo you sure to " + action + " (Y/N): " );
        String yesno = scanner.nextLine();
        return yesno;
    }
    
    public String getDonorID(){
        System.out.print("\nEnter Donor ID:");
        String donorID = scanner.nextLine();
        return donorID;
    }
    
    public int getDonorStatus(){
        System.out.println(""
                + "\n Update Donor Status : "
                + "\n 1. Active"
                + "\n 2. Inactive"
                + "\n 3. Prospect"
                + "\n 4. Banned"
                );
          System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
    
    public int getDonorUpdateMenu(){
        System.out.println(""
                + "\n Update Donor Details by : "
                + "\n 1. Donor Name"
                + "\n 2. Donor Contact Person"
                + "\n 3. Donor Contact"
                + "\n 4. Donor Email"
                + "\n 5. Donor Address"
                + "\n 6. Donor Status"
                + "\n 7. Back"
                );
          System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
    
    public int getFilterCategoryOption(){
        System.out.println(""
                + "\n Filter Donor List by category: "
                + "\n 1. Individual"
                + "\n 2. All Organisation"
                + "\n 3. Public Organisation"
                + "\n 4. Private Organisation"
                + "\n 5. Government Organisation"
                + "\n 6. None"
                + "\n 7. Back"
                );
          System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
    
    public int getFilterStatusOption(){
         System.out.println(""
                + "\n Filter Donor List by status: "
                + "\n 1. Active"
                + "\n 2. Inactive"
                + "\n 3. Prospect"
                + "\n 4. Banned"
                + "\n 5. None"
                + "\n 6. Back"
                );
          System.out.print("\nopt > ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
    
    public void printDonorEnDash(){
        for (int i = 0; i < 300; i++) 
            System.out.print("-");
    }
    
}
