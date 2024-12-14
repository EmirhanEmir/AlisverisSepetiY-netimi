package org.example.denemeson;

public class KullanıcıDeneme {




    public static void main(String[] args) {
        LoginManager login = new LoginManager();

        login.employeeKullanıcıEkle("kadir","1234","mor");

        login.adminKullanıcıEkle("kadir","1234","yaşil");
        login.adminKullanıcıEkle("nisa","123445","sari");

        if(login.adminDoğrulama("nisa","123445")){
            System.out.println("giriş başarılı");
        }else{
            System.out.println("giriş başarısız");
        }
    }
}
