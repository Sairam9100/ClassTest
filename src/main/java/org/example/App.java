package org.example;

import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App 
{
    public boolean login_mail(String email,String password){
        ResourceBundle a = ResourceBundle.getBundle("config");
        String mail = a.getString("mail");
        String pass = a.getString("pass");

        if(mail.equals(email) && pass.equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
}
