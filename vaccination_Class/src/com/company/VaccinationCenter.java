package com.company;

import java.io.*;
import java.util.InputMismatchException;


import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        VaccinationCenter begin = new VaccinationCenter();   //Initializing and Calling menu
        begin.initialize();
	    begin.menu();
    }
}
public class VaccinationCenter {

    Scanner input = new Scanner(System.in);

    Booth[] myVaccine = new Booth[6];


    static String boothName;


    static int again = 1;

    public static int vaccineStock = 150; //global variable
    private int boothNum;


    public void menu() {
        try {
            while (again == 1) {
                System.out.println("===========================================================");
                System.out.println("*         Welcome to The Vaccination Center !!            *");
                System.out.println("===========================================================");
                System.out.println("* 100 or VVB: View all Vaccination booths                 *");
                System.out.println("* 101 or VEB: View all Empty Booths                       *");
                System.out.println("* 102 or APB: Add Patient to a Booth                      *");
                System.out.println("* 103 or RPB: Remove Patient from a Booth                 *");
                System.out.println("* 104 or VPS: View Patients Sorted in alphabetical order  *");
                System.out.println("* 105 or SPD: Store Program Data into file                *");
                System.out.println("* 106 or LPD: Load Program Data from file                 *");
                System.out.println("* 107 or VRV: View Remaining Vaccinations                 *");
                System.out.println("* 108 or AVS: Add Vaccinations to the Stock               *");
                System.out.println("* 999 or EXT: Exit the Program                            *");
                System.out.println("===========================================================");
                System.out.println();

                System.out.println("Choose one of the options from above. (E.g: Type 'VVB' or 'vvb' or '100' to to view all vaccination booth)");

                System.out.print("Enter your Option here : ");
                String selection = input.next();
                selection = selection.toUpperCase(); //changing to upperclass

                switch (selection) {
                    case "VVB":
                    case "100":
                        ViewAllBooths();
                        break;
                    case "VEB":
                    case "101":
                        emptyBooth();
                        break;
                    case "APB":
                    case "102":
                        addPatient();
                        break;
                    case "RPB":
                    case "103":
                        removePatient();
                        break;
                    case "VPS":
                    case "104":
                        viewBoothinAlphabaticOrder();
                        break;
                    case "SPD":
                    case "105":
                        StoreBoothDataInToFile();
                        break;
                    case "LPD":
                    case "106":
                        loadBoothDataFromFile();
                        break;
                    case "VRV":
                    case "107":
                        remainingVaccines();
                        break;
                    case "AVS":
                    case "108":
                        addStock();
                        break;
                    case "EXT":
                    case "999":
                        System.out.println("EXITING!!");
                        again = 2;
                        break;
                    default:
                        System.out.println("Invalid input! Please Enter Valid Inputs in the Given Menu");
                        break;
                }
                if (again != 1) {
                    break;
                }
                while (true) {
                    try {

                        System.out.println("-------------------------------------------------------------");
                        System.out.println("Would you like to Select another option?");
                        System.out.println("1)Enter 1 for Yes");
                        System.out.println("2)Enter 0 for No");
                        System.out.print("Enter your Answer here : ");
                        again = input.nextInt();
                        //if user enters 1 it loops if not it repeats until user put 1 or 0
                        if (again == 1) {
                            break;
                        } else if (again == 0) {
                            System.out.println("Exitting");
                            break;
                        } else {
                            System.out.println("Invalid Input");
                            continue;

                        }
                    }catch (Exception e){
                        System.out.println("Enter Integer !!");
                        break;
                    }
                }
            }

        } catch (Exception e) {

        }

    }

    public void initialize() {
        for (int i = 0; i < 6; i++) {
            myVaccine[i] = new Booth();
            myVaccine[i].setName("Empty");

        }
    }

