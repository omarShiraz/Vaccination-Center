package com.company;

public class Booth {
    private String mainName;
    private String firstName;
    private String surName;
    private String age;
    private String city;
    private String NIC;
    private int vaccinationRequest;

    //Declaration of the constructor
    public Booth() {
        mainName = "";
        firstName = "";
        surName = "";
        age = "";
        city = "";
        NIC = "";
        vaccinationRequest = 0;

    }

    //Set method
    public void setName(String aName) {
        mainName = aName;
    }

    //Get method
    public String getName() {
        return mainName;
    }
    //set Method
    public void setFirstName(String FirstName) {
        firstName = FirstName;
    }

    public void setSurName(String SurName) {
        surName = SurName;
    }

    public void setAge(String Age) { age = Age; }

    public void setCity(String City) { city = City; }

    public void setNIC(String nic) { NIC = nic; }

    public void setVaccinationRequest(int request) { vaccinationRequest = request; }
    //Get method
    String getFirstName() { return firstName; }

    String getSurName(){
        return surName;
    }

    String getAge() { return age; }

    String getCity() { return  city;}

    String getNIC() { return  NIC;}

    int getVaccinationRequest() { return vaccinationRequest; }

}


