package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class details {

    @FXML
    TextField fname;
    @FXML
    TextField sname;
    @FXML
    private TextField city;

    @FXML
    private TextField age;

    @FXML
    private TextField nic;
    @FXML
    private RadioButton Ast;

    @FXML
    private ToggleGroup tGroup;

    @FXML
    private RadioButton Psy;

    @FXML
    private RadioButton Pfi;

    @FXML
    private Label Lbl;



    private Stage stage;
    private Scene scene;
    private Parent root;




    public void login(ActionEvent event) throws IOException {


        if (fname.getText().length() == 0) {
            fname.setStyle("-fx-border-color: orange;");
        } else {
            fname.setStyle(null);

        if (sname.getText().length() == 0) {
            sname.setStyle("-fx-border-color: orange;");
        } else {
            sname.setStyle(null);
        if (age.getText().length() == 0) {
            age.setStyle("-fx-border-color: orange;");
        } else {
            age.setStyle(null);
        if (city.getText().length() == 0) {
            city.setStyle("-fx-border-color: orange;");
        } else {
            city.setStyle(null);
        if (nic.getText().length() == 0) {
            nic.setStyle("-fx-border-color: orange;");
       } else {
            nic.setStyle(null);

                String username = fname.getText();
                String Surname = sname.getText();
                String Age = age.getText();
                String City = city.getText();
                String NIC = nic.getText();



                String message = "";

                if (Ast.isSelected()) {
                    message += Ast.getText() + "\n";
                }
                if (Psy.isSelected()) {
                    message += Psy.getText() + "\n";
                }
                if (Pfi.isSelected()) {
                    message += Pfi.getText() + "\n";
                }
                Lbl.setText(message);


                FXMLLoader loader = new FXMLLoader(getClass().getResource("genrate_reciept.fxml"));
                root = loader.load();

                reciept Reciept = loader.getController();
                Reciept.displayName(username);
                Reciept.displaySname(Surname);
                Reciept.displaysAge(Age);
                Reciept.displayCity(City);
                Reciept.displayNIC(NIC);

                Reciept.displayvaccine(message);
                Reciept.Clock();


                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }

        }
        }
        }
        }
    }
}