    public void addPatient() {

        while (true) {

            try {
                System.out.print("Enter Vaccination Request\n 1 for AstraZeneca,\n 2 for Sinopharm,\n 3 for Pfizer:\n  ");
                int request = input.nextInt();

                if (request == 1){
                    if (myVaccine[0].getName().equals("Empty")){
                        boothNum = 0;
                        System.out.println("Added to booth number 0");
                    }
                    else if (myVaccine[1].getName().equals("Empty")){
                        boothNum = 1;
                        System.out.println("Added to booth number 1");
                    }
                    else {
                        System.out.println("AstraZenica Booths are full");
                        break;
                    }
                }
                else if (request == 2){
                    if (myVaccine[2].getName().equals("Empty")){
                        boothNum = 2;
                        System.out.println("Added to booth number 2");
                    }
                    else if (myVaccine[3].getName().equals("Empty")){
                        boothNum = 3;
                        System.out.println("Added to booth number 3");
                    }
                    else {
                        System.out.println("Sinopharm Booths are full");
                        break;
                    }
                }
                else if (request == 3){
                    if (myVaccine[4].getName().equals("Empty")){
                        boothNum = 4;
                        System.out.println("Added to booth number 4");
                    }
                    else if (myVaccine[5].getName().equals("Empty")){
                        boothNum = 5;
                        System.out.println("Added to booth number 5");
                    }
                    else {
                        System.out.println("Pfizer Booths are full");
                        break;
                    }
                }

                if (!myVaccine[boothNum].getName().equals("Empty")) {
                    System.out.println("This booth is occupied");


                } else if (boothNum >= 0 && boothNum <= 6) {
                    System.out.println("Enter name for booth " + boothNum + " to add to booth :");
                    boothName = input.next();
                    myVaccine[boothNum].setName(boothName);

                    System.out.println("------------------- Patient Details ------------------");
                    System.out.print("       First Name : ");
                    String FirstName = input.next();
                    myVaccine[boothNum].setFirstName(FirstName);
                    System.out.print("       SurName : ");
                    String SurName = input.next();
                    myVaccine[boothNum].setSurName(SurName);
                    System.out.print("       Age     : ");
                    String Age = input.next();
                    myVaccine[boothNum].setAge(Age);

                    System.out.print("       City    : ");
                    String City = input.next();
                    myVaccine[boothNum].setCity(City);

                    System.out.print("       NIC or passport No.    : ");
                    String nic = input.next();
                    myVaccine[boothNum].setNIC(nic);


                    myVaccine[boothNum].setVaccinationRequest(request);
                    vaccineStock--;
                    if (vaccineStock ==20){
                        System.out.println("WARNING!! Vaccination Stock is 20");
                    }
                    break;

                } else if (boothNum > 6) {

                    System.out.println("Invalid Input! Please Enter a value between 0-5");
                    System.out.println();
                }


            } catch (IndexOutOfBoundsException e) {

                System.out.println("Invalid Input! Please Enter a value between 0-5");  //This is for task2 when i update i dont need this
                System.out.println();
            }
        }
    }




    public void ViewAllBooths() {
        for (int j = 0; j < 6; j++) {
            if (!myVaccine[j].getName().equals("Empty")) {
                System.out.println("Booth " + j + " is occupied by " + myVaccine[j].getName());
                System.out.println("         First Name : " + myVaccine[j].getFirstName());
                System.out.println("         SurName : " + myVaccine[j].getSurName());
                System.out.println("         Age : " + myVaccine[j].getAge());
                System.out.println("         City : " + myVaccine[j].getCity());
                System.out.println("         Nic or Passport : " + myVaccine[j].getNIC());


                if (myVaccine[j].getVaccinationRequest() == 1){
                    System.out.println("         Vaccination Request: AstraZenica");

                } else if (myVaccine[j].getVaccinationRequest() == 2){
                    System.out.println("         Vaccination Request: Psynopholm");

                } else if(myVaccine[j].getVaccinationRequest() == 3){
                    System.out.println("         Vaccination Request: Pfizer");
                }
                else {
                    System.out.println();}
                System.out.println();

            } else {
                System.out.println("Booth Number. " + j + " is empty");
            }
        }
    }

    public void emptyBooth() {
        for (int i = 0; i < 6; i++) {
            if (myVaccine[i].getName().equals("e")) {
                System.out.println("Booth " + i + " is empty");
            }
        }
        System.out.println();

    }

