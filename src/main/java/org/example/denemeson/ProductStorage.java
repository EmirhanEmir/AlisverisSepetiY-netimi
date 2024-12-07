package org.example.denemeson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductStorage {
    private static final String FILE_PATH = "C:/Users/emirh/OneDrive/Masaüstü/DenemeSon/src/main/resources/org/example/denemeso/ProductStorage.txt";

    //Ürünleri dosyadan oku
    public static List<Product> readProduct() {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                int stock = Integer.parseInt(parts[2]);
                products.add(new Product(name, price, stock));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    //Ürünleri dosyaya yaz
    public static void ürünleriDosyayaYaz(List<Product> products) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            for(Product product : products){
                writer.write(product.toString());
                writer.newLine();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Yeni Ürün ekle
    public static void ürünEkle(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(product.toString());
            writer.newLine();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }




}


