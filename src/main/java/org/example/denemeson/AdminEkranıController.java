package org.example.denemeson;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminEkranıController implements Initializable {

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

    public void close(){
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
