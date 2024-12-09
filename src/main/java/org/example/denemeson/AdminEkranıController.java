package org.example.denemeson;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminEkranıController implements Initializable {

    @FXML
    private AnchorPane adminMain_Form;

    @FXML
    private TableView<?> productEkleme_Tablo;

    @FXML
    private TextField productEkleme_brandName;

    @FXML
    private Button productEkleme_ekleBTN;

    @FXML
    private AnchorPane productEkleme_form;

    @FXML
    private TextField productEkleme_price;

    @FXML
    private TextField productEkleme_productID;

    @FXML
    private TextField productEkleme_productName;

    @FXML
    private TextField productEkleme_searcBTN;

    @FXML
    private Button productEkleme_silBTN;

    @FXML
    private ComboBox<?> productEkleme_status;

    @FXML
    private TableColumn<?, ?> productEkleme_tablo_brandName;

    @FXML
    private TableColumn<?, ?> productEkleme_tablo_price;

    @FXML
    private TableColumn<?, ?> productEkleme_tablo_productID;

    @FXML
    private TableColumn<?, ?> productEkleme_tablo_productName;

    @FXML
    private TableColumn<?, ?> productEkleme_tablo_status;

    @FXML
    private Button productEkleme_temizleBTN;

    @FXML
    private Button productEkleme_yenileBTN;

    @FXML
    private Button geriÇıkış;

    @FXML
    private Button pencereyiKapatBTN;

    @FXML
    private Button çıkışBTN;

    @FXML
    private Button adminArayüzü_solPencere_ürünEkle;

    @FXML
    private AnchorPane istatistikEkranı;

    @FXML
    private Button adminArayüzü_solPencere_dashboard;

    private double x = 0;
    private double y = 0;

    public void logout(){
        try{

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Bilgilendirici Mesaj");
            alert.setHeaderText(null);
            alert.setContentText("Çıkış Yapmak İstediğinden Emin Misin?");

            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){

                geriÇıkış.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("arayüzSınıfları/girişEkranı.fxml"));
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
                stage.show();;

            }else return;



        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        System.exit(0);
    }

    public void aşağıAl(){
        Stage stage = (Stage)adminMain_Form.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void switchForm(ActionEvent event){
        if(event.getSource() == adminArayüzü_solPencere_ürünEkle){
            istatistikEkranı.setVisible(false);
            productEkleme_form.setVisible(true);

            adminArayüzü_solPencere_ürünEkle.setStyle("-fx-background-color:linear-gradient(to top right,#4336d7,#bab8d4)");
            adminArayüzü_solPencere_dashboard.setStyle("-fx-background-color:Transparent");


        }else if(event.getSource() == adminArayüzü_solPencere_dashboard){
            istatistikEkranı.setVisible(true);
            productEkleme_form.setVisible(false);

            adminArayüzü_solPencere_dashboard.setStyle("-fx-background-color:linear-gradient(to top right,#4336d7,#bab8d4)");
            adminArayüzü_solPencere_ürünEkle.setStyle("-fx-background-color:Transparent");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