    private void removePatient() {
        while (true) {
            try {
                System.out.print("Enter the booth number to delete(0-5): ");
                System.out.println();
                boothNum = input.nextInt();

                if (!myVaccine[boothNum].getName().equals("Empty")) {
                    myVaccine[boothNum].setName("Empty");
                    break;
                } else {
                    System.out.println("Booth " + boothNum + " is already empty");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! \nPlease enter value between (0-5)\n");
                input.next();

            } catch (IndexOutOfBoundsException e) {
                System.out.println("invalid booth number. Please enter a value between 0-5");

            }
        }
        System.out.println("the booth is cleared");
    }

    public void StoreBoothDataInToFile() {
        try {
            FileWriter myWriter = new FileWriter("Vaccination_class.txt"); //creating file and writing line by line
            for(int x =0 ; x < myVaccine.length; x++){
                myWriter.write("Name : " + myVaccine[x].getName() + "\n" );
                myWriter.write("Booth Number: " + (x) + "\n");
                myWriter.write(" -------------------------- Patient Details --------------------------" + "\n");
                myWriter.write("      First Name : " + myVaccine[x].getFirstName() + "\n" + "      SurName : " + myVaccine[x].getSurName() + "\n" + "      Age : " + myVaccine[x].getAge() + "\n" + "      City : " + myVaccine[x].getCity() + "\n" + "      NIC or passport : " + myVaccine[x].getNIC() + "\n");
                if (myVaccine[x].getVaccinationRequest() == 1){
                    myWriter.write("      Vaccination Request: AstraZenica\n");

                } else if (myVaccine[x].getVaccinationRequest() == 2){
                    myWriter.write("      Vaccination Request: Psynopharm\n");

                } else if(myVaccine[x].getVaccinationRequest() == 3){
                    myWriter.write("      Vaccination Request: Pfizer\n");
                }
                myWriter.write("________________________________________________________________________________________" + "\n");
                myWriter.write("\n\n ");
            }
            myWriter.close();
            System.out.println("Data is Stored");


            } catch (IOException ioException) {
            System.out.println("Error has occurred");
            ioException.printStackTrace();
        }


        System.out.println("All booth data has been save to boothCLass.txt");
        System.out.println();
    }

    public void loadBoothDataFromFile() {
        try{
            File myFile = new File("Vaccination_class.txt");
            Scanner myRead = new Scanner(myFile);
            while (myRead.hasNextLine()){
                String data = myRead.nextLine();    //Reading line by line and printing
                System.out.println(data);
            }
            myRead.close();
        }catch (FileNotFoundException e){
            System.out.println("An Error occurred.");
            e.printStackTrace();
        }


        System.out.println("All booth data has been loaded successfully.");
        System.out.println();
    }

    public void viewBoothinAlphabaticOrder() {
//using bubble sort to sort list reference given in report
        int index = 0;

        String[] copy = new String[6];
        String[] names = new String[6];

        for (int y = 0; y < 6; y++) {
            copy[y] = myVaccine[y].getName();
        }

        for (int x = 0; x < 6; x++) {
            names[x] = myVaccine[x].getName().toLowerCase();
        }


        boolean flag;
        for (int i = 0; i < names.length; i++) {
            flag = false;
            for (int j = i + 1; j < 6; j++) {
                if (names[j].compareTo(names[i]) < 0) {
                    String temp = names[j];
                    names[j] = names[i];
                    names[i] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }

        for (int i = 0; i < names.length; i++) {
            if (!(names[i].equals("empty"))) {

                for (int j = 0; j < copy.length; j++) {
                    if (copy[j].toLowerCase().equals(names[i])) {
                        index = j;
                    }
                }
                System.out.println(names[i] + " is in booth ");
            }
        }
        System.out.println();
    }

    public void remainingVaccines() {
        System.out.println("Booth remaining vaccine count is " + vaccineStock);

    }

    public void addStock() {
        vaccineStock = 150;

        System.out.println("Stock refilled");
        System.out.println();
    }

}