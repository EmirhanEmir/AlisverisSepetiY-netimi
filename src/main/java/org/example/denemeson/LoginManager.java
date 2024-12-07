package org.example.denemeson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginManager {
    private static final String ADMIN_FILE_PATH = "C:/Users/emirh/OneDrive/Masaüstü/DenemeSon/src/main/resources/org/example/denemeson/kullanıcıBilgileri/admin.txt";
    private static final String EMPLOYEE_FILE_PATH = "C:/Users/emirh/OneDrive/Masaüstü/DenemeSon/src/main/resources/org/example/denemeson/kullanıcıBilgileri/employee.txt";
    //Admin doğrulama methodu
    public static boolean adminDoğrulama(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ADMIN_FILE_PATH))){
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

    //Employee doğrulama methodu
    public static boolean employeeDoğrulama(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE_PATH))){
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


    //admin Ekleme methodu
    public static void adminKullanıcıEkle(String username, String password) {
        try (FileWriter writer = new FileWriter(EMPLOYEE_FILE_PATH, true)) {// true dosya ekleme modu
            BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE_PATH));
            String line;
            boolean varmı = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(username)) {
                        varmı = true;
                        break;
                    }else{
                        varmı = false;
                    }
                }
            }
            if(varmı){
                System.out.println("kullanıcı aktif");
            }else{
                writer.write(username +","+password+"\n");
                System.out.println("ekleme yapıldı");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Epmloyee Ekleme MEthodu
    public static void employeeKullanıcıEkle(String username, String password) {
        try (FileWriter writer = new FileWriter(EMPLOYEE_FILE_PATH, true)) {// true dosya ekleme modu
            BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_FILE_PATH));
            String line;
            boolean varmı = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(username)) {
                        varmı = true;
                        break;
                    }else{
                        varmı = false;
                    }
                }
            }
            if(varmı){
                System.out.println("kullanıcı aktif");
            }else{
                writer.write(username +","+password+"\n");
                System.out.println("ekleme yapıldı");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
