package org.example.denemeson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MusteriEkraniController implements Initializable {


    @FXML
    private AnchorPane ana_ekran;

    @FXML
    private Button close;

    @FXML
    private Button cıkıs;

    @FXML
    private Button fişGüncelleBTN;

    @FXML
    private Button fişKaldırBTN;

    @FXML
    private Label fişToplam;

    @FXML
    private Spinner<?> fişUrunMiktar;

    @FXML
    private Button fişÖdemeBTN;

    @FXML
    private Button minimize;

    @FXML
    private TableColumn<Product, String> purchase_co_fiyat;

    @FXML
    private TableColumn<Product, String> purchase_co_isim;

    @FXML
    private TableColumn<Product, String> purchase_co_urunId;

    @FXML
    private TableColumn<Product, String> purchase_co_miktar;

    @FXML
    private Button purchase_eklebtn;

    @FXML
    private TextField purchase_ürünId;

    @FXML
    private Spinner<Integer> purchase_miktar;

    @FXML
    private Label purchase_musteriId;

    @FXML
    private Button purchase_odeme;

    @FXML
    private TableView<Product> purchase_tableview;

    @FXML
    private Label purchase_toplam;

    @FXML
    private AnchorPane sepet;

    @FXML
    private Button sepetBtn;

    @FXML
    private TableView<Product> sepetTablo;

    @FXML
    private TableColumn<Product, String> sepetTablo_fiyat;

    @FXML
    private TableColumn<Product, String> sepetTablo_urunID;

    @FXML
    private TableColumn<Product, String> sepetTablo_urunMiktar;

    @FXML
    private TableColumn<Product, String> sepetTablo_urunİsmi;

    @FXML
    private Button satınAlBTN;

    @FXML
    private TextField purchase_ürünİsmi;

    @FXML
    private AnchorPane satınAlım;


    private SpinnerValueFactory spinner;

    public void satınAlımTabloMiktarSeçimi(){
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1);
        purchase_miktar.setValueFactory(spinner);
    }

    public void tablodanUrunSeçme(){
        Product prod = purchase_tableview.getSelectionModel().getSelectedItem();
        int num = purchase_tableview.getSelectionModel().getSelectedIndex();
        if((num-1) < -1){
            return;
        }

        purchase_ürünId.setText(String.valueOf(prod.getId()));
        purchase_ürünId.setEditable(false);
        purchase_ürünİsmi.setText(prod.getName());
        purchase_ürünİsmi.setEditable(false);

        int miktar = prod.getStock();

        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, miktar, 0);
        purchase_miktar.setValueFactory(spinner);

    }

    VeriIşlemleri sepetVerisi = new VeriIşlemleri();

    ObservableList<Product> sepetProductList = FXCollections.observableArrayList();
    public void sepeteEkleBtn(){
        try {
            Alert alert;
            //ürün ekleme verilerinin eksik olup olmadığını kontrol ediyoruz
            if (purchase_ürünId.getText().isEmpty() || purchase_ürünİsmi.getText().isEmpty()|| purchase_miktar.getValue()==0)   {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Lütfen Tüm Alanları Doldurduğunuzdan Emin Olunuz");
                alert.showAndWait();
            }else{
                //bu ID de ürün kayıtlımı diye kontrol ediyoruz
                if (!idKontrol(AdminEkranıController.veri.root,Integer.parseInt(purchase_ürünId.getText()))){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Seçilen ID de ürün bulunmamaktadır");
                    alert.showAndWait();
                }else{

                    UrunKutusu işaretci = AdminEkranıController.veri.root;
                    while(işaretci!=null){
                        if(işaretci.product.getId()==Integer.parseInt(purchase_ürünId.getText())){
                            break;
                        }
                        if(işaretci.product.getId()>Integer.parseInt(purchase_ürünId.getText())){
                            işaretci = işaretci.sol;
                        }else{
                            işaretci = işaretci.sağ;
                        }
                    }





                    if(idKontrol(sepetVerisi.root,işaretci.product.getId())){
                        UrunKutusu işaretci3 = sepetVerisi.root;

                        System.out.println("aynı ürün" );
                        while(işaretci3!=null){
                            if(işaretci3.product.getId()==Integer.parseInt(purchase_ürünId.getText())){
                                System.out.println("buldu");
                                break;
                            }
                            if(işaretci3.product.getId()>Integer.parseInt(purchase_ürünId.getText())){
                                işaretci3 = işaretci3.sol;
                            }else{
                                işaretci3 = işaretci3.sağ;
                            }
                        }
                        System.out.println(işaretci3.product.getStock());
                        işaretci3.product.setStock(işaretci3.product.getStock()+purchase_miktar.getValue());
                        System.out.println(işaretci3.product.getStock());
                        System.out.println("ürün miktarı arttırma");

                    }else{
                        UrunKutusu işaretci2 = new UrunKutusu(işaretci.product.getId(), işaretci.product.getName(), işaretci.product.getPrice(), işaretci.product.getStock(), işaretci.product.getDurum());
                        işaretci2.product.setStock(purchase_miktar.getValue());
                        sepetVerisi.root = sepetVerisi.urunEkle(sepetVerisi.root,işaretci2.product.getId(),işaretci2.product.getName(),işaretci2.product.getPrice(),işaretci2.product.getStock(),işaretci2.product.getDurum());
                        System.out.println(işaretci2.product.getStock());
                    }


                    int i = (işaretci.product.getStock())-(purchase_miktar.getValue());
                    işaretci.product.setStock(i);


                    AdminEkranıController.ağacıDolaşma(sepetVerisi.root,sepetProductList,0);





                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Ürün Başarıyla Sepete Eklendi");
                    alert.showAndWait();

                    textleriTemizle();

                    AdminEkranıController.ağacıDolaşma(AdminEkranıController.veri.root,AdminEkranıController.productList,0);
                    tablodaUrunGösterimi();
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean idKontrol(UrunKutusu node, int id){

        UrunKutusu işaretci = node;
        while(işaretci!=null){
            if(işaretci.product.getId()==id){
                return true;
            }
            if(işaretci.product.getId()>id){
                işaretci = işaretci.sol;
            }else{
                işaretci = işaretci.sağ;
            }
        }
        return false;
    }


    public void displayMusteriId() {
        purchase_musteriId.setText(kullaniciAdiVerme.employee);
    }

    public void textleriTemizle() {
        purchase_ürünId.clear();
        purchase_ürünİsmi.clear();
        purchase_miktar.getValueFactory().setValue(0);
    }

    private double x=0;
    private double y=0;

    public void logout(){
        try{

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Bilgilendirici Mesaj");
            alert.setHeaderText(null);
            alert.setContentText("Çıkış Yapmak İstediğinden Emin Misin?");

            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){

                cıkıs.getScene().getWindow().hide();

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

    public void minimize(){
        Stage stage = (Stage)ana_ekran.getScene().getWindow();
        stage.setIconified(true);
    }

    public void ekranDeğiş(ActionEvent event){
        if(event.getSource() == satınAlBTN){
            sepet.setVisible(false);
            satınAlım.setVisible(true);
            satınAlBTN.setStyle("-fx-background-color:linear-gradient(to top right,#4336d7,#bab8d4)");
            sepetBtn.setStyle("-fx-background-color:Transparent");
        }else if(event.getSource() == sepetBtn){
            sepet.setVisible(true);
            satınAlım.setVisible(false);
            sepetBtn.setStyle("-fx-background-color:linear-gradient(to top right,#4336d7,#bab8d4)");
            satınAlBTN.setStyle("-fx-background-color:Transparent");
        }

    }





    public void tablodaUrunGösterimi(){

        purchase_co_urunId.setCellValueFactory(new PropertyValueFactory<>("id"));
        purchase_co_miktar.setCellValueFactory(new PropertyValueFactory<>("stock"));
        purchase_co_isim.setCellValueFactory(new PropertyValueFactory<>("name"));
        purchase_co_fiyat.setCellValueFactory(new PropertyValueFactory<>("price"));

        purchase_tableview.setItems(AdminEkranıController.productList);

    }

    public void sepettablodaUrunGösterimi(){

        sepetTablo_urunID.setCellValueFactory(new PropertyValueFactory<>("id"));
        sepetTablo_urunİsmi.setCellValueFactory(new PropertyValueFactory<>("stock"));
        sepetTablo_urunMiktar.setCellValueFactory(new PropertyValueFactory<>("name"));
        sepetTablo_fiyat.setCellValueFactory(new PropertyValueFactory<>("price"));

        sepetTablo.setItems(sepetProductList);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayMusteriId();
        tablodaUrunGösterimi();
        satınAlımTabloMiktarSeçimi();
        sepettablodaUrunGösterimi();
    }
}
