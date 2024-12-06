package org.example.denemeson;

public class KullanıcıDeneme {




    public static void main(String[] args) {
        LoginManager login = new LoginManager();

        login.addUser("emirhan","1234");
        login.addUser("nisa","123445");

        if(login.authenticate("emirhan","1234")){
            System.out.println("giriş başarılı");
        }else{
            System.out.println("giriş başarısız");
        }
    }
}
