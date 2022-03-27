package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;



public class VaccinationProgram {
    private static boolean SubMenu = true;  //make the while loop run over and over until user inputs false or given number below



    public static int vaccineStock = 150;   //global variable



    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        booth[] vaccination = new booth[6];
        for (int i = 0; i < vaccination.length; i++) {
            vaccination[i] = new booth();           //creating arrays for booths
        }

        int boothNum = 0;
        initialise(vaccination); //calling out this so that all booths names are set to empty
        while (SubMenu) {
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
            System.out.println("");
            System.out.println("Choose one of the options from above. (E.g: Type 'VVB' or 'vvb' or '100' to to view all vaccination booth)");

            System.out.println();
            System.out.print("Choice : ");
            String Selection = input.next();
            Selection = Selection.toUpperCase();

            switch (Selection) {
                case "VVB":
                case "100":
                    ViewAllBooths(vaccination);
                    break;
                case "VEB":
                case "101":
                    emptyBooth(vaccination);
                    break;
                case "APB":
                case "102":
                    addPatient(vaccination, boothNum);
                    break;
                case "RPB":
                case "103":
                    removePatient(vaccination, boothNum);
                    break;
                case "VPS":
                case "104":
                    viewBoothinAlphabaticOrder(vaccination);
                    break;
                case "SPD":
                case "105":
                    StoreBoothDataInToFile(vaccination);
                    break;
                case "LPD":
                case "106":
                    loadBoothDataFromFile(vaccination);
                    break;
                case "VRV":
                case "107":
                    remainingVaccines(vaccination);
                    break;
                case "AVS":
                case "108":
                    addStock(vaccination);
                    break;
                case "EXT":
                case "999":
                    System.out.println("EXITING!!");
                    System.exit(0);
                default:
                    System.out.println("Invalid input! Please Enter Valid Inputs in the Given Menu");
                    break;

            }
            while (true) {
                try {


                    System.out.println("Would you like to use the menu again\n1 ) If Yes press 1\n2 ) If No press 0");
                    System.out.println("");
                    int repeat = input.nextInt();
                    if (repeat == 1) {
                        SubMenu = true;
                        break;
                    } else if (repeat == 0) {
                        System.out.println("Exitting");
                        System.exit(0);
                    } else {
                        System.out.print("Invalid Input!!");
                        continue;

                    }
                }catch (Exception e){
                    System.out.println("Enter Integer");
                    break;

                }

            }

        }
    }

    public static class booth {

        //protected String mainName firstname surname vaccinationrequest;
        private String mainName;
        private String firstName;
        private String surName;
        private int vaccinationRequest;



        public booth() {
            mainName = " ";
            firstName = " ";
            surName = " ";
            vaccinationRequest = 0;

        }

        public void setName(String aName) {
            //  System.out.println("add name class method ");
            mainName = aName;
        }
        public String getName() {
            return mainName;
        }

        public void setFirstName(String FirstName) {
            firstName = FirstName;
        }

        public void setSurName(String SurName) {
            surName = SurName;
        }

        public void setVaccinationRequest(int request) {
            vaccinationRequest = request;

        }
        String getFirstName(){
            return firstName;
        }
        String getSurName(){
            return surName;
        }
        int getVaccinationRequest() {return vaccinationRequest;}




    }

    private static void initialise(booth[] vaccination) { //giving all booths empty name using set name
        for (int x = 0; x < vaccination.length; x++) {
            vaccination[x].setName("Empty");
        }
    }
    private static void ViewAllBooths(booth[] vaccination) {
        //This will display the booth number and the current patients name
        for (int x = 0; x < vaccination.length; x++) {
            if (vaccination[x].getName().equals("Empty")) {
                System.out.println("Booth " + x + " is Empty ");
                System.out.println();
            } else {
                System.out.println("booth " + (x) + " is occupied by " + vaccination[x].getName());
                System.out.println("         First Name : " + vaccination[x].getFirstName());
                System.out.println("         SurName : " + vaccination[x].getSurName());

                if (vaccination[x].getVaccinationRequest() == 1){
                    System.out.println("         Vaccination Request: Astrazenica");

                } else if (vaccination[x].getVaccinationRequest() == 2){
                    System.out.println("         Vaccination Request: Psynopholm");

                } else if(vaccination[x].getVaccinationRequest() == 3){
                    System.out.println("         Vaccination Request: Pfizer");
                }
                else {
                    System.out.println("");}
                System.out.println();
            }
        }
    }
    private static void addPatient(booth[] vaccination, int boothNum) {
        String boothName;
        Scanner input = new Scanner(System.in);
        try {
            while (true) {

                int count = 0;


                for (int i = 0; i < vaccination.length; i++){//this meant for task 4
                    if(!vaccination[i].getName().equals("Empty")){
                        count +=1;
                        if (count == 6){
                            System.out.println("All booth are full");
                            break;
                        }


                    }
                    break;

                }


                    System.out.print("Enter Vaccination Request\n 1 for AstraZeneca,\n 2 for Sinopharm,\n 3 for Pfizer:\n  ");
                    int request = input.nextInt();

                    if (request == 1){
                        if (vaccination[0].getName().equals("Empty")){
                            boothNum = 0;
                            System.out.println("Added to booth number 0");
                        }
                        else if (vaccination[1].getName().equals("Empty")){
                            boothNum = 1;
                            System.out.println("Added to booth number 1");
                        }
                        else {
                            System.out.println("Astrazenica Booths are full");
                            break;
                        }
                    }
                else if (request == 2){
                    if (vaccination[2].getName().equals("Empty")){
                        boothNum = 2;
                        System.out.println("Added to booth number 2");
                    }
                    else if (vaccination[3].getName().equals("Empty")){
                        boothNum = 3;
                        System.out.println("Added to booth number 3");
                    }
                    else {
                        System.out.println("Sinopharm Booths are full");
                        break;
                    }
                }
                else if (request == 3){
                    if (vaccination[4].getName().equals("Empty")){
                            boothNum = 4;
                            System.out.println("Added to booth number 4");
                        }
                    else if (vaccination[5].getName().equals("Empty")){
                            boothNum = 5;
                            System.out.println("Added to booth number 5");
                        }
                    else {
                            System.out.println("Pfizer Booths are full");
                            break;
                        }
                    }



                if (!vaccination[boothNum].getName().equals("Empty")) {
                    System.out.println("Booth occupied");
                }

                else if (boothNum >= 0 && boothNum < 6) {
                    System.out.print("Enter name for booth " + boothNum + " to be added to : ");
                    boothName = input.next();
                    vaccination[boothNum].setName(boothName);
                    System.out.println("------------------- Patient Details ------------------");
                    System.out.print("       First Name : ");
                    String FirstName = input.next();
                    vaccination[boothNum].setFirstName(FirstName);
                    System.out.print("       SurName : ");
                    String SurName = input.next();
                    vaccination[boothNum].setSurName(SurName);
                    vaccination[boothNum].setVaccinationRequest(request);
                    vaccineStock--;
                    if (vaccineStock == 20){
                        System.out.println("Warning vaccination limit to 20");
                    }
                    break;

                } else if (boothNum > 6) {
                    System.out.println("Invalid Booth number! Please Enter a value between 0-5");
                    System.out.println("");
                }


                }


        }catch (Exception e){

        }

    }
    private static void emptyBooth(booth[] vaccination){
        for (int i = 0; i < vaccination.length; i++){
            if (vaccination[i].getName().equals("Empty")){
                System.out.println("Booth " + i + " is empty");
            }
        }
    }
    private static void removePatient(booth[] vaccination, int boothNum){
        Scanner inout = new Scanner(System.in);
        System.out.println("Enter booth number to remove patient (0-5): ");
        boothNum = inout.nextInt();
        vaccination[boothNum].setName("Empty");
        System.out.println("THis Booth is now Empty");
    }
    private static void viewBoothinAlphabaticOrder(booth[] vaccination) {
        String[] strArray = new String[vaccination.length];
        for (int i = 0; i < vaccination.length; i++) {
            if(!vaccination[i].getName().equals("Empty"))
                strArray[i] = vaccination[i].getName();

        }

        Arrays.sort(strArray);
        for (int j = 0; j < strArray.length; j++){
            System.out.println(strArray[j]);
        }
    }
    private static void StoreBoothDataInToFile(booth[] vaccination) throws IOException {
        //saving booth to txt file Data
        try (FileWriter myWriter = new FileWriter("Vaccination_Array.txt")) {

            for (int x = 0; x < vaccination.length; x++) {
                myWriter.write("Name : " + vaccination[x].getName() + "\n");
                myWriter.write("Booth Number: " + (x) + "\n");
                myWriter.write(" -------------------------- Patient Details --------------------------" + "\n");
                myWriter.write("      First Name : " + vaccination[x].getFirstName() + "\n" + "      SurName : " + vaccination[x].getSurName()+ "\n");
                if (vaccination[x].getVaccinationRequest() == 1){
                    myWriter.write("      Vaccination Request: Astrazenica\n");

                } else if (vaccination[x].getVaccinationRequest() == 2){
                    myWriter.write("      Vaccination Request: Pfizer\n");

                } else if(vaccination[x].getVaccinationRequest() == 3){
                    myWriter.write("      Vaccination Request: Pfizer\n");
                }

                myWriter.write("________________________________________________________________________________________" + "\n");
                myWriter.write("\n\n ");
            }


            }
            System.out.println("All Booth data has been Saved.");
        }


    private static void loadBoothDataFromFile(booth[] vaccination) throws IOException {
        //loading saved Data from the Text File

        FileInputStream fs = new FileInputStream("Vaccination_Array.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        try {
            File myFile = new File("Vaccination_Array.txt");
            Scanner myRead = new Scanner(myFile);
            while (myRead.hasNextLine()) {
                String data = myRead.nextLine();
                System.out.println(data);
            }
            myRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error occurred.");
            e.printStackTrace();
        }


        System.out.println("All Booth data has  been loaded successfully.");
    }


    private static void remainingVaccines (booth[] vaccination) {
        System.out.println("Remaining vaccine count is "+ vaccineStock);

        }
    private static void addStock (booth[] vaccination) {
        vaccineStock = 150;

        System.out.println("Stock has been refilled");

    }




}


