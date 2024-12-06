package org.example.denemeson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginManager {
    private static final String FILE_PATH = "C:/Users/emirh/OneDrive/Masaüstü/DenemeSon/src/main/resources/org/example/denemeson/users.txt";

    //kullanıcı doğrulama methodu
    public static boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void addUser(String username, String password) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {// true dosya ekleme modu
            writer.write(username +","+password+"\n");
            System.out.println("ekleme yapıldı");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
