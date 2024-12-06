package org.example.denemeson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductStorage {

    private List<Product> productList = new ArrayList<>();
    private final String filePath = "products.json";

    //ürün ekleme
    public void addProduct(Product product) {
        productList.add(product);
        saveToFile();
    }

    public void removeProduct(String productName) {
        productList.removeIf(product -> product.getName().equalsIgnoreCase(productName));
    }

    //ürünleri JSON dosyasına kasydetme
    public void saveToFile(){
        try(FileWriter writer = new FileWriter(filePath)){
            Gson gson = new Gson();
            gson.toJson(productList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //JSON dosyasından ürünleri yükle
    public void loadFromFile() {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type productListType = new TypeToken<List<Product>>() {
            }.getType();
            productList = gson.fromJson(reader, productListType);
            if (productList == null) {
                productList = new ArrayList<>();
            }
        } catch (IOException e) {
            // dosya yoksa yeni liste başlat
            productList = new ArrayList<>();
        }
    }


    public List<Product> getProductList(){
        return productList;
    }
}
