package org.example.denemeson;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;

public class HelloController {
    @FXML
    private AnchorPane admin_form;

    @FXML
    private Hyperlink admin_hyperlink;

    @FXML
    private Button admin_login;

    @FXML
    private PasswordField admin_password;

    @FXML
    private TextField admin_username;

    @FXML
    private TextField employee_ID;

    @FXML
    private AnchorPane employee_form;

    @FXML
    private Hyperlink employee_hyperLink;

    @FXML
    private Button employee_login;

    @FXML
    private PasswordField employee_password;

    @FXML
    private AnchorPane main_form;

    public void close(){
        System.exit(0);
    }

    public void switchForm(ActionEvent event){
        if(event.getSource() == admin_hyperlink){
            admin_form.setVisible(false);
            employee_form.setVisible(true);
        }else if(event.getSource() == employee_hyperLink){
            admin_form.setVisible(true);
            employee_form.setVisible(false);
        }
    }



    public void initialize(){

    }

}