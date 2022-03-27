package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class reciept {

    @FXML
    private Label fname;

    @FXML
    private Label age;

    @FXML
    private Label sname;

    @FXML
    private Label City;
    @FXML
    private Label nic;

    @FXML
    private Label request;
    @FXML
    private Label Time;

    @FXML
    private Label date;



    public void displayName(String username) {
        fname.setText("Firstname:" + username);
    }
    public void displaySname(String Surname) {
        sname.setText("Surname: " + Surname);
    }
    public void displayvaccine(String message) {
        request.setText("Vaccine Request: " + message);
    }
    public void displayCity(String city) {
        City.setText("City: " + city);
    }
    public void displayNIC(String NIC) {
        nic.setText("NIC No: " + NIC);
    }
    public void displaysAge(String AGE) {
        age.setText("Age: " + AGE);
    }
    public void Clock(){
        Calendar cal =new GregorianCalendar();
        int day =cal.get(Calendar.DAY_OF_MONTH);
        int Month =cal.get(Calendar.MONTH);
        int year =cal.get(Calendar.YEAR);

        int sec =cal.get(Calendar.SECOND);
        int Min =cal.get(Calendar.MINUTE);
        int hour =cal.get(Calendar.HOUR);
        Time.setText("Time  "+ hour+":"+Min+":"+ sec);
        date.setText("Date "+day+":"+Month+":"+year);



    }

}