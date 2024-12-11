package org.example.denemeson;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GirişEkranıController {
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


    private double x = 0;
    private double y = 0;


    //Admin ve Employee girişleri arasında geçiş yapılıyor
    public void switchForm(ActionEvent event){
        if(event.getSource() == admin_hyperlink){
            admin_form.setVisible(false);
            employee_form.setVisible(true);
        }else if(event.getSource() == employee_hyperLink){
            admin_form.setVisible(true);
            employee_form.setVisible(false);
        }
    }

    private Alert alert;
    LoginManager loginManager = new LoginManager();

    //Admin girişi kontrol yapılıyor
    public void adminLogin(ActionEvent event) {
        try {
            if (event.getSource() == admin_login) {
                if (loginManager.adminDoğrulama(admin_username.getText(), admin_password.getText())) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Kullanıcı girişi başarılı");
                    alert.showAndWait();

                    kullaniciAdiVerme.admin = admin_username.getText();

                    admin_login.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("arayüzSınıfları/adminEkrani.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event1) ->{
                        x = event1.getSceneX();
                        y = event1.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event1) ->{
                        stage.setX(event1.getScreenX() - x);
                        stage.setY(event1.getScreenY() - y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Kullanıcı girişi başarısız");
                    alert.showAndWait();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Employee girişi kontrol ediliyor
    public void employeeLogin(ActionEvent event) {
        try {
            if (event.getSource() == employee_login) {
                if (loginManager.adminDoğrulama(employee_ID.getText(), employee_password.getText())) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Kullanıcı girişi başarılı");
                    alert.showAndWait();

                    admin_login.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("arayüzSınıfları/employeeEkrani.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Kullanıcı girişi başarısız");
                    alert.showAndWait();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    public void initialize(){

    }

